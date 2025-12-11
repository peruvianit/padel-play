package it.peruvianit.core.exception;

public class ValidationException extends ApplicationException {
    public ValidationException(String message) {
        super("VALIDATION_ERROR", message, 400);
    }
}
