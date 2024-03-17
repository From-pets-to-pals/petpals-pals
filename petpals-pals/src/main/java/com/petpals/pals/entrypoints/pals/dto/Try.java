package com.petpals.pals.entrypoints.pals.dto;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

@Serdeable
public record Try(@NotNull String name) {
}
