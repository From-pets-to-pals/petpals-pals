package com.petpals.pals.domain.pals.model;

import jakarta.validation.constraints.NotNull;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

public class Pals {
    private Long technicalId;
    private String functionalId;
    private PalMedicalInformation palMedicalInformation;
    private PalIdentityInformation palIdentityInformation;
    private PalMeasurement palMeasurement;
    private Owner owner;
    private boolean hasDied;

    public Pals() {
    }

    public Pals(
            Long technicalId,
            String functionalId,
            PalMedicalInformation palMedicalInformation,
            PalIdentityInformation palIdentityInformation,
            PalMeasurement palMeasurement,
            Owner owner,
            boolean hasDied) {
        this.technicalId = technicalId;
        this.functionalId = functionalId;
        this.palMedicalInformation = palMedicalInformation;
        this.palIdentityInformation = palIdentityInformation;
        this.palMeasurement = palMeasurement;
        this.owner = owner;
        this.hasDied = hasDied;
    }

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

    @Override
    public String toString() {
        return "Pals{" +
                "technicalId=" + technicalId +
                ", functionalId='" + functionalId + '\'' +
                ", palMedicalInformation=" + palMedicalInformation +
                ", palIdentityInformation=" + palIdentityInformation +
                ", palMeasurement=" + palMeasurement +
                ", owner=" + owner +
                ", hasDied=" + hasDied +
                '}';
    }

    public Long getTechnicalId() {
        return technicalId;
    }

    public void setTechnicalId(Long technicalId) {
        this.technicalId = technicalId;
    }

    public String getFunctionalId() {
        return functionalId;
    }

    public void setFunctionalId(String functionalId) {
        this.functionalId = functionalId;
    }

    public PalMedicalInformation getPalMedicalInformation() {
        return palMedicalInformation;
    }

    public void setPalMedicalInformation(@NotNull PalMedicalInformation palMedicalInformation) {
        this.palMedicalInformation = palMedicalInformation;
    }

    public PalIdentityInformation getPalIdentityInformation() {
        return palIdentityInformation;
    }

    public void setPalIdentityInformation(@NotNull PalIdentityInformation palIdentityInformation) {
        this.palIdentityInformation = palIdentityInformation;
    }

    public PalMeasurement getPalMeasurement() {
        return palMeasurement;
    }

    public void setPalMeasurement(@NotNull PalMeasurement palMeasurement) {
        this.palMeasurement = palMeasurement;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isHasDied() {
        return hasDied;
    }

    public void setHasDied(@NotNull boolean hasDied) {
        this.hasDied = hasDied;
    }
}
