package com.epam.esm.dao.impl;

import com.epam.esm.dao.AbstractDao;
import com.epam.esm.dao.UserDao;
import com.epam.esm.dao.creator.QueryCreator;
import com.epam.esm.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Optional;

/**
 * Class {@code UserDaoImpl} is implementation of interface {@link UserDao}
 * and intended to work with {@link com.epam.esm.entity.User} table.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String FIND_USER_ID_BY_HIGHEST_COST_OF_ALL_ORDERS_QUERY =
            "SELECT o.user.id FROM Order o GROUP BY o.user.id ORDER BY SUM(o.price) DESC";

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    protected QueryCreator<User> getQueryCreator() {
        return null;
    }

    @Override
    public User update(User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> findWithFilters(MultiValueMap<String, String> fields, Pageable pageable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public User insert(User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<User> findByHighestCostOfAllOrders() {
        Optional<Long> userId = findIdOfUserByHighestCostOfAllOrders();
        return userId.map(this::findById).orElse(null);
    }

    @Override
    public Optional<User> findByName(String name) {
        throw new UnsupportedOperationException();
    }

    private Optional<Long> findIdOfUserByHighestCostOfAllOrders() {
        return entityManager.createQuery(FIND_USER_ID_BY_HIGHEST_COST_OF_ALL_ORDERS_QUERY, Long.class)
                .setMaxResults(1)
                .getResultList().stream()
                .findFirst();
    }
}
