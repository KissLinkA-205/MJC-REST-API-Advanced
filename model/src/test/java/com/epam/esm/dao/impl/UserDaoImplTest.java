package com.epam.esm.dao.impl;

import com.epam.esm.dao.UserDao;
import com.epam.esm.config.DaoConfig;
import com.epam.esm.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DaoConfig.class)
class UserDaoImplTest {
    private final UserDao userDao;

    private static final User USER_1 = new User(1, "name1");
    private static final User USER_2 = new User(2, "name2");

    private static final Pageable pageRequest = PageRequest.of(0, 5);

    @Autowired
    public UserDaoImplTest(UserDao userDao) {
        this.userDao = userDao;
    }

    @Test
    public void testFindAll() {
        List<User> actual = userDao.findAll(pageRequest);
        List<User> expected = Arrays.asList(USER_1, USER_2);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindById() {
        Optional<User> actual = userDao.findById(USER_2.getId());
        Optional<User> expected = Optional.of(USER_2);

        assertEquals(expected, actual);
    }
}