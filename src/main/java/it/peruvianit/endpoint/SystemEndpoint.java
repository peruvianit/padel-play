package it.peruvianit.endpoint;

import it.peruvianit.core.exception.BusinessException;
import it.peruvianit.core.exception.ValidationException;
import it.peruvianit.delegator.system.SystemFacadeDelegator;
import it.peruvianit.delegator.system.info.response.SystemInfoResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/system")
@Tag(name = "System", description = "Operazioni relative allo stato e alle informazioni del sistema")
public class SystemEndpoint {

    @Inject
    SystemFacadeDelegator delegator;

    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Ottiene le informazioni di sistema",
            description = "Restituisce dettagli come versione, build, ambiente, hostname, Java version, uptime, ecc."
    )
    @APIResponse(
            responseCode = "200",
            description = "Informazioni ottenute con successo",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = SystemInfoResponse.class, type = SchemaType.OBJECT)
            )
    )
    @APIResponse(
            responseCode = "500",
            description = "Errore interno al server"
    )
    public Response info() {
        return delegator.getSystemInfo();
    }

    @GET
    @Path("/erro-application")
    @Produces(MediaType.APPLICATION_JSON)
    public Response errorApplication() {
        if (true){
            throw new BusinessException("Errore de validazione");
        }
        return delegator.getSystemInfo();
    }

    @GET
    @Path("/error-system")
    @Produces(MediaType.APPLICATION_JSON)
    public Response errorSystem() {
        int c = 4/0;
        return delegator.getSystemInfo();
    }
}
