package com.petpals.pals.utils;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class SpeciesUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "DOG",
            "CAT",
            "FERET",
            "NAC"
    })
    void validSpecies(String specie) {
        String caminhoProjeto = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(
                caminhoProjeto
        );
        /**
        var constraints = validator.isValid(specie);
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
