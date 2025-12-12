package it.peruvianit.core.exception;

import lombok.Getter;

@Getter
public class BusinessException extends ApplicationException {
    public BusinessException(String messageKey, Object... params) {
        super("BUSINESS_ERROR", 422, messageKey, params);
    }
}
