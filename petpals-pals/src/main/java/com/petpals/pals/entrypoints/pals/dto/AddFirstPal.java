package com.petpals.pals.entrypoints.pals.dto;

import com.petpals.pals.domain.pals.model.Species;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.*;

import java.util.Date;

@Introspected
@Serdeable
public record AddFirstPal(
                boolean isVaccinated,
                NewOwner owner,
                @NotBlank String name,
                @Past Date birthDate,
                boolean isMale,
                Species specie,
                @Size(min=7, max=25)
                String race,
                @Pattern(regexp = "^[250(26|22)\\d{10}]{15}$")
                String icadIdentifier,
                @NotNull
                boolean hasPassport,
                @NotNull
                boolean isSterilized,
                @Positive Double weight,
                @Positive Double height
) {
}
