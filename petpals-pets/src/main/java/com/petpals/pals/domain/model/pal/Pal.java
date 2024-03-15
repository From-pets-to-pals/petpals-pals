package com.petpals.pals.domain.model.pal;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Builder
public class Pal {
    @Getter
    private Long technicalId;
    @Pattern(regexp = "^[250(26|22)\\d{10}]{15}$")
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    @NotNull
    private PalMedicalInformation palMedicalInformation;

    @Getter
    @Setter
    @NotNull
    private PalIdentityInformation palIdentityInformation;

    @Getter
    @Setter
    private Long owner;

    @DecimalMin(value = "0.0", inclusive = false)
    @Getter
    @Setter
    private Double weight;
    @Min(value = 0)
    @Getter
    @Setter
    private Double height;

    @Getter
    @Setter
    private boolean hasDied;


}
