package com.petpals.application.dto;

import com.petpals.shared.enums.Species;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public record AddPalRequest(
		@NotBlank @Length(min= 2) String name,
		@NotBlank @Length(min=2) String shortname,
		@Pattern(regexp = "^[250(26|22)\\d{10}]{15}$", message = "Identifier format invalid") String icadIdentifier,
		@Past Date birthDate,
		@NotNull Species specie,
		@Size(min = 5, max = 25) String breed,
		@NotNull Boolean hasPassport,
		@NotNull boolean isMale,
		@NotNull Boolean isSterilized,
		@NotNull Boolean isVaccinated,
		Date nextVaccine,
		Date nextPlannedApp,
		@NotBlank @Length(min = 36, max = 36) String reference,
		
		@DecimalMin(value = "0.1") @DecimalMax(value = "50.0") double weight,
		@DecimalMin(value = "0.1") @DecimalMax(value = "150.0") double height) {
}
	

