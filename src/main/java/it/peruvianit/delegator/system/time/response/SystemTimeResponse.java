package it.peruvianit.delegator.system.time.response;

import java.time.Instant;

public record SystemTimeResponse(
        Instant serverTimeUtc,
        String timeZone,
        String offset
) {}