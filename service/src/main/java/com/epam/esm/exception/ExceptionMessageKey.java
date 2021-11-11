package com.epam.esm.exception;

import lombok.experimental.UtilityClass;

/**
 * Utility class {@code ExceptionMessageKey} presents keys by which messages will be taken from properties files.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@UtilityClass
public class ExceptionMessageKey {

    /**
     * Keys for exception messages associated with {@link com.epam.esm.entity.Identifiable}.
     */
    public static final String BAD_ID = "identifiable.badID";
    public static final String ID_EXISTENCE = "identifiable.hasId";
    public static final String NO_ENTITY = "identifiable.noObject";

    /**
     * Keys for exception messages associated with {@link com.epam.esm.dao.creator.SortType}.
     */
    public static final String BAD_SORT_TYPE = "sort.badSortType";

    /**
     * Keys for exception messages associated with {@link com.epam.esm.entity.Tag}.
     */
    public static final String BAD_TAG_NAME = "tag.badName";
    public static final String TAG_EXIST = "tag.alreadyExist";
    public static final String TAG_NOT_FOUND = "tag.notFound";

    /**
     * Keys for exception messages associated with {@link com.epam.esm.entity.GiftCertificate}.
     */
    public static final String BAD_GIFT_CERTIFICATE_NAME = "certificate.badName";
    public static final String BAD_GIFT_CERTIFICATE_DESCRIPTION = "certificate.badDescription";
    public static final String BAD_GIFT_CERTIFICATE_PRICE = "certificate.badPrice";
    public static final String BAD_GIFT_CERTIFICATE_DURATION = "certificate.badDuration";
    public static final String GIFT_CERTIFICATE_NOT_FOUND = "certificate.notFound";
    public static final String GIFT_CERTIFICATE_EXIST = "certificate.alreadyExist";

    /**
     * Keys for exception messages associated with {@link com.epam.esm.entity.Order}.
     */
    public static final String BAD_USER_ID = "order.badUserID";
    public static final String BAD_GIFT_CERTIFICATE_ID = "order.badGiftCertificateID";

    /**
     * Keys for exception messages associated with {@link com.epam.esm.entity.User}.
     */
    public static final String USER_NOT_FOUND = "user.notFound";

    /**
     * Keys for exception messages associated with {@link java.awt.print.Pageable}.
     */
    public static final String INVALID_PAGINATION = "pagination.invalid";
}
