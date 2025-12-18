package it.peruvianit.delegator.system.health;

import it.peruvianit.delegator.system.common.dto.SystemHealthDto;
import it.peruvianit.delegator.system.common.dto.SystemTimeDto;
import it.peruvianit.delegator.system.common.mapper.SystemInfoMapper;
import it.peruvianit.delegator.system.health.service.SystemHealthService;
import it.peruvianit.delegator.system.time.service.SystemTimeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class SystemHealthDelegator {

    private final SystemHealthService service;

    private final SystemInfoMapper mapper;

    public Response response() {
        SystemHealthDto dto = service.checkHealth();

        return Response.status("DOWN".equals(dto.getStatus()) ?
                                Status.SERVICE_UNAVAILABLE :
                                Status.OK)
                .entity(mapper.toResponse(dto))
                .build();
    }
}
