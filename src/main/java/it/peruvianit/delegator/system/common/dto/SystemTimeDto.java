package it.peruvianit.delegator.system.common.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class SystemTimeDto {
    private Instant serverTimeUtc;
    private String timeZone;
    private String offset;
}
