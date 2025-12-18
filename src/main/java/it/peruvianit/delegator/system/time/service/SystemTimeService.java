package it.peruvianit.delegator.system.time.service;

import it.peruvianit.delegator.system.common.dto.SystemTimeDto;
import it.peruvianit.delegator.system.time.response.SystemTimeResponse;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@ApplicationScoped
public class SystemTimeService {
    public SystemTimeDto getSystemTime() {

        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime now = ZonedDateTime.now(zoneId);

        return SystemTimeDto.builder()
                .serverTimeUtc(Instant.now())
                .timeZone(zoneId.getId())
                .offset(now.getOffset().toString())
                .build();
    }
}
