package it.peruvianit.endpoint;

import it.peruvianit.delegator.system.SystemFacadeDelegator;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/system")
public class SystemEndpoint {

    @Inject
    SystemFacadeDelegator delegator;

    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public Response info() {
        return delegator.getSystemInfo();
    }
}
