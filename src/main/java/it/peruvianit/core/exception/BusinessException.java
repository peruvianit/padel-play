package it.peruvianit.core.exception;

public class BusinessException extends ApplicationException {
    public BusinessException(String message) {
        super("BUSINESS_ERROR", message, 422);
    }
}
