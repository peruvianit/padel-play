package it.peruvianit.core.exception;

import lombok.Getter;

@Getter
public class ValidationException extends ApplicationException {

    public ValidationException(String messageKey, Object... params) {
        super("VALIDATION_ERROR", 400, messageKey, params);
    }
}
