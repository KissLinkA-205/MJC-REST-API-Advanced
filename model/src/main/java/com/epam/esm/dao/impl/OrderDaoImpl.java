package com.epam.esm.dao.impl;

import com.epam.esm.dao.AbstractDao;
import com.epam.esm.dao.OrderDao;
import com.epam.esm.dao.creator.QueryCreator;
import com.epam.esm.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Optional;

/**
 * Class {@code OrderDaoImpl} is implementation of interface {@link OrderDao}
 * and intended to work with {@link com.epam.esm.entity.Order} table.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Repository
@Transactional
public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    private static final String FIND_BY_USER_ID_QUERY = "SELECT o FROM " + Order.class.getName()
            + " o WHERE o.user.id = :user_id";

    public OrderDaoImpl() {
        super(Order.class);
    }

    @Override
    protected QueryCreator<Order> getQueryCreator() {
        return null;
    }

    @Override
    public List<Order> findAll(Pageable pageable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Order> findWithFilters(MultiValueMap<String, String> fields, Pageable pageable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Order> findByName(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Order> findByUserId(long userId, Pageable pageable) {
        return entityManager.createQuery(FIND_BY_USER_ID_QUERY, entityType)
                .setParameter("user_id", userId)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();
    }
}
