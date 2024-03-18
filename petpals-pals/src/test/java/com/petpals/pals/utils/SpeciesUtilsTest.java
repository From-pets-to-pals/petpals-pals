package com.petpals.pals.utils;


import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@MicronautTest(startApplication = false)
public class SpeciesUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "DOG",
            "CAT",
            "FERET",
            "NAC"
    })
    void validSpecies(String specie) {
        /**var constraints = validator.isValid(specie);
        assertTrue(validator.validate(specie).isEmpty());*/
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "MOUSE",
            "LION",
            "TIGER",
            "WOMEN",
            ""
    })
    void invalidSpecies(String specie) {

        //assertFalse(!constraints.isEmpty());
    }
}
