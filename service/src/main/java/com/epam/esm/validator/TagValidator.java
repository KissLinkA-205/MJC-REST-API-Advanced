package com.epam.esm.validator;

import com.epam.esm.entity.Tag;
import com.epam.esm.exception.ExceptionResult;
import lombok.experimental.UtilityClass;

import static com.epam.esm.exception.ExceptionMessageKey.BAD_TAG_NAME;

/**
 * Utility class {@code TagValidator} provides methods to validate fields of {@link com.epam.esm.entity.Tag}.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@UtilityClass
public class TagValidator {
    private final int MAX_LENGTH_NAME = 20;
    private final int MIN_LENGTH_NAME = 3;

    /**
     * Validate all fields of tag.
     *
     * @param tag the tag
     * @param er  the object to which the validation results will be written
     */
    public void validate(Tag tag, ExceptionResult er) {
        IdentifiableValidator.validateExistenceOfId(tag.getId(), er);
        validateName(tag.getName(), er);
    }

    /**
     * Validate tag name.
     *
     * @param name the tag name
     * @param er   the object to which the validation results will be written
     */
    public void validateName(String name, ExceptionResult er) {
        if (name == null || name.length() < MIN_LENGTH_NAME || name.length() > MAX_LENGTH_NAME) {
            er.addException(BAD_TAG_NAME, name);
        }
    }
}
