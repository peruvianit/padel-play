package it.peruvianit.delegator.system.info;

import it.peruvianit.delegator.system.info.response.SystemInfoResponse;
import it.peruvianit.service.system.SystemInfoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@ApplicationScoped
public class SystemInfoDelegator {

    @Inject
    SystemInfoService service;

    public Response response() {
        return Response.status(Status.OK)
                .entity(service.getInfo())
                .build();
    }
}
