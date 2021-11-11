package com.epam.esm.dto.converter;

/**
 * The interface DtoConverter describes abstract behavior for converting objects.
 *
 * @param <E> Entity type
 * @param <D> DtoEntity type
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface DtoConverter<E, D> {

    /**
     * Method for converting dto to entity
     *
     * @param dto dto entity to convert
     * @return converted entity
     */

    E convertToEntity(D dto);

    /**
     * Method for onverting entity to dto
     *
     * @param entity source entity to convert
     * @return converted dto entity
     */
    D convertToDto(E entity);
}
