package com.petpals.pals.model.pal;

import com.petpals.pals.bootstrap.SpecieConstraint;
import com.petpals.pals.bootstrap.Species;
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
    @Size(min = 2, max=25)
    @Getter
    private String name;
    @Past
    @NotNull
    @Getter
    private Date birthDate;
    @Getter
    @SpecieConstraint(enumClass = Species.class, message = "Invalid specie selected")
    private String specie;
    @Getter
    private String race;
    @Getter @Setter
    private Long owner;
    @Getter private String icadIdentifier;
    @NotNull
    @Getter @Setter private boolean isVaccinated;
    @NotNull
    @Getter private boolean isMale;
    @DecimalMin(value = "0.0", inclusive = false)
    @Getter @Setter private Double weight;
    @Min(value = 0)
    @Getter @Setter private Double height;
    @Pattern(regexp = "^(250(26|22))[0-9]{10}$")
    @Getter @Setter private String id;
    @Getter @Setter private List<String> medicalHistory;
    @Future
    @Getter @Setter private Date nextVaccine;
    @Future
    @Getter @Setter private Date nextPlannedVetApp;
    @Getter @Setter private boolean isSterilized;
    @Getter @Setter private boolean hasPassport;
    @Getter @Setter private boolean hasDied;


}
