package com.epam.esm.dao.impl;

import com.epam.esm.dao.OrderDao;
import com.epam.esm.config.DaoConfig;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Order;
import com.epam.esm.entity.Tag;
import com.epam.esm.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DaoConfig.class)
@Transactional
class OrderDaoImplTest {
    private final OrderDao orderDao;

    private static final User USER_1 = new User(1, "name1");

    private static final GiftCertificate GIFT_CERTIFICATE_1 = new GiftCertificate(1, "giftCertificate1",
            "description1", new BigDecimal("10.10"), 1, LocalDateTime.parse("2020-08-29T06:12:15"),
            LocalDateTime.parse("2020-08-29T06:12:15"), Arrays.asList(new Tag(2, "tagName3"), new Tag(5, "tagName2")));
    private static final GiftCertificate GIFT_CERTIFICATE_2 = new GiftCertificate(2, "giftCertificate3",
            "description3", new BigDecimal("30.30"), 3, LocalDateTime.parse("2019-08-29T06:12:15"),
            LocalDateTime.parse("2019-08-29T06:12:15"), Collections.singletonList(new Tag(2, "tagName3")));

    private static final Order ORDER_1 = new Order(1, new BigDecimal("10.10"),
            LocalDateTime.parse("2018-08-29T06:12:15"), USER_1, GIFT_CERTIFICATE_1);
    private static final Order ORDER_2 = new Order(2, new BigDecimal("30.30"),
            LocalDateTime.parse("2018-08-29T06:12:15"), USER_1, GIFT_CERTIFICATE_2);

    private static final Pageable pageRequest = PageRequest.of(0, 5);

    @Autowired
    public OrderDaoImplTest(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Test
    public void testFindById() {
        Optional<Order> actual = orderDao.findById(ORDER_2.getId());
        Optional<Order> expected = Optional.of(ORDER_2);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindByUserId() {
        List<Order> expected = Arrays.asList(ORDER_1, ORDER_2);
        List<Order> actual = orderDao.findByUserId(ORDER_1.getUser().getId(), pageRequest);

        assertEquals(expected, actual);
    }
}