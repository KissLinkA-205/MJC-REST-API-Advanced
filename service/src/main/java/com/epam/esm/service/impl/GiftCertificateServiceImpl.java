package com.epam.esm.service.impl;

import com.epam.esm.dao.GiftCertificateDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.exception.*;
import com.epam.esm.logic.handler.DateHandler;
import com.epam.esm.logic.renovator.Renovator;
import com.epam.esm.service.AbstractService;
import com.epam.esm.service.GiftCertificateService;
import com.epam.esm.validator.GiftCertificateValidator;
import com.epam.esm.validator.IdentifiableValidator;
import com.epam.esm.validator.TagValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.epam.esm.dao.creator.FilterParameters.*;

/**
 * Class {@code GiftCertificateServiceImpl} is implementation of interface {@link GiftCertificateService}
 * and intended to work with {@link GiftCertificate} objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Service
public class GiftCertificateServiceImpl extends AbstractService<GiftCertificate> implements GiftCertificateService {
    private final GiftCertificateDao giftCertificateDao;
    private final DateHandler dateHandler;
    private final Renovator<GiftCertificate> renovator;
    private final Renovator<Tag> tagRenovator;

    @Autowired
    public GiftCertificateServiceImpl(GiftCertificateDao giftCertificateDao, DateHandler dateHandler,
                                      Renovator<GiftCertificate> renovator, Renovator<Tag> tagRenovator) {
        super(giftCertificateDao);
        this.giftCertificateDao = giftCertificateDao;
        this.dateHandler = dateHandler;
        this.renovator = renovator;
        this.tagRenovator = tagRenovator;
    }

    @Override
    @Transactional
    public GiftCertificate insert(GiftCertificate giftCertificate) {
        ExceptionResult exceptionResult = new ExceptionResult();
        GiftCertificateValidator.validate(giftCertificate, exceptionResult);
        if (!exceptionResult.getExceptionMessages().isEmpty()) {
            throw new IncorrectParameterException(exceptionResult);
        }

        String giftCertificateName = giftCertificate.getName();
        boolean isGiftCertificateExist = giftCertificateDao.findByName(giftCertificateName).isPresent();
        if (isGiftCertificateExist) {
            throw new DuplicateEntityException(ExceptionMessageKey.GIFT_CERTIFICATE_EXIST);
        }

        giftCertificate.setCreateDate(dateHandler.getCurrentDate());
        giftCertificate.setLastUpdateDate(dateHandler.getCurrentDate());
        removeDuplicateTags(giftCertificate);
        List<Tag> tagsToPersist = tagRenovator.updateListFromDatabase(giftCertificate.getTags());
        giftCertificate.setTags(tagsToPersist);

        return dao.insert(giftCertificate);
    }

    @Override
    @Transactional
    public void removeById(long id) {
        ExceptionResult exceptionResult = new ExceptionResult();
        IdentifiableValidator.validateId(id, exceptionResult);
        if (!exceptionResult.getExceptionMessages().isEmpty()) {
            throw new IncorrectParameterException(exceptionResult);
        }

        Optional<GiftCertificate> foundGiftCertificate = giftCertificateDao.findById(id);
        if (!foundGiftCertificate.isPresent()) {
            throw new NoSuchEntityException(ExceptionMessageKey.NO_ENTITY);
        }

        giftCertificateDao.removeGiftCertificateHasTag(id);
        giftCertificateDao.removeById(id);
    }

    @Override
    @Transactional
    public GiftCertificate update(long id, GiftCertificate giftCertificate) {
        ExceptionResult exceptionResult = new ExceptionResult();
        IdentifiableValidator.validateId(id, exceptionResult);
        GiftCertificateValidator.validateForUpdate(giftCertificate, exceptionResult);
        if (!exceptionResult.getExceptionMessages().isEmpty()) {
            throw new IncorrectParameterException(exceptionResult);
        }

        Optional<GiftCertificate> oldGiftCertificate = dao.findById(id);
        if (!oldGiftCertificate.isPresent()) {
            throw new NoSuchEntityException(ExceptionMessageKey.NO_ENTITY);
        }
        String giftCertificateName = giftCertificate.getName();
        boolean isGiftCertificateExist = giftCertificateDao.findByName(giftCertificateName).isPresent();
        if (isGiftCertificateExist && !oldGiftCertificate.get().getName().equals(giftCertificateName)) {
            throw new DuplicateEntityException(ExceptionMessageKey.GIFT_CERTIFICATE_EXIST);
        }

        removeDuplicateTags(giftCertificate);
        giftCertificate.setTags(tagRenovator.updateListFromDatabase(giftCertificate.getTags()));
        GiftCertificate newGiftCertificate = renovator.updateObject(giftCertificate, oldGiftCertificate.get());
        return giftCertificateDao.update(newGiftCertificate);
    }

    @Override
    public List<GiftCertificate> doFilter(MultiValueMap<String, String> requestParams, int page, int size) {
        ExceptionResult exceptionResult = new ExceptionResult();
        String name = getSingleRequestParameter(requestParams, NAME);
        if (name != null) {
            GiftCertificateValidator.validateName(name, exceptionResult);
        }
        List<String> tagNames = requestParams.get(TAG_NAME);
        if (tagNames != null) {
            for (String tagName : tagNames) {
                TagValidator.validateName(tagName, exceptionResult);
            }
        }
        String sortNameType = getSingleRequestParameter(requestParams, SORT_BY_NAME);
        if (sortNameType != null) {
            IdentifiableValidator.validateSortType(sortNameType.toUpperCase(), exceptionResult);
        }
        String sortCreateDateType = getSingleRequestParameter(requestParams, SORT_BY_CREATE_DATE);
        if (sortCreateDateType != null) {
            IdentifiableValidator.validateSortType(sortCreateDateType.toUpperCase(), exceptionResult);
        }
        if (!exceptionResult.getExceptionMessages().isEmpty()) {
            throw new IncorrectParameterException(exceptionResult);
        }

        Pageable pageRequest = createPageRequest(page, size);
        return giftCertificateDao.findWithFilters(requestParams, pageRequest);
    }

    private void removeDuplicateTags(GiftCertificate giftCertificate) {
        List<Tag> tags = giftCertificate.getTags();
        if (tags != null) {
            List<Tag> result = new ArrayList<>();
            for (Tag tag : tags) {
                if (!result.contains(tag)) {
                    result.add(tag);
                }
            }
            giftCertificate.setTags(result);
        }
    }
}
