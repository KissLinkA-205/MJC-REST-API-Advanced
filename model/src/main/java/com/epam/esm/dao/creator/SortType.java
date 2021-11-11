package com.epam.esm.dao.creator;

/**
 * Enum {@code SortType} contains available types of sorting.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public enum SortType {

    /**
     * Ascending sort.
     */
    ASC("ASC"),

    /**
     * Descending sort.
     */
    DESC("DESC");

    private final String sortTypeName;

    SortType(String sortTypeName) {
        this.sortTypeName = sortTypeName;
    }

    public String getSortTypeName() {
        return sortTypeName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(sortTypeName);
        return sb.toString();
    }
}
