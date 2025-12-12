package it.peruvianit.core.exception;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

    private final String errorCode;
    private final int httpStatus;
    private final String messageKey;
    private final Object[] params;

    public ApplicationException(String errorCode, int httpStatus, String messageKey, Object... params) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.messageKey = messageKey;
        this.params = params;
    }
}