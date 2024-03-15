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

    private String name;
    @Past(message = "La date doit être passée")
    @NotNull
    @Getter
    private Date birthDate;
    @Getter
    @SpecieConstraint(enumClass = Species.class, message = "Invalid specie selected")
    private Species specie;
    @Getter
    @Size(min=3, max=25, message="")
    private String race;
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

    private boolean isMale;
    private PalMeasurement palMeasurement;
    @Pattern(regexp = "^[250(26|22)\\d{10}]{15}$")
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private List<String> medicalHistory;
    @Future
    @Getter
    @Setter
    private Date nextVaccine;
    @Future
    @Getter
    @Setter
    private Date nextPlannedVetApp;
    @Getter
    @Setter
    private boolean isSterilized;
    @Getter
    @Setter
    private boolean hasPassport;
    @Getter
    @Setter
    private boolean hasDied;

    public String calculatePalDailyRation(){
        NumberFormat formatter = new DecimalFormat("#00");
        double ration;
        switch (specie){
            case DOG -> ration = palMeasurement.weight() * 0.015 * 1000;

            case CAT -> ration = palMeasurement.weight() * 40;
            case FERRET -> ration = 50.0;
            default -> throw new RuntimeException();
        }
        System.out.println(ration);
        return formatter.format(ration);
    }
}
