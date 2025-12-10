package it.peruvianit.delegator.system.info.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SystemInfoResponse {
    private String version;
    private String buildTimestamp;
    private String environment;

    private String gitCommit;
    private String gitBranch;
    private String gitTag;

    private String buildUser;
    private String hostname;
    private String javaVersion;
    private String jvmVendor;
    private String quarkusVersion;

    private long processUptime;
}
