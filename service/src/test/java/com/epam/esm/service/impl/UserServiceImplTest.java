package com.epam.esm.service.impl;

import com.epam.esm.dao.impl.UserDaoImpl;
import com.epam.esm.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserDaoImpl userDao = Mockito.mock(UserDaoImpl.class);

    @InjectMocks
    private UserServiceImpl userService;

    private static final User USER_1 = new User(1, "name1");
    private static final User USER_2 = new User(2, "name2");
    private static final User USER_3 = new User(3, "name3");

    private static final int PAGE = 0;
    private static final int SIZE = 5;

    @Test
    public void testGetById() {
        when(userDao.findById(USER_1.getId())).thenReturn(Optional.of(USER_1));

        User actual = userService.getById(USER_1.getId());
        User expected = USER_1;

        assertEquals(expected, actual);
    }

    @Test
    public void testGetAll() {
        List<User> users = Arrays.asList(USER_1, USER_2, USER_3);
        Pageable pageRequest = PageRequest.of(PAGE, SIZE);
        when(userDao.findAll(pageRequest)).thenReturn(users);

        List<User> actual = userService.getAll(PAGE, SIZE);
        List<User> expected = users;

        assertEquals(expected, actual);
    }
}