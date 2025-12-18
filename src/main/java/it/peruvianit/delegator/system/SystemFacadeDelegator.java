package it.peruvianit.delegator.system;

import it.peruvianit.delegator.system.info.SystemInfoDelegator;
import it.peruvianit.delegator.system.time.SystemTimeDelegator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class SystemFacadeDelegator {

    private final SystemInfoDelegator systemInfoDelegator;

    private final SystemTimeDelegator systemTimeDelegator;

    public Response getSystemInfo() {
        return systemInfoDelegator.response();
    }

    public Response getSystemTime() {
        return systemTimeDelegator.response();
    }
}
