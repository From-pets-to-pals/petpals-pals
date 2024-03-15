package com.petpals.pals.domain.model.pal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

public record PalMeasurement(
        @DecimalMin(value = "0.0", inclusive = false) Double weight,
        @Min(value = 0) Double height
) {
}
