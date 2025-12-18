package it.peruvianit.delegator.system.log.service;

import it.peruvianit.delegator.system.common.dto.SystemLogDto;
import it.peruvianit.delegator.system.log.response.SystemLogResponse;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

import java.util.stream.StreamSupport;

@ApplicationScoped
public class SystemLogService {

    private final Config config = ConfigProvider.getConfig();

    public SystemLogDto getLogsInfo() {

        String rootLevel = get("quarkus.log.level", "INFO");

        boolean consoleEnabled =
                getBool("quarkus.log.console.enable", true);

        boolean fileHandlerPresent =
                StreamSupport.stream(config.getPropertyNames().spliterator(), false)
                        .anyMatch(p -> p.startsWith("quarkus.log.handler.file."));

        String output = resolveOutput(consoleEnabled, fileHandlerPresent);

        String logFile = fileHandlerPresent ? resolveFilePath() : null;
        String rotationPolicy = fileHandlerPresent ? resolveRotationPolicy() : null;

        return SystemLogDto.builder()
                .loggingFramework("JBoss LogManager")
                .rootLogLevel(rootLevel)
                .output(output)
                .logFile(logFile)
                .rotationPolicy(rotationPolicy)
                .build();
    }

    private String resolveOutput(boolean console, boolean file) {
        if (console && file) {
            return "STDOUT+FILE";
        }
        if (file) {
            return "FILE";
        }
        return "STDOUT";
    }

    private String resolveFilePath() {
        return StreamSupport.stream(config.getPropertyNames().spliterator(), false)
                .filter(p -> p.startsWith("quarkus.log.handler.file."))
                .filter(p -> p.endsWith(".path"))
                .findFirst()
                .map(p -> config.getValue(p, String.class))
                .orElse(null);
    }

    private String resolveRotationPolicy() {
        boolean size =
                StreamSupport.stream(config.getPropertyNames().spliterator(), false)
                        .anyMatch(p -> p.contains("rotation.file-size"));

        boolean time =
                StreamSupport.stream(config.getPropertyNames().spliterator(), false)
                        .anyMatch(p -> p.contains("rotation.file-suffix"));

        if (size && time) return "SIZE+TIME";
        if (size) return "SIZE";
        if (time) return "TIME";
        return "NONE";
    }

    private String get(String key, String def) {
        return config.getOptionalValue(key, String.class).orElse(def);
    }

    private boolean getBool(String key, boolean def) {
        return config.getOptionalValue(key, Boolean.class).orElse(def);
    }
}
