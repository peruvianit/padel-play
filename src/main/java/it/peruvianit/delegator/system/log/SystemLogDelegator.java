package it.peruvianit.delegator.system.log;

import it.peruvianit.delegator.system.common.dto.SystemHealthDto;
import it.peruvianit.delegator.system.common.dto.SystemInfoDto;
import it.peruvianit.delegator.system.common.dto.SystemLogDto;
import it.peruvianit.delegator.system.common.mapper.SystemInfoMapper;
import it.peruvianit.delegator.system.health.service.SystemHealthService;
import it.peruvianit.delegator.system.log.service.SystemLogService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class SystemLogDelegator {

    private final SystemLogService service;

    private final SystemInfoMapper mapper;

    public Response response() {
        SystemLogDto dto = service.getLogsInfo();

        return Response.status(Status.OK)
                .entity(mapper.toResponse(dto))
                .build();
    }
}
