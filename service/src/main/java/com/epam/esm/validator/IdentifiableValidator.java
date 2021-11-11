package com.epam.esm.validator;

import com.epam.esm.dao.creator.SortType;
import com.epam.esm.exception.ExceptionResult;
import lombok.experimental.UtilityClass;

import java.util.Objects;

import static com.epam.esm.exception.ExceptionMessageKey.*;

/**
 * Utility class {@code IdentifiableValidator} provides methods to validate fields of {@link com.epam.esm.entity.Identifiable}.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@UtilityClass
public class IdentifiableValidator {
    private final int MIN_ID = 1;
    private final int EMPTY_ID = 0;

    /**
     * Validate ID.
     *
     * @param id the ID
     * @param er the object to which the validation results will be written
     */
    public void validateId(long id, ExceptionResult er) {
        if (id < MIN_ID) {
            er.addException(BAD_ID, id);
        }
    }

    /**
     * Validate existence of ID.
     *
     * @param id the ID
     * @param er the object to which the validation results will be written
     */
    public void validateExistenceOfId(long id, ExceptionResult er) {
        if (id != EMPTY_ID) {
            er.addException(ID_EXISTENCE);
        }
    }

    /**
     * Validate type of sort.
     *
     * @param sortType sort type string type
     * @param er       the object to which the validation results will be written
     */
    public void validateSortType(String sortType, ExceptionResult er) {
        if (!(Objects.equals(SortType.ASC.getSortTypeName(), sortType) ||
                Objects.equals(SortType.DESC.getSortTypeName(), sortType))) {
            er.addException(BAD_SORT_TYPE, sortType);
        }
    }
}
