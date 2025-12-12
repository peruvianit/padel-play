package it.peruvianit.core.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends ApplicationException {

    public NotFoundException(String messageKey, Object... params) {
        super("NOT_FOUND", 404, messageKey, params);
    }
}
