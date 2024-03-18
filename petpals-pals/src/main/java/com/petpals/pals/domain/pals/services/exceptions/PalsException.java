package com.petpals.pals.domain.pals.services.exceptions;

import com.petpals.pals.domain.pals.services.exceptions.ErrorBodyResponse;
import com.petpals.pals.domain.pals.services.exceptions.ExceptionsEnum;

public class PalsException extends RuntimeException{
    private final ErrorBodyResponse exceptionEnum;
    public ErrorBodyResponse getResponse() {
        return exceptionEnum;
    }

    public PalsException(ExceptionsEnum exception) {
        super(exception.getUserMessageToDisplay());
        exceptionEnum = new ErrorBodyResponse(exception.getHttpResponseStatus(), exception.getUserMessageToDisplay(), "Domain");
    }
}
