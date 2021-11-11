package com.epam.esm.dao.creator;

import lombok.experimental.UtilityClass;

/**
 * Utility class {@code FilterParameters} presents parameters by which information can be filtered.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@UtilityClass
public class FilterParameters {
    /**
     * Filter options.
     */
    public static final String NAME = "name";
    public static final String TAG_NAME = "tag_name";
    public static final String PART_OF_NAME = "partOfName";
    public static final String PART_OF_DESCRIPTION = "partOfDescription";
    public static final String SORT_BY_NAME = "sortByName";
    public static final String SORT_BY_CREATE_DATE = "sortByCreateDate";
}
