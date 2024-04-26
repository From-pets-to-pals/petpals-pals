package com.petpals.application.dto

import jakarta.validation.constraints.Email

data class NewOwner(
    @Email val email: String  ,
    val functionalId: String,
    val deviceId: String,
    val location: String
)
