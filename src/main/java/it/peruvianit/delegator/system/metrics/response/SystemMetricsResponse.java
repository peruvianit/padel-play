package it.peruvianit.delegator.system.metrics.response;

public record SystemMetricsResponse(
        long uptimeSeconds,
        MemoryMetrics memory,
        ThreadMetrics threads,
        CpuMetrics cpu
) {

    public record MemoryMetrics(
            long heapUsedMB,
            long heapMaxMB
    ) {}

    public record ThreadMetrics(
            int live,
            int peak
    ) {}

    public record CpuMetrics(
            double processCpuLoad
    ) {}
}