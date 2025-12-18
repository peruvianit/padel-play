package it.peruvianit.endpoint;

import it.peruvianit.core.exception.BusinessException;
import it.peruvianit.delegator.system.SystemFacadeDelegator;
import it.peruvianit.delegator.system.info.response.SystemInfoResponse;
import it.peruvianit.delegator.system.time.response.SystemTimeResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/system")
@Tag(name = "System", description = "Operazioni relative allo stato e alle informazioni del sistema")
@ApplicationScoped
@RequiredArgsConstructor
public class SystemEndpoint {

    private final SystemFacadeDelegator delegator;

    // =========================
    // SYSTEM INFO
    // =========================
    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Ottiene le informazioni di sistema",
            description = "Restituisce dettagli come versione, build, ambiente, hostname, Java version, uptime, ecc."
    )
    @Parameter(
            name = "Accept-Language",
            in = ParameterIn.HEADER,
            description = "Lingua della risposta (es: it, en)",
            schema = @Schema(type = SchemaType.STRING, example = "en")
    )
    @APIResponse(
            responseCode = "200",
            description = "Informazioni ottenute con successo",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = SystemInfoResponse.class)
            )
    )
    @APIResponse(
            responseCode = "500",
            description = "Errore interno al server"
    )
    public Response info(
            @HeaderParam("Accept-Language") String language
    ) {
        // NOTA: language non serve usarla, è solo per Swagger/OpenAPI
        return delegator.getSystemInfo();
    }

    @GET
    @Path("/time")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Informazioni temporali del sistema",
            description = "Restituisce informazioni temporali UTC del sistema"
    )
    @APIResponse(
            responseCode = "200",
            description = "Informazioni ottenute con successo",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = SystemTimeResponse.class)
            )
    )
    @APIResponse(
            responseCode = "500",
            description = "Errore interno al server"
    )
    public Response time() {
        return delegator.getSystemTime();
    }

    // =========================
    // BUSINESS ERROR TEST
    // =========================
    @GET
    @Path("/erro-application")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Simula un errore applicativo (Business)")
    @Parameter(
            name = "Accept-Language",
            in = ParameterIn.HEADER,
            description = "Lingua della risposta (es: it, en)",
            schema = @Schema(type = SchemaType.STRING, example = "en")
    )
    @APIResponse(
            responseCode = "422",
            description = "Errore di business"
    )
    public Response errorApplication(
            @HeaderParam("Accept-Language") String language
    ) {
        throw new BusinessException("ERROR_TEST", "VALORE_A", 123);
    }

    // =========================
    // SYSTEM ERROR TEST
    // =========================
    @GET
    @Path("/error-system")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Simula un errore di sistema")
    @Parameter(
            name = "Accept-Language",
            in = ParameterIn.HEADER,
            description = "Lingua della risposta (es: it, en)",
            schema = @Schema(type = SchemaType.STRING, example = "en")
    )
    @APIResponse(
            responseCode = "500",
            description = "Errore di sistema"
    )
    public Response errorSystem(
            @HeaderParam("Accept-Language") String language
    ) {
        int c = 4 / 0;
        return delegator.getSystemInfo();
    }
}
