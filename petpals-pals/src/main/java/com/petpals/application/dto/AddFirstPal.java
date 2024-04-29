package com.petpals.application.dto;

import com.petpals.shared.enums.Species;
import jakarta.validation.constraints.*;

import java.util.Date;

public record AddFirstPal(
		boolean isVaccinated,
		@NotBlank String reference,
		@NotBlank String name,
		@NotBlank String shortName,
		@Past Date birthDate,
		@NotNull boolean isMale,
		@NotNull Species specie,
		@Size(min = 5, max = 25) String breed,
		@Pattern(regexp = "^[250(26|22)\\d{10}]{15}$") String icadIdentifier,
		@NotNull Boolean hasPassport,
		@NotNull Boolean isSterilized,
		@Positive double weight,
		@Positive double height) {
}
	

