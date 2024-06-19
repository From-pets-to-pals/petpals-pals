package com.petpals.application.dto;

import jakarta.validation.constraints.*;


public record AuthOwnerRequest(
		@Email  String email,
		@NotBlank  String password
) {
}
	

