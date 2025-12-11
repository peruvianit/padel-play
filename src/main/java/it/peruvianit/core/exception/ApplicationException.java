package it.peruvianit.core.exception;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

    private final String errorCode;
    private final int httpStatus;

    public ApplicationException(String errorCode, String message, int httpStatus) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

}