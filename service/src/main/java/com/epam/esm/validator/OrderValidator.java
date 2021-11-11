package com.epam.esm.validator;

import com.epam.esm.entity.Order;
import com.epam.esm.exception.ExceptionResult;
import lombok.experimental.UtilityClass;

import static com.epam.esm.exception.ExceptionMessageKey.BAD_GIFT_CERTIFICATE_ID;
import static com.epam.esm.exception.ExceptionMessageKey.BAD_USER_ID;

/**
 * Utility class {@code OrderValidator} provides methods to validate fields of {@link com.epam.esm.entity.Order}.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@UtilityClass
public class OrderValidator {
    private final int MIN_ID = 1;

    /**
     * Validate all fields of order.
     *
     * @param order the order
     * @param er    the object to which the validation results will be written
     */
    public void validate(Order order, ExceptionResult er) {
        IdentifiableValidator.validateExistenceOfId(order.getId(), er);
        validateUserId(order.getUser().getId(), er);
        validateGiftCertificateId(order.getGiftCertificate().getId(), er);
    }

    /**
     * Validate user ID.
     *
     * @param userId the user ID
     * @param er the object to which the validation results will be written
     */
    public void validateUserId(long userId, ExceptionResult er) {
        if (userId < MIN_ID) {
            er.addException(BAD_USER_ID, userId);
        }
    }

    /**
     * Validate gift certificate ID.
     *
     * @param giftCertificateId the user ID
     * @param er the object to which the validation results will be written
     */
    public void validateGiftCertificateId(long giftCertificateId, ExceptionResult er) {
        if (giftCertificateId < MIN_ID) {
            er.addException(BAD_GIFT_CERTIFICATE_ID, giftCertificateId);
        }
    }
}
