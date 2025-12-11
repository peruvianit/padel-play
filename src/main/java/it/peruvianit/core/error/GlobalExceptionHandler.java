package it.peruvianit.core.error;

import it.peruvianit.core.exception.ApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

import java.time.Instant;
import java.util.UUID;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Throwable> {

    private static final Logger LOG = Logger.getLogger(GlobalExceptionHandler.class);

    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(Throwable ex) {

        String correlationId = UUID.randomUUID().toString();

        if (ex instanceof ApplicationException appEx) {
            LOG.warnf("Handled exception [%s] - %s", correlationId, appEx.getMessage());

            return Response.status(appEx.getHttpStatus())
                    .entity(new ErrorResponse(
                            appEx.getErrorCode(),
                            appEx.getMessage(),
                            ex.getCause() != null ? ex.getCause().toString() : null,
                            uriInfo.getPath(),
                            correlationId,
                            Instant.now().toEpochMilli()
                    ))
                    .build();
        }

        // Unhandled exceptions (500)
        LOG.errorf(ex, "Unhandled exception [%s]", correlationId);

        return Response.status(500)
                .entity(new ErrorResponse(
                        "INTERNAL_ERROR",
                        "Unexpected system error",
                        ex.getMessage(),
                        uriInfo.getPath(),
                        correlationId,
                        Instant.now().toEpochMilli()
                ))
                .build();
    }

}
