package com.petpals.application.dto;

import jakarta.validation.constraints.NotBlank;

public record NewOwner(@NotBlank String email, @NotBlank String deviceId,@NotBlank String reference,
					   @NotBlank String location) {

}

