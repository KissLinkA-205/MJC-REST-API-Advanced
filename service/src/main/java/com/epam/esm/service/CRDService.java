package com.epam.esm.service;

import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * Interface {@code CRDService} describes CRD operations for working with objects.
 *
 * @param <T> the type parameter
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface CRDService<T> {

    /**
     * Method for getting an entity object by ID.
     *
     * @param id ID of entity to get
     * @return Entity object
     */
    T getById(long id);

    /**
     * Method for getting all entities.
     *
     * @param page page number for pagination
     * @param size page size for pagination
     * @return List of all entities
     */
    List<T> getAll(int page, int size);

    /**
     * Method for saving an entity.
     *
     * @param entity entity to save
     * @return saved entity
     */
    T insert(T entity);

    /**
     * Method for removing an entity by ID.
     *
     * @param id ID of entity to remove
     */
    void removeById(long id);

    /**
     * Method for getting a list of gift certificates by specific parameters.
     *
     * @param requestParams request parameters from url
     * @param page          page number for pagination
     * @param size          page size for pagination
     * @return List of gift certificates
     */
    List<T> doFilter(MultiValueMap<String, String> requestParams, int page, int size);
}
