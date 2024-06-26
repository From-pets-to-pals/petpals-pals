package com.petpals.application.dto;

import com.petpals.shared.model.enums.SpeciesEnum;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;


public record AddPalRequest(
		@NotBlank @Length(min= 2) String name,
		@NotBlank @Length(min=2) String shortname,
		@Pattern(regexp = "^[250(26|22)\\d{10}]{15}$", message = "Identifier format invalid") String icadIdentifier,
		@Past String birthDate,
		@NotNull SpeciesEnum specie,
		@Size(min = 5, max = 25) String breed,
		@NotNull Boolean hasPassport,
		@NotNull boolean isMale,
		@NotNull Boolean isSterilized,
		@NotNull Boolean isVaccinated,
		List<String> medicalHistory,
		String nextVaccine,
		String nextPlannedVetApp,
		@NotBlank @Length(min = 36, max = 36) String reference,
		@DecimalMin(value = "0.1") @DecimalMax(value = "50.0") double weight,
		@DecimalMin(value = "0.1") @DecimalMax(value = "150.0") double height) {
}
	

