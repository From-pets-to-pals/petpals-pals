package com.petpals.domain.model

import com.petpals.shared.enums.Species
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import java.util.*

data class PalIdentityInformation(
    val name: @NotNull @Size(min = 2, max = 25, message = "Taille du nom de l'animal incorrecte") String,
    val birthDate: @Past(message = "La date doit être passée") @NotNull Date,
    val isMale: @NotNull Boolean,
    val specie: Species,
    val race: @Size(min = 3, max = 25, message = "") String,
    val icadIdentifier: @Pattern(regexp = "^[250(26|22)\\d{10}]{15}$") String,
    val hasPassport: @NotNull Boolean
) {
}
