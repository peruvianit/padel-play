package it.peruvianit.delegator.system.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SystemLogDto {
    private String loggingFramework;
    private String rootLogLevel;
    private String output;
    private String logFile;
    private String rotationPolicy;
}
