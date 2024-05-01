package com.petpals.application.dto;

import com.petpals.shared.enums.Species;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public record AddFirstPal(
		boolean isVaccinated,
		@NotBlank @Length(min = 36, max = 36) String reference,
		@NotBlank @Length(min= 2) String name,
		@NotBlank @Length(min=2) String shortName,
		@Past Date birthDate,
		@NotNull boolean isMale,
		@NotNull Species specie,
		@Size(min = 5, max = 25) String breed,
		@Pattern(regexp = "^[250(26|22)\\d{10}]{15}$", message = "Identifier format invalid") String icadIdentifier,
		@NotNull Boolean hasPassport,
		@NotNull Boolean isSterilized,
		@DecimalMin(value = "0.1") @DecimalMax(value = "50.0") double weight,
		@DecimalMin(value = "0.1") @DecimalMax(value = "150.0") double height) {
}
	

