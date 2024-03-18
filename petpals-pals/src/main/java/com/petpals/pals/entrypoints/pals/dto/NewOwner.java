package com.petpals.pals.entrypoints.pals.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Email;

@Introspected
@Serdeable
public record NewOwner(
        @Email String email,
        String functionalId,
        String deviceId,
        String location
                       ) {
}
