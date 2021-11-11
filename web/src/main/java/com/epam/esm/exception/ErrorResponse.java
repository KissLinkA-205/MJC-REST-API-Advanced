package com.epam.esm.exception;

/**
 * Class {@code ErrorResponse} represents objects that will be returned as a response when an error is generated.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public class ErrorResponse {
    private String errorCode;
    private String errorMessage;

    public ErrorResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
