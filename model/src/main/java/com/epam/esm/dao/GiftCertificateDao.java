package com.epam.esm.dao;

import com.epam.esm.entity.GiftCertificate;

import java.util.Optional;

/**
 * Interface {@code GiftCertificateDao} describes abstract behavior for working with
 * {@link com.epam.esm.entity.GiftCertificate} in database.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface GiftCertificateDao extends CRUDDao<GiftCertificate> {

    /**
     * Method for getting a gift certificate from a table with a specific name.
     *
     * @param name name of gift certificate to get
     * @return Optional of gift certificate entity
     */
    Optional<GiftCertificate> findByName(String name);

    /**
     * Method for deleting links between gift certificates and tags.
     *
     * @param id ID of gift certificate by which the deletion will be
     */
    void removeGiftCertificateHasTag(long id);
}
