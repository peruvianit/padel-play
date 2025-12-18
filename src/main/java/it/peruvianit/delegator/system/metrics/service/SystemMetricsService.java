package it.peruvianit.delegator.system.metrics.service;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;

import com.sun.management.OperatingSystemMXBean;
import it.peruvianit.delegator.system.common.dto.SystemMetricsDto;
import it.peruvianit.delegator.system.metrics.response.SystemMetricsResponse;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SystemMetricsService {

    public SystemMetricsDto getMetrics() {

        long uptimeSeconds =
                ManagementFactory.getRuntimeMXBean().getUptime() / 1000;

        // 🧠 MEMORIA
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        long heapUsedMB =
                memoryBean.getHeapMemoryUsage().getUsed() / (1024 * 1024);
        long heapMaxMB =
                memoryBean.getHeapMemoryUsage().getMax() / (1024 * 1024);

        // 🧵 THREAD
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        int liveThreads = threadBean.getThreadCount();
        int peakThreads = threadBean.getPeakThreadCount();

        // ⚙️ CPU (processo JVM)
        double cpuLoad = -1;
        if (ManagementFactory.getOperatingSystemMXBean()
                instanceof OperatingSystemMXBean osBean) {

            cpuLoad = osBean.getProcessCpuLoad(); // 0.0 - 1.0
        }

        return SystemMetricsDto.builder()
                .uptimeSeconds(uptimeSeconds)
                .memory(
                        SystemMetricsDto.MemoryMetrics.builder()
                        .heapUsedMB(heapUsedMB)
                        .heapMaxMB(heapMaxMB)
                        .build()
                )
                .threads(
                        SystemMetricsDto.ThreadMetrics.builder()
                        .live(liveThreads)
                        .peak(peakThreads)
                        .build()
                )
                .cpu(
                        SystemMetricsDto.CpuMetrics.builder()
                        .processCpuLoad(cpuLoad >= 0
                                        ? cpuLoad
                                        : null)
                        .build()
                )
                .build();
    }
}
