package com.petpals.pals.domain.pals.services.exceptions;

import io.micronaut.http.HttpStatus;

public record ErrorBodyResponse(HttpStatus httpResponseStatus, String errorMessage, String errorOrigin){
}
