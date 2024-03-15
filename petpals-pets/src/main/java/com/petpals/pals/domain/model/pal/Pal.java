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
    @NotNull
    @Size(min = 2, max=25, message = "Taille du nom de l'animal incorrecte")
    @Getter
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
    private Long owner;
    @Getter
    @Size(min=15, max=15)
    private String icadIdentifier;
    @NotNull
    @Getter
    @Setter
    private boolean isVaccinated;
    @NotNull
    @Getter
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

    private Double calculatePalDailyRation(){
        switch (specie){
            case DOG -> {
                return palMeasurement.weight() * 0.015;
            }
            case CAT -> {
                return palMeasurement.weight() * 0.04;
            }
            case Furet -> {
                return 50.0;
            }
            default -> throw new RuntimeException();
        }
    }

}
