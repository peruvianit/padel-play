package it.peruvianit.delegator.system.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SystemMetricsDto {
    private long uptimeSeconds;
    private MemoryMetrics memory;
    private  ThreadMetrics threads;
    private  CpuMetrics cpu;

    @Data
    @Builder
    public static class  MemoryMetrics{
        private long heapUsedMB;
        private long heapMaxMB;
    }

    @Data
    @Builder
    public static class ThreadMetrics {
        private int live;
        private int peak;
    }

    @Data
    @Builder
    public static class CpuMetrics{
        private double processCpuLoad;
    }
}
