package com.epam.esm.validator;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Order;
import com.epam.esm.entity.User;
import com.epam.esm.exception.ExceptionResult;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderValidatorTest {
    private static final Order INCORRECT_ORDER = new Order(1, new BigDecimal("10.5"),
            LocalDateTime.parse("2020-08-29T06:12:15.156"), new User(-1, null),
            new GiftCertificate(-5, null, null, new BigDecimal("12"), 2,
                    LocalDateTime.parse("2018-08-29T06:12:15"), LocalDateTime.parse("2018-08-29T06:12:15"), null));

    private static final Order CORRECT_ORDER = new Order(0, new BigDecimal("10.5"),
            LocalDateTime.parse("2020-08-29T06:12:15.156"), new User(1, "name1"),
            new GiftCertificate(5, null, null, new BigDecimal("12"), 2,
                    LocalDateTime.parse("2018-08-29T06:12:15"), LocalDateTime.parse("2018-08-29T06:12:15"), null));

    @Test
    void testValidate_incorrectData() {
        ExceptionResult exceptionResult = new ExceptionResult();
        OrderValidator.validate(INCORRECT_ORDER, exceptionResult);
        assertFalse(exceptionResult.getExceptionMessages().isEmpty());
    }

    @Test
    void testValidate_correctData() {
        ExceptionResult exceptionResult = new ExceptionResult();
        OrderValidator.validate(CORRECT_ORDER, exceptionResult);
        assertTrue(exceptionResult.getExceptionMessages().isEmpty());
    }
}