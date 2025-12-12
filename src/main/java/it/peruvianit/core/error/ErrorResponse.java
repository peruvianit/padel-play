package it.peruvianit.core.error;

public record ErrorResponse(
        String errorCode,
        String message,
        String exception,
        String detail,
        String path,
        String correlationId,
        long timestamp
) {
}
