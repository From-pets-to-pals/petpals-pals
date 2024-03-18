package com.petpals.pals.domain.pals.services;

public class SavePalException extends RuntimeException{
    private final ErrorBodyResponse exceptionEnum;
    public ErrorBodyResponse getResponse() {
        return exceptionEnum;
    }

    public SavePalException(ExceptionsEnum exception) {
        super(exception.getUserMessageToDisplay());
        exceptionEnum = new ErrorBodyResponse(exception.getHttpResponseStatus(), exception.getUserMessageToDisplay(), "Domain");
    }
}
