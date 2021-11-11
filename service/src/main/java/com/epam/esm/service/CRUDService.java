package com.epam.esm.service;

/**
 * Interface {@code CRUDService} describes CRUD operations for working with objects.
 *
 * @param <T> the type parameter
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface CRUDService<T> extends CRDService<T> {

    /**
     * Method for updating an entity.
     *
     * @param id     ID of entity to update
     * @param entity entity, which include information to update
     * @return updated entity
     */
    T update(long id, T entity);
}
