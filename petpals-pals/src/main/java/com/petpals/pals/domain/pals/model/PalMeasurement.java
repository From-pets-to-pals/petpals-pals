package com.petpals.pals.domain.pals.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;

public record PalMeasurement(
        @DecimalMin(value = "0.0", inclusive = false) Double weight,
        @Min(value = 0) Double height
) {
}
