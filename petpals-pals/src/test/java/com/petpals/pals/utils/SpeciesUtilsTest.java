package com.petpals.pals.utils;


import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import jakarta.validation.Validator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@MicronautTest(startApplication = false)
public class SpeciesUtilsTest {

    @Inject
    Validator validator;
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
