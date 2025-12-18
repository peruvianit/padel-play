package it.peruvianit.delegator.system.health.service;

import it.peruvianit.delegator.system.common.dto.SystemHealthDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class SystemHealthService {
    private final DataSource dataSource;

    public SystemHealthDto checkHealth() {

        if (isDatabaseUp()) {
            return SystemHealthDto.builder()
                    .status("UP").build();
        }

        return SystemHealthDto.builder()
                .status("DOWN").build();
    }

    private boolean isDatabaseUp() {
        try (Connection c = dataSource.getConnection()) {
            return c.isValid(1);
        } catch (Exception e) {
            return false;
        }
    }
}
