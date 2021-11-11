package com.epam.esm.service.impl;

import com.epam.esm.dao.CRDDao;
import com.epam.esm.entity.Order;
import com.epam.esm.entity.User;
import com.epam.esm.exception.ExceptionMessageKey;
import com.epam.esm.exception.NoSuchEntityException;
import com.epam.esm.service.AbstractService;
import com.epam.esm.service.OrderService;
import com.epam.esm.service.UserService;
import com.epam.esm.validator.IdentifiableValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Optional;

/**
 * Class {@code UserServiceImpl} is implementation of interface {@link UserService}
 * and intended to work with {@link User} objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Autowired
    public UserServiceImpl(CRDDao<User> dao) {
        super(dao);
    }

    @Override
    public User update(long id, User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public User insert(User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> doFilter(MultiValueMap<String, String> requestParams, int page, int size) {
        throw new UnsupportedOperationException();
    }
}
