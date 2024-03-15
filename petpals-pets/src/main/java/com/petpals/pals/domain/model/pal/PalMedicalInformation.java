package com.petpals.pals.domain.model.pal;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Builder
public class PalMedicalInformation {
    @Getter
    @Setter
    private boolean isVaccinated;
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
}
