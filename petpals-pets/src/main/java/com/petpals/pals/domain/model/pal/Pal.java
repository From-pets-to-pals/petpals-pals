package com.petpals.pals.domain.model.pal;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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

    private PalMeasurement palMeasurement;


    public String calculatePalDailyRation(){
        NumberFormat formatter = new DecimalFormat("#00");
        double ration;
        switch (palIdentityInformation.getSpecie()){
            case "DOG" -> ration = palMeasurement.weight() * 0.015 * 1000;

            case "CAT" -> ration = palMeasurement.weight() * 40;
            case "FERRET" -> ration = 50.0;
            default -> throw new RuntimeException();
        }
        System.out.println(ration);
        return formatter.format(ration);
    }
}
