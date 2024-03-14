package com.petpals.pals.model.pal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Builder
public class Pal {
    @Getter private Long technicalId;
    @Getter private String name;
    @Getter private Date birthDate;
    @Getter private String specie;
    @Getter private String race;
    @Getter @Setter
    private Long owner;
    @Getter private String icadIdentifier;
    @Getter @Setter private boolean isVaccinated;
    @Getter private boolean isMale;
    @Getter @Setter private Double weight;
    @Getter @Setter private Double height;
    @Getter @Setter private String id;
    @Getter @Setter private List<String> medicalHistory;
    @Getter @Setter private Date nextVaccine;
    @Getter @Setter private Date nextPlannedVetApp;
    @Getter @Setter private boolean isSterilized;
    @Getter @Setter private boolean hasPassport;


}
