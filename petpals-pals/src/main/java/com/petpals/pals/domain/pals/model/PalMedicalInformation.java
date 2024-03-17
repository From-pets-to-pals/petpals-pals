package com.petpals.pals.domain.pals.model;

import jakarta.validation.constraints.Future;

import java.util.Date;
import java.util.List;

public record PalMedicalInformation(
        boolean isVaccinated,
        List<String> medicalHistory,
        @Future
        Date nextVaccine,
        @Future
        Date nextPlannedVetApp,
        boolean isSterilized
) {
}
