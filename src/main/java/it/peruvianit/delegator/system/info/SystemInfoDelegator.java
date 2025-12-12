package it.peruvianit.delegator.system.info;

import it.peruvianit.delegator.system.common.mapper.SystemInfoMapper;
import it.peruvianit.delegator.system.info.service.SystemInfoService;
import it.peruvianit.delegator.system.common.dto.SystemInfoDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@ApplicationScoped
public class SystemInfoDelegator {

    @Inject
    SystemInfoService service;

    @Inject
    SystemInfoMapper mapper;

    public Response response() {
        SystemInfoDto dto = service.getInfo();

        return Response.status(Status.OK)
                .entity(mapper.toResponse(dto))
                .build();
    }
}
