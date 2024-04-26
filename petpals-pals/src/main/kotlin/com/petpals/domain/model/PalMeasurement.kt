package com.petpals.domain.model

import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Min

data class PalMeasurement(
    val weight: @DecimalMin(value = "0.0", inclusive = false) Double,
    val height: @Min(value = 0) Double
)
