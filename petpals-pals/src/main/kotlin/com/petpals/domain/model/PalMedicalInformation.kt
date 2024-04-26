package com.petpals.domain.model

import jakarta.validation.constraints.Future
import java.util.*

data class PalMedicalInformation(
    val isVaccinated: Boolean,
    val medicalHistory: List<String>,
    val nextVaccine: @Future Date?,
    val nextPlannedVetApp: @Future Date?,
    val isSterilized: Boolean
)
