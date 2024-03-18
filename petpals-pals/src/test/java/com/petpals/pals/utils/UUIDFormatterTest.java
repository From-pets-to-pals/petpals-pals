package com.petpals.pals.utils;

import com.petpals.pals.domain.pals.utils.uuid.UUIDFormatter;
import com.petpals.pals.domain.pals.utils.uuid.UUIDGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UUIDFormatterTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "_",
            ":",
            "/",
    })
    public void shouldProduceValidReferences(String joiner){
        var uuidToTest = UUIDGenerator.generateUUID();
        var formattedUUID = UUIDFormatter.formatUUIDSequence(uuidToTest,true,joiner);
        assertEquals(36, formattedUUID.length());
    }

    @Test
    public void shouldProduceValidReferences(){
        var uuidToTest = UUIDGenerator.generateUUID();
        var formattedUUID = UUIDFormatter.formatUUIDSequence(uuidToTest,true,"");
        assertEquals(32, formattedUUID.length());
    }
}
