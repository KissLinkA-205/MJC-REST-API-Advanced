package com.epam.esm.dao.impl;

import com.epam.esm.dao.AbstractDao;
import com.epam.esm.dao.GiftCertificateDao;
import com.epam.esm.dao.creator.QueryCreator;
import com.epam.esm.entity.GiftCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class {@code GiftCertificateDaoImpl} is implementation of interface {@link GiftCertificateDao}
 * and intended to work with {@link com.epam.esm.entity.GiftCertificate} table.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Repository
@Transactional
public class GiftCertificateDaoImpl extends AbstractDao<GiftCertificate> implements GiftCertificateDao {
    private final QueryCreator<GiftCertificate> queryCreator;

    private static final String REMOVE_GIFT_CERTIFICATES_HAS_TAGS_QUERY = "DELETE FROM gift_certificates_has_tags " +
            "WHERE gift_certificate_id = :gift_certificate_id_fk";

    @Autowired
    public GiftCertificateDaoImpl(QueryCreator<GiftCertificate> queryCreator) {
        super(GiftCertificate.class);
        this.queryCreator = queryCreator;
    }

    @Override
    protected QueryCreator<GiftCertificate> getQueryCreator() {
        return queryCreator;
    }

    @Override
    public GiftCertificate update(GiftCertificate giftCertificate) {
        return entityManager.merge(giftCertificate);
    }

    @Override
    public void removeGiftCertificateHasTag(long id) {
        entityManager.createNativeQuery(REMOVE_GIFT_CERTIFICATES_HAS_TAGS_QUERY)
                .setParameter("gift_certificate_id_fk", id)
                .executeUpdate();
    }
}