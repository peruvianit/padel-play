package it.peruvianit.delegator.system.info.response;

import lombok.Builder;
import lombok.Data;

public record SystemInfoResponse(
        String version,
        String buildTimestamp,
        String environment,

        String gitCommit,
        String gitBranch,
        String gitTag,

        String buildUser,
        String hostname,
        String javaVersion,
        String jvmVendor,
        String quarkusVersion,

        long processUptime
) {}