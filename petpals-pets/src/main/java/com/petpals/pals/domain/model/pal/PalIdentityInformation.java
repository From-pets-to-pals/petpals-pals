package com.petpals.pals.domain.model.pal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Builder
public class PalIdentityInformation {
    @NotNull
    @Size(min = 2, max=25, message = "Taille du nom de l'animal incorrecte")
    @Getter
    private String name;
    @Past(message = "La date doit être passée")
    @NotNull
    @Getter
    private Date birthDate;
    @NotNull
    @Getter
    private boolean isMale;
    @Getter
    @SpecieConstraint(enumClass = Species.class, message = "Invalid specie selected")
    private String specie;
    @Getter
    @Size(min=3, max=25, message="")
    private String race;
    @Getter
    @Size(min=15, max=15)
    private String icadIdentifier;
    @Getter
    @Setter
    private boolean hasPassport;
}
