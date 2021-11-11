package com.epam.esm.logic.renovator.impl;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.logic.handler.DateHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GiftCertificateRenovatorTest {

    @Mock
    private DateHandler dateHandler = Mockito.mock(DateHandler.class);
    private static final LocalDateTime UPDATED_DATE = LocalDateTime.parse("2021-10-24T06:12:00.156");

    @InjectMocks
    private GiftCertificateRenovator renovator;

    private static final GiftCertificate OLD_GIFT_CERTIFICATE = new GiftCertificate(1, "giftCertificate",
            "description", new BigDecimal("10.115"), 1, LocalDateTime.parse("2020-08-29T06:12:15.156"),
            LocalDateTime.parse("2020-08-29T06:12:15.156"), Collections.singletonList(new Tag(1, "tagName1")));

    private static final GiftCertificate NEW_GIFT_CERTIFICATE = new GiftCertificate(0, "newGiftCertificate",
            "newGiftCertificate", null, 2, null, null,
            Arrays.asList(new Tag(1, "tagName1"), new Tag(2, "tagName2")));

    private static final GiftCertificate UPDATED_GIFT_CERTIFICATE = new GiftCertificate(1, "newGiftCertificate",
            "newGiftCertificate", new BigDecimal("10.115"), 2, LocalDateTime.parse("2020-08-29T06:12:15.156"),
            UPDATED_DATE, Arrays.asList(new Tag(1, "tagName1"),
            new Tag(2, "tagName2")));


    @Test
    void testUpdateObject() {
        when(dateHandler.getCurrentDate()).thenReturn(UPDATED_DATE);

        GiftCertificate actual = renovator.updateObject(NEW_GIFT_CERTIFICATE, OLD_GIFT_CERTIFICATE);
        GiftCertificate expected = UPDATED_GIFT_CERTIFICATE;
        assertEquals(expected, actual);
    }
}