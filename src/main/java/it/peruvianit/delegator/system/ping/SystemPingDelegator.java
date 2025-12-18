package it.peruvianit.delegator.system.ping;

import it.peruvianit.delegator.system.common.mapper.SystemInfoMapper;
import it.peruvianit.delegator.system.log.service.SystemLogService;
import it.peruvianit.delegator.system.ping.response.SystemPingResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class SystemPingDelegator {

    private final SystemLogService service;

    private final SystemInfoMapper mapper;

    public Response response() {

        return Response.status(Status.OK)
                .entity(new SystemPingResponse(true))
                .build();
    }
}
