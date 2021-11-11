package com.epam.esm.exception;

/**
 * {@code DuplicateEntityException} is generated in case entity already exists in database.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 * @see RuntimeException
 */
public class DuplicateEntityException extends RuntimeException {
    public DuplicateEntityException() {
    }

    public DuplicateEntityException(String messageCode) {
        super(messageCode);
    }

    public DuplicateEntityException(String messageCode, Throwable cause) {
        super(messageCode, cause);
    }

    public DuplicateEntityException(Throwable cause) {
        super(cause);
    }
}
