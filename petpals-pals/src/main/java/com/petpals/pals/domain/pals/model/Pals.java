package com.petpals.pals.domain.pals.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

@Builder
public class Pals {
    @Getter
    @Setter
    private Long technicalId;
    @Getter
    @Setter
    private PalMedicalInformation palMedicalInformation;
    @Getter
    @Setter
    @NotNull
    private PalIdentityInformation palIdentityInformation;
    @Getter
    @Setter
    private PalMeasurement palMeasurement;
    @Getter
    @Setter
    @NotNull
    private Long owner;
    @Getter
    @Setter
    private boolean hasDied;

    public String calculatePalDailyRation(){
        NumberFormat formatter = new DecimalFormat("#00");
        double ration;
        switch (palIdentityInformation.specie()){
            case DOG -> ration = palMeasurement.weight() * 0.015 * 1000;
            case CAT -> ration = palMeasurement.weight() * 40;
            case FERRET -> ration = 50.0;
            default -> throw new RuntimeException();
        }
        return String.format("%s grammes", formatter.format(ration));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pals pal = (Pals) o;

        if (!Objects.equals(technicalId, pal.technicalId)) return false;
        if (!palMedicalInformation.equals(pal.palMedicalInformation)) return false;
        if (!palIdentityInformation.equals(pal.palIdentityInformation)) return false;
        if (!owner.equals(pal.owner)) return false;
        return palMeasurement.equals(pal.palMeasurement);
    }

    @Override
    public int hashCode() {
        int result = technicalId != null ? technicalId.hashCode() : 0;
        result = 31 * result + palMedicalInformation.hashCode();
        result = 31 * result + palIdentityInformation.hashCode();
        result = 31 * result + owner.hashCode();
        result = 31 * result + palMeasurement.hashCode();
        return result;
    }
}
