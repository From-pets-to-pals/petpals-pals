package com.petpals.pals.domain.model.pal;


import java.sql.Date;
import java.util.List;

public record Pals(
        String name,
        Date birthDate,
        String specie,
        String race,
        Long owner,
        String icadIdentifier,
        boolean isVaccinated,
        boolean isMale,
        Double weight,
        Double height,
        String id,
        List<String>medicalHistory,
        Date nextVaccine,
        Date nextPlannedVetApp,
        boolean isSterilized,
        boolean hasPassport
) {
}
