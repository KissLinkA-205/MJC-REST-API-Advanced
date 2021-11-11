package com.epam.esm.exception;

/**
 * {@code NoSuchEntityException} is generated in case entity doesn't found in database.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 * @see RuntimeException
 */
public class NoSuchEntityException extends RuntimeException {
    public NoSuchEntityException() {
    }

    public NoSuchEntityException(String messageCode) {
        super(messageCode);
    }

    public NoSuchEntityException(String messageCode, Throwable cause) {
        super(messageCode, cause);
    }

    public NoSuchEntityException(Throwable cause) {
        super(cause);
    }
}
