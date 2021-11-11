package com.epam.esm.logic.renovator.impl;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.logic.handler.DateHandler;
import com.epam.esm.logic.renovator.Renovator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Class {@code GiftCertificateRenovatorImpl} is implementation of interface {@link Renovator}
 * and intended to work with {@link com.epam.esm.entity.GiftCertificate} entity.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Component
public class GiftCertificateRenovator implements Renovator<GiftCertificate> {
    private final DateHandler dateHandler;

    @Autowired
    public GiftCertificateRenovator(DateHandler dateHandler) {
        this.dateHandler = dateHandler;
    }

    @Override
    public GiftCertificate updateObject(GiftCertificate newGiftCertificate, GiftCertificate oldGiftCertificate) {
        String name = newGiftCertificate.getName();
        if (!Objects.isNull(name)) {
            oldGiftCertificate.setName(name);
        }

        String description = newGiftCertificate.getDescription();
        if (!Objects.isNull(description)) {
            oldGiftCertificate.setDescription(description);
        }

        BigDecimal price = newGiftCertificate.getPrice();
        if (!Objects.isNull(price)) {
            oldGiftCertificate.setPrice(price);
        }

        int duration = newGiftCertificate.getDuration();
        if (duration != 0) {
            oldGiftCertificate.setDuration(duration);
        }

        List<Tag> tags = newGiftCertificate.getTags();
        if (!Objects.isNull(tags)) {
            oldGiftCertificate.setTags(tags);
        }

        oldGiftCertificate.setLastUpdateDate(dateHandler.getCurrentDate());
        return oldGiftCertificate;
    }

    @Override
    public List<GiftCertificate> updateListFromDatabase(List<GiftCertificate> newListOfGiftCertificates) {
        throw new UnsupportedOperationException();
    }
}
