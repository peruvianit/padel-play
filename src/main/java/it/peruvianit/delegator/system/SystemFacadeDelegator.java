package it.peruvianit.delegator.system;

import it.peruvianit.delegator.system.health.SystemHealthDelegator;
import it.peruvianit.delegator.system.info.SystemInfoDelegator;
import it.peruvianit.delegator.system.log.SystemLogDelegator;
import it.peruvianit.delegator.system.metrics.SystemMetricsDelegator;
import it.peruvianit.delegator.system.ping.SystemPingDelegator;
import it.peruvianit.delegator.system.time.SystemTimeDelegator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class SystemFacadeDelegator {

    private final SystemInfoDelegator systemInfoDelegator;

    private final SystemTimeDelegator systemTimeDelegator;

    private final SystemHealthDelegator systemHealthDelegator;

    private final SystemLogDelegator systemLogDelegator;

    private final SystemPingDelegator systemPingDelegator;

    private final SystemMetricsDelegator systemMetricsDelegator;

    public Response getSystemInfo() {
        return systemInfoDelegator.response();
    }

    public Response getSystemTime() {
        return systemTimeDelegator.response();
    }

    public Response getSystemHealth() {
        return systemHealthDelegator.response();
    }

    public Response getSystemLog() {
        return systemLogDelegator.response();
    }

    public Response getSystemPing() {
        return systemPingDelegator.response();
    }

    public Response getSystemMetrics() {
        return systemMetricsDelegator.response();
    }
}
