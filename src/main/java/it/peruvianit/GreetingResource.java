package it.peruvianit;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(
            summary = "Restituisce un messaggio di saluto",
            description = "Un semplice endpoint REST che restituisce un messaggio statico."
    )
    @APIResponse(
            responseCode = "200",
            description = "Saluto restituito correttamente",
            content = @Content(
                    mediaType = MediaType.TEXT_PLAIN,
                    schema = @Schema(implementation = String.class)
            )
    )
    public String hello() {
        return "Hello from Quarkus REST";
    }
}
