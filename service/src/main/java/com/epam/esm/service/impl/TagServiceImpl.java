package com.epam.esm.service.impl;

import com.epam.esm.dao.CRDDao;
import com.epam.esm.dao.TagDao;
import com.epam.esm.entity.Tag;
import com.epam.esm.exception.*;
import com.epam.esm.service.AbstractService;
import com.epam.esm.service.TagService;
import com.epam.esm.validator.IdentifiableValidator;
import com.epam.esm.validator.TagValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.epam.esm.dao.creator.FilterParameters.NAME;
import static com.epam.esm.dao.creator.FilterParameters.SORT_BY_NAME;
import static com.epam.esm.exception.ExceptionMessageKey.TAG_NOT_FOUND;

/**
 * Class {@code TagServiceImpl} is implementation of interface {@link TagService} and intended to work with {@link Tag} objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Service
public class TagServiceImpl extends AbstractService<Tag> implements TagService {
    private final TagDao tagDao;

    @Autowired
    public TagServiceImpl(CRDDao<Tag> dao, TagDao tagDao) {
        super(dao);
        this.tagDao = tagDao;
    }

    @Override
    public Tag insert(Tag tag) {
        ExceptionResult exceptionResult = new ExceptionResult();
        TagValidator.validate(tag, exceptionResult);
        if (!exceptionResult.getExceptionMessages().isEmpty()) {
            throw new IncorrectParameterException(exceptionResult);
        }

        String tagName = tag.getName();
        boolean isTagExist = tagDao.findByName(tagName).isPresent();
        if (isTagExist) {
            throw new DuplicateEntityException(ExceptionMessageKey.TAG_EXIST);
        }
        return dao.insert(tag);
    }

    @Override
    @Transactional
    public void removeById(long id) {
        ExceptionResult exceptionResult = new ExceptionResult();
        IdentifiableValidator.validateId(id, exceptionResult);
        if (!exceptionResult.getExceptionMessages().isEmpty()) {
            throw new IncorrectParameterException(exceptionResult);
        }

        Optional<Tag> foundEntity = tagDao.findById(id);
        if (!foundEntity.isPresent()) {
            throw new NoSuchEntityException(ExceptionMessageKey.NO_ENTITY);
        }

        tagDao.removeGiftCertificateHasTag(id);
        tagDao.removeById(id);
    }

    @Override
    public List<Tag> doFilter(MultiValueMap<String, String> requestParams, int page, int size) {

        ExceptionResult exceptionResult = new ExceptionResult();
        String name = getSingleRequestParameter(requestParams, NAME);
        if (name != null) {
            TagValidator.validateName(name, exceptionResult);
        }
        String sortType = getSingleRequestParameter(requestParams, SORT_BY_NAME);
        if (sortType != null) {
            IdentifiableValidator.validateSortType(sortType.toUpperCase(), exceptionResult);
        }
        if (!exceptionResult.getExceptionMessages().isEmpty()) {
            throw new IncorrectParameterException(exceptionResult);
        }

        Pageable pageRequest = createPageRequest(page, size);
        return tagDao.findWithFilters(requestParams, pageRequest);
    }

    @Override
    public Tag getMostPopularTagOfUserWithHighestCostOfAllOrders() {
        Optional<Tag> optionalTag = tagDao.findMostPopularTagOfUserWithHighestCostOfAllOrders();
        if (!optionalTag.isPresent()) {
            throw new NoSuchEntityException(TAG_NOT_FOUND);
        }
        return optionalTag.get();
    }
}
