package it.peruvianit.delegator.system.common.mapper;

import it.peruvianit.delegator.system.common.dto.*;
import it.peruvianit.delegator.system.health.response.SystemHealthResponse;
import it.peruvianit.delegator.system.info.response.SystemInfoResponse;
import it.peruvianit.delegator.system.log.response.SystemLogResponse;
import it.peruvianit.delegator.system.metrics.response.SystemMetricsResponse;
import it.peruvianit.delegator.system.time.response.SystemTimeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface SystemInfoMapper {
    SystemInfoResponse toResponse(SystemInfoDto dto);

    SystemTimeResponse toResponse(SystemTimeDto dto);

    SystemHealthResponse toResponse(SystemHealthDto dto);

    SystemLogResponse toResponse(SystemLogDto dto);

    SystemMetricsResponse toResponse(SystemMetricsDto dto);
}
