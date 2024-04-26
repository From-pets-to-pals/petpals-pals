package com.petpals.application.dto

import com.petpals.shared.enums.Species
import jakarta.validation.constraints.*
import java.util.*

data class AddFirstPal(
    val isVaccinated: Boolean,
    val owner: NewOwner,
    @NotBlank val name:  String,
    val birthDate: @Past Date,
    val isMale: Boolean,
    val specie: Species,
    val race: @Size(min = 7, max = 25) String,
    val icadIdentifier: @Pattern(regexp = "^[250(26|22)\\d{10}]{15}$") String,
    val hasPassport: @NotNull Boolean,
    val isSterilized: @NotNull Boolean,
    val weight: @Positive Double,
    val height: @Positive Double
) {
}
