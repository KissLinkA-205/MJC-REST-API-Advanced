package com.epam.esm.dao;

/**
 * Interface {@code CRUDDao} describes CRUD operations for working with database tables.
 *
 * @param <T> the type parameter
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface CRUDDao<T> extends CRDDao<T> {

    /**
     * Method for updating an entity in a table.
     *
     * @param item entity object to update
     * @return updated entity
     */
    T update(T item);
}
