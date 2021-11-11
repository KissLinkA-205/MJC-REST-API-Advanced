package com.epam.esm.dao;

import com.epam.esm.entity.Order;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Interface {@code OrderDao} describes abstract behavior for working with
 * {@link com.epam.esm.entity.Order} in database.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface OrderDao extends CRDDao<Order> {

    /**
     * Method for getting list of {@link Order} from a table by user ID.
     *
     * @param userId   ID of user
     * @param pageable object with pagination info (page number, page size)
     * @return list of orders
     */
    List<Order> findByUserId(long userId, Pageable pageable);
}
