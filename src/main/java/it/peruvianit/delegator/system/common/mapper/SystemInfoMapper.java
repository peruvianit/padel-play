package it.peruvianit.delegator.system.common.mapper;

import it.peruvianit.delegator.system.common.dto.SystemHealthDto;
import it.peruvianit.delegator.system.common.dto.SystemInfoDto;
import it.peruvianit.delegator.system.common.dto.SystemTimeDto;
import it.peruvianit.delegator.system.health.response.SystemHealthResponse;
import it.peruvianit.delegator.system.info.response.SystemInfoResponse;
import it.peruvianit.delegator.system.time.response.SystemTimeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface SystemInfoMapper {
    SystemInfoResponse toResponse(SystemInfoDto dto);

    SystemTimeResponse toResponse(SystemTimeDto dto);

    SystemHealthResponse toResponse(SystemHealthDto dto);
}
