package it.peruvianit.delegator.system.common.mapper;

import it.peruvianit.delegator.system.common.dto.SystemInfoDto;
import it.peruvianit.delegator.system.info.response.SystemInfoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface SystemInfoMapper {
    SystemInfoResponse toResponse(SystemInfoDto dto);
}
