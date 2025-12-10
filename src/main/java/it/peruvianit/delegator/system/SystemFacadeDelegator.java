package it.peruvianit.delegator.system;

import it.peruvianit.delegator.system.info.SystemInfoDelegator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class SystemFacadeDelegator {

    @Inject
    SystemInfoDelegator systemInfoDelegator;

    public Response getSystemInfo() {
        return systemInfoDelegator.response();
    }
}
