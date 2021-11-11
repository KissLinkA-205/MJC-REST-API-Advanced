package com.epam.esm.dao.creator.impl;

import com.epam.esm.dao.creator.AbstractQueryCreator;
import com.epam.esm.entity.GiftCertificate;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.esm.dao.creator.FilterParameters.NAME;
import static com.epam.esm.dao.creator.FilterParameters.TAG_NAME;

/**
 * Class {@code GiftCertificateQueryCreator} is implementation of interface {@link com.epam.esm.dao.creator.QueryCreator}
 * which intended to work with creating query using {@link GiftCertificate}.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Component
public class GiftCertificateQueryCreator extends AbstractQueryCreator<GiftCertificate> {
    private static final Class<GiftCertificate> GIFT_CERTIFICATE_CLASS = GiftCertificate.class;

    private static final String TAGS = "tags";

    @Override
    public CriteriaQuery<GiftCertificate> createGetQuery(MultiValueMap<String, String> fields, CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<GiftCertificate> criteriaQuery = criteriaBuilder.createQuery(GIFT_CERTIFICATE_CLASS);
        Root<GiftCertificate> giftCertificateRoot = criteriaQuery.from(GIFT_CERTIFICATE_CLASS);
        List<Predicate> restrictions = new ArrayList<>();

        restrictions.addAll(addName(fields, criteriaBuilder, giftCertificateRoot));
        restrictions.addAll(addTagNames(fields, criteriaBuilder, giftCertificateRoot));
        restrictions.addAll(addPartOfName(fields, criteriaBuilder, giftCertificateRoot));
        restrictions.addAll(addPartOfDescription(fields, criteriaBuilder, giftCertificateRoot));
        criteriaQuery.select(giftCertificateRoot).where(restrictions.toArray(new Predicate[]{}));
        addSortByName(fields, criteriaBuilder, criteriaQuery, giftCertificateRoot);
        addSortByCreateDate(fields, criteriaBuilder, criteriaQuery, giftCertificateRoot);

        return criteriaQuery;
    }

    private List<Predicate> addTagNames(MultiValueMap<String, String> fields, CriteriaBuilder criteriaBuilder,
                                        Root<GiftCertificate> giftCertificateRoot) {
        List<Predicate> restrictions = new ArrayList<>();

        List<String> tagNames = fields.get(TAG_NAME);
        if (tagNames != null) {
            restrictions = Arrays.stream(tagNames.toArray())
                    .map(tagName -> criteriaBuilder.equal(giftCertificateRoot.join(TAGS).get(NAME), tagName))
                    .collect(Collectors.toList());
        }
        return restrictions;
    }
}
