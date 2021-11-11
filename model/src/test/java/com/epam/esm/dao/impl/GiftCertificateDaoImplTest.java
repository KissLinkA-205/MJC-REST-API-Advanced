package com.epam.esm.dao.impl;

import com.epam.esm.dao.GiftCertificateDao;
import com.epam.esm.config.DaoConfig;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

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
class GiftCertificateDaoImplTest {
    private final GiftCertificateDao giftCertificateDao;

    private static final Tag TAG_2 = new Tag(2, "tagName3");

    private static final GiftCertificate GIFT_CERTIFICATE_1 = new GiftCertificate(1, "giftCertificate1",
            "description1", new BigDecimal("10.10"), 1, LocalDateTime.parse("2020-08-29T06:12:15"),
            LocalDateTime.parse("2020-08-29T06:12:15"), Arrays.asList(new Tag(2, "tagName3"), new Tag(5, "tagName2")));
    private static final GiftCertificate GIFT_CERTIFICATE_2 = new GiftCertificate(2, "giftCertificate3",
            "description3", new BigDecimal("30.30"), 3, LocalDateTime.parse("2019-08-29T06:12:15"),
            LocalDateTime.parse("2019-08-29T06:12:15"), Collections.singletonList(new Tag(2, "tagName3")));
    private static final GiftCertificate GIFT_CERTIFICATE_3 = new GiftCertificate(3, "giftCertificate2",
            "description2", new BigDecimal("20.20"), 2, LocalDateTime.parse("2018-08-29T06:12:15"),
            LocalDateTime.parse("2018-08-29T06:12:15"), Collections.singletonList(new Tag(3, "tagName5")));

    private static final String SORT_PARAMETER = "ASC";
    private static final Pageable pageRequest = PageRequest.of(0, 5);

    @Autowired
    public GiftCertificateDaoImplTest(GiftCertificateDao giftCertificateDao) {
        this.giftCertificateDao = giftCertificateDao;
    }

    @Test
    public void testFindAll() {
        List<GiftCertificate> actual = giftCertificateDao.findAll(pageRequest);
        List<GiftCertificate> expected = Arrays.asList(GIFT_CERTIFICATE_1, GIFT_CERTIFICATE_2, GIFT_CERTIFICATE_3);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindById() {
        Optional<GiftCertificate> actual = giftCertificateDao.findById(GIFT_CERTIFICATE_2.getId());
        Optional<GiftCertificate> expected = Optional.of(GIFT_CERTIFICATE_2);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetWithFilters() {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("sortByName", SORT_PARAMETER);
        parameters.add("tag_name", TAG_2.getName());
        List<GiftCertificate> actual = giftCertificateDao.findWithFilters(parameters, pageRequest);
        List<GiftCertificate> expected = Arrays.asList(GIFT_CERTIFICATE_1, GIFT_CERTIFICATE_2);

        assertEquals(expected, actual);
    }
}