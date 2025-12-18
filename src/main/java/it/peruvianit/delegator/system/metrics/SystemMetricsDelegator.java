package it.peruvianit.delegator.system.metrics;

import it.peruvianit.delegator.system.common.dto.SystemInfoDto;
import it.peruvianit.delegator.system.common.dto.SystemMetricsDto;
import it.peruvianit.delegator.system.common.mapper.SystemInfoMapper;
import it.peruvianit.delegator.system.log.service.SystemLogService;
import it.peruvianit.delegator.system.metrics.response.SystemMetricsResponse;
import it.peruvianit.delegator.system.metrics.service.SystemMetricsService;
import it.peruvianit.delegator.system.ping.response.SystemPingResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class SystemMetricsDelegator {

    private final SystemMetricsService service;

    private final SystemInfoMapper mapper;

    public Response response() {
        SystemMetricsDto dto = service.getMetrics();

        return Response.status(Status.OK)
                .entity(mapper.toResponse(dto))
                .build();
    }
}
