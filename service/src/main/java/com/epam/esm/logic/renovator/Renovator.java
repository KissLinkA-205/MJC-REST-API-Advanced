package com.epam.esm.logic.renovator;

import java.util.List;

/**
 * Interface {@code Renovator} describes abstract behavior for renovating objects.
 *
 * @param <T> the type parameter
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface Renovator<T> {

    /**
     * Method for updating object.
     *
     * @param oldEntity entity with old parameters
     * @param newEntity entity with new parameters
     * @return updating entity object
     */
    T updateObject(T newEntity, T oldEntity);

    List<T> updateListFromDatabase(List<T> newList);
}
