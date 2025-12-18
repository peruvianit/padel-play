package it.peruvianit.delegator.system.time;

import it.peruvianit.delegator.system.common.dto.SystemTimeDto;
import it.peruvianit.delegator.system.common.mapper.SystemInfoMapper;
import it.peruvianit.delegator.system.time.service.SystemTimeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class SystemTimeDelegator {

    private final SystemTimeService service;

    private final SystemInfoMapper mapper;

    public Response response() {
        SystemTimeDto dto = service.getSystemTime();

        return Response.status(Status.OK)
                .entity(mapper.toResponse(dto))
                .build();
    }
}
