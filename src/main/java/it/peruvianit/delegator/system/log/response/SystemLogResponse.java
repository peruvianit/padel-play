package it.peruvianit.delegator.system.log.response;

public record SystemLogResponse(
        String loggingFramework,
        String rootLogLevel,
        String output,
        String logFile,
        String rotationPolicy
) {}