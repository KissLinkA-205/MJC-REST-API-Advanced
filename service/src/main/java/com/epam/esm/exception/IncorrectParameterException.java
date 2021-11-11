package com.epam.esm.exception;

/**
 * {@code IncorrectParameterException} is generated in case received parameters have unacceptable value.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 * @see RuntimeException
 */
public class IncorrectParameterException extends RuntimeException {
    private final ExceptionResult exceptionResult;

    public IncorrectParameterException(ExceptionResult exceptionResult) {
        this.exceptionResult = exceptionResult;
    }

    public ExceptionResult getExceptionResult() {
        return exceptionResult;
    }
}