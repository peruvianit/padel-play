package it.peruvianit.delegator.system.common.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class SystemHealthDto {
     private String status;
}
