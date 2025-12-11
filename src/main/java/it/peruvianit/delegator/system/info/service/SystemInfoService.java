package it.peruvianit.delegator.system.info.service;

import it.peruvianit.delegator.system.common.dto.SystemInfoDto;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.lang.management.ManagementFactory;

@ApplicationScoped
public class SystemInfoService {

    @ConfigProperty(name = "git.build.version", defaultValue = "unknown")
    String version;

    @ConfigProperty(name = "git.build.time", defaultValue = "unknown")
    String buildTimestamp;

    @ConfigProperty(name = "environment", defaultValue = "unknown")
    String environment;

    @ConfigProperty(name = "git.commit.id.abbrev", defaultValue = "n/a")
    String gitCommit;

    @ConfigProperty(name = "git.branch", defaultValue = "n/a")
    String gitBranch;

    @ConfigProperty(name = "git.build.user.name", defaultValue = "n/a")
    String buildUser;


    public SystemInfoDto getInfo() {
        return SystemInfoDto.builder()
                .version(version)
                .buildTimestamp(buildTimestamp)
                .environment(environment)
                .gitCommit(gitCommit)
                .gitBranch(gitBranch)
                .gitTag(getGitTag())   // 🔥 lettura sicura
                .buildUser(buildUser)
                .hostname(getHostname())
                .javaVersion(System.getProperty("java.version"))
                .jvmVendor(System.getProperty("java.vendor"))
                .quarkusVersion(io.quarkus.runtime.Quarkus.class.getPackage().getImplementationVersion())
                .processUptime(getUptime())
                .build();
    }

    private String getGitTag() {
        return org.eclipse.microprofile.config.ConfigProvider.getConfig()
                .getOptionalValue("git.closest.tag.name", String.class)
                .filter(s -> !s.isBlank())
                .orElse("n/a");
    }

    private String getHostname() {
        try {
            return java.net.InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            return "unknown";
        }
    }

    private long getUptime() {
        return ManagementFactory.getRuntimeMXBean().getUptime();
    }
}
