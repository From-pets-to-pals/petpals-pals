package com.petpals.pals.domain.pals.utils.uuid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

import static java.util.UUID.randomUUID;

public class UUIDGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(UUIDGenerator.class.getName());

    public static UUID generateUUID(){
        LOGGER.info("Generating UUID reference.");
        UUID newRandomBusinessReference = randomUUID();
        LOGGER.info("UUID base Reference ".concat(newRandomBusinessReference.toString()).concat(" Successfully generated."));
        return newRandomBusinessReference;
    }
}
