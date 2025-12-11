package it.peruvianit.core.exception;

public class NotFoundException extends ApplicationException {
    public NotFoundException(String message) {
        super("NOT_FOUND", message, 404);
    }
}
