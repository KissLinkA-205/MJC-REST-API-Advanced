package com.epam.esm.dao;

import com.epam.esm.entity.Tag;

import java.util.Optional;

/**
 * Interface {@code TagDao} describes abstract behavior for working with
 * {@link com.epam.esm.entity.Tag} in database.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface TagDao extends CRDDao<Tag> {

    /**
     * Method for getting a tag from a table with a specific name.
     *
     * @param name name of tag to get
     * @return Optional of tag entity
     */
    Optional<Tag> findByName(String name);

    /**
     * @param userId the user id to find most popular tag
     * @return Optional of found tag
     * @deprecated Method for finding the most popular tag of user in database.
     */
    @Deprecated
    Optional<Tag> findByMostPopularOfUser(long userId);

    /**
     * Method for finding the most popular tag of user with the highest cost of all orders in database.
     *
     * @return Optional of found tag
     */
    Optional<Tag> findMostPopularTagOfUserWithHighestCostOfAllOrders();

    /**
     * Method for deleting links between gift certificates and tags.
     *
     * @param id ID of tag by which the deletion will be
     */
    void removeGiftCertificateHasTag(long id);
}
