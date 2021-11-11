package com.epam.esm.service;

import com.epam.esm.entity.Order;

import java.util.List;

/**
 * Interface {@code OrderService} describes abstract behavior for working with {@link Order} objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface OrderService extends CRDService<Order> {

    /**
     * Method for getting list of {@link Order} from database by user ID.
     *
     * @param userId ID of user
     * @param page   page number for pagination
     * @param size   page size for pagination
     * @return list of orders
     */
    List<Order> getOrdersByUserId(long userId, int page, int size);
}
