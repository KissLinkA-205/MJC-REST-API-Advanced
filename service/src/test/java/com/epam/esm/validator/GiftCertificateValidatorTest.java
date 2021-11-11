package com.epam.esm.validator;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.exception.ExceptionResult;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GiftCertificateValidatorTest {
    private static final List<Tag> INCORRECT_TAGS = Arrays.asList(new Tag("1"), new Tag("2"));
    private static final List<Tag> CORRECT_TAGS = Arrays.asList(new Tag("tagName1"), new Tag("tagName2"));

    private static final GiftCertificate INCORRECT_GIFT_CERTIFICATE = new GiftCertificate(1, " ",
            " ", new BigDecimal("10.115"), 1, LocalDateTime.parse("2020-08-29T06:12:15.156"),
            LocalDateTime.parse("2020-08-29T06:12:15.156"), INCORRECT_TAGS);
    private static final GiftCertificate CORRECT_GIFT_CERTIFICATE = new GiftCertificate(0, "giftCertificate",
            "description", new BigDecimal("10.15"), 1, LocalDateTime.parse("2020-08-29T06:12:15.156"),
            LocalDateTime.parse("2020-08-29T06:12:15.156"), CORRECT_TAGS);

    @Test
    void testValidate_incorrectData() {
        ExceptionResult exceptionResult = new ExceptionResult();
        GiftCertificateValidator.validate(INCORRECT_GIFT_CERTIFICATE, exceptionResult);
        assertFalse(exceptionResult.getExceptionMessages().isEmpty());
    }

    @Test
    void testValidate_correctData() {
        ExceptionResult exceptionResult = new ExceptionResult();
        GiftCertificateValidator.validate(CORRECT_GIFT_CERTIFICATE, exceptionResult);
        assertTrue(exceptionResult.getExceptionMessages().isEmpty());
    }

    @Test
    void testValidateForUpdate_incorrectData() {
        ExceptionResult exceptionResult = new ExceptionResult();
        GiftCertificateValidator.validateForUpdate(INCORRECT_GIFT_CERTIFICATE, exceptionResult);
        assertFalse(exceptionResult.getExceptionMessages().isEmpty());
    }

    @Test
    void testValidateForUpdate_correctData() {
        ExceptionResult exceptionResult = new ExceptionResult();
        GiftCertificateValidator.validateForUpdate(CORRECT_GIFT_CERTIFICATE, exceptionResult);
        assertTrue(exceptionResult.getExceptionMessages().isEmpty());
    }

    @Test
    void testValidateListOfTags_incorrectData() {
        ExceptionResult exceptionResult = new ExceptionResult();
        GiftCertificateValidator.validateListOfTags(INCORRECT_TAGS, exceptionResult);
        assertFalse(exceptionResult.getExceptionMessages().isEmpty());
    }

    @Test
    void testValidateListOfTags_correctData() {
        ExceptionResult exceptionResult = new ExceptionResult();
        GiftCertificateValidator.validateListOfTags(CORRECT_TAGS, exceptionResult);
        assertTrue(exceptionResult.getExceptionMessages().isEmpty());
    }
}