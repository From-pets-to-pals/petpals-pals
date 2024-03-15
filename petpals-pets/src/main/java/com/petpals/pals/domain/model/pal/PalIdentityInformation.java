package com.petpals.pals.domain.model.pal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.sql.Date;

public record PalIdentityInformation (
    @NotNull
    @Size(min = 2, max=25, message = "Taille du nom de l'animal incorrecte")
    String name,
    @Past(message = "La date doit être passée")
    @NotNull
    Date birthDate,
    @NotNull
    boolean isMale,
    @SpecieConstraint(enumClass = Species.class, message = "Invalid specie selected")
    Species specie,
    @Size(min=3, max=25, message="")
    String race,
    @Size(min=15, max=15)
    String icadIdentifier,
    @NotNull
    boolean hasPassport
){}
