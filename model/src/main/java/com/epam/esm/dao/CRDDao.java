package com.epam.esm.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Optional;

/**
 * Interface {@code CRDDao} describes CRD operations for working with database tables.
 *
 * @param <T> the type parameter
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface CRDDao<T> {

    /**
     * Method for getting an entity object from a table by ID.
     *
     * @param id ID of entity to get
     * @return Optional entity object from table
     */
    Optional<T> findById(long id);

    /**
     * Method for getting all entities from a table.
     *
     * @param pageable pageable object with pagination info (page number, page size)
     * @return List of all entities in the table
     */
    List<T> findAll(Pageable pageable);

    /**
     * Method for saving an entity to a table.
     *
     * @param item entity object to save
     * @return saved entity
     */
    T insert(T item);

    /**
     * Method for removing an entity from a table by ID.
     *
     * @param id ID of entity to remove
     */
    void removeById(long id);

    /**
     * Method for getting a list of entities by specific parameters.
     *
     * @param fields   parameters by which the filter will be performed
     * @param pageable pageable object with pagination info (page number, page size)
     * @return List of entity objects
     */
    List<T> findWithFilters(MultiValueMap<String, String> fields, Pageable pageable);
}
