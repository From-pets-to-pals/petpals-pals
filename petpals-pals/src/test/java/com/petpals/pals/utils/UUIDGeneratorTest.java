package com.petpals.pals.utils;

import com.petpals.pals.domain.pals.utils.uuid.UUIDGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UUIDGeneratorTest {
    @Test
    public void shouldReturnValidUUID(){
        var toTest = UUIDGenerator.generateUUID();
        assertEquals(toTest.getClass().getSimpleName(),"UUID");
    }
}
