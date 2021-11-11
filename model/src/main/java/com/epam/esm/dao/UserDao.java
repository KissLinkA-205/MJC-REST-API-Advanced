package com.epam.esm.dao;

import com.epam.esm.entity.User;

import java.util.Optional;

/**
 * Interface {@code UserDao} describes abstract behavior for working with
 * {@link com.epam.esm.entity.User} in database.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface UserDao extends CRUDDao<User> {

    /**
     * @return Optional of found user
     * @deprecated Method for finding user by highest cost of all orders.
     */
    @Deprecated
    Optional<User> findByHighestCostOfAllOrders();
}
