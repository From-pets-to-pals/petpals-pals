package com.petpals.pals.domain.pals.services;


import io.micronaut.http.HttpStatus;

public enum ExceptionsEnum {

    OWNER_EXISTS(
            "The owner already has an account",
            HttpStatus.IM_USED);

    private final String userMessageToDisplay;
    private final HttpStatus httpResponseStatus;
    ExceptionsEnum(String userMessageToDisplay
            , HttpStatus httpResponseStatus) {
        this.userMessageToDisplay = userMessageToDisplay;
        this.httpResponseStatus = httpResponseStatus;
    }

    public String getUserMessageToDisplay() { return userMessageToDisplay; }


    public HttpStatus getHttpResponseStatus() {
        return httpResponseStatus;
    }

}

