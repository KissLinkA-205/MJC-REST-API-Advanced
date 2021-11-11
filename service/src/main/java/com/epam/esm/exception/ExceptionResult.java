package com.epam.esm.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * {@code ExceptionResult} designed to save multiple validation exception message codes with parameters.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public class ExceptionResult {
    private final Map<String, Object[]> exceptionMessages;

    public ExceptionResult() {
        exceptionMessages = new HashMap<>();
    }

    public void addException(String messageCode, Object... arguments) {
        exceptionMessages.put(messageCode, arguments);
    }

    public Map<String, Object[]> getExceptionMessages() {
        return exceptionMessages;
    }
}
