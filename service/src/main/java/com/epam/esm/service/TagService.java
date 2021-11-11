package com.epam.esm.service;

import com.epam.esm.entity.Tag;

/**
 * Interface {@code TagService} describes abstract behavior for working with {@link Tag} objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface TagService extends CRDService<Tag> {

    /**
     * Find most popular tag of user with highest cost of all orders.
     *
     * @return the found tag
     */
    Tag getMostPopularTagOfUserWithHighestCostOfAllOrders();
}
