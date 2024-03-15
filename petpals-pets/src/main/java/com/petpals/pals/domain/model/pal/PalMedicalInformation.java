package com.petpals.pals.domain.model.pal;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

public record PalMedicalInformation (

    boolean isVaccinated,
    List<String> medicalHistory,
    @Future
    Date nextVaccine,
    @Future
    Date nextPlannedVetApp,
    boolean isSterilized
){

}
