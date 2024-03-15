package com.petpals.pals.validators;

import com.petpals.pals.domain.model.pal.Pal;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPalValidators {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testNameValidation() {
        Pal validPal = Pal.builder().name("Buddy").birthDate(Date.valueOf("2010-01-01")).build();
        Pal invalidPal = Pal.builder().name("A").birthDate(Date.valueOf("2010-01-01")).build();
        assertTrue(validator.validate(validPal).isEmpty());
        assertFalse(validator.validate(invalidPal).isEmpty());
    }

    @Test
    public void testBirthDateValidation() {
        Pal validPal = Pal.builder().name("Buddy").birthDate(Date.valueOf("2010-01-01")).build();
        Pal futureDatePal = Pal.builder().name("Buddy").birthDate(Date.valueOf("2050-01-01")).build();
        assertTrue(validator.validate(validPal).isEmpty());
        assertFalse(validator.validate(futureDatePal).isEmpty());
    }

    @Test
    public void testSpecieConstraint() {
        // Assuming valid "species" is "Dog" for this example
        Pal validPal = Pal.builder().name("Buddy").birthDate(Date.valueOf("2010-01-01")).specie("Dog").build();
        Pal invalidPal = Pal.builder().name("Buddy").birthDate(Date.valueOf("2010-01-01")).specie("InvalidSpecies").build();
        assertTrue(validator.validate(validPal).isEmpty());
        assertFalse(validator.validate(invalidPal).isEmpty());
    }

    @Test
    public void testRaceSizeValidation() {
        Pal validPal = Pal.builder().name("Buddy").birthDate(Date.valueOf("2010-01-01")).race("Labrador").build();
        Pal invalidPal = Pal.builder().name("A").birthDate(Date.valueOf("2010-01-01")).race("L").build();
        assertTrue(validator.validate(validPal).isEmpty());
        assertFalse(validator.validate(invalidPal).isEmpty());
    }

    @Test
    public void testIcadIdentifierSizeValidation() {
        Pal validPal = Pal.builder().name("Buddy").birthDate(Date.valueOf("2010-01-01")).icadIdentifier("123456789012345").build();
        Pal invalidPal = Pal.builder().name("Buddy").birthDate(Date.valueOf("2010-01-01")).icadIdentifier("123").build();
        assertTrue(validator.validate(validPal).isEmpty());
        assertFalse(validator.validate(invalidPal).isEmpty());
    }

    @Test
    public void testWeightMinValidation() {
        Pal validPal = Pal.builder().name("Buddy").birthDate(Date.valueOf("2010-01-01")).weight(1.0).build();
        Pal invalidPal = Pal.builder().name("Buddy").birthDate(Date.valueOf("2010-01-01")).weight(0.0).build();
        assertTrue(validator.validate(validPal).isEmpty());
        assertFalse(validator.validate(invalidPal).isEmpty());
    }

    @Test
    public void testHeightMinValidation() {
        Pal validPal = Pal.builder().name("Buddy").birthDate(Date.valueOf("2010-01-01")).height(1.0).build();
        Pal invalidPal = Pal.builder().name("Buddy").birthDate(Date.valueOf("2010-01-01")).height(-1.0).build();
        assertTrue(validator.validate(validPal).isEmpty());
        assertFalse(validator.validate(invalidPal).isEmpty());
    }

    @Test
    public void testIdPatternValidation() {
        Pal validPal = Pal.builder().name("Buddy").birthDate(Date.valueOf("2010-01-01")).id("250269600043279").build();
        Pal invalidPal = Pal.builder().name("Buddy").birthDate(Date.valueOf("2010-01-01")).id("invalid").build();
        assertTrue(validator.validate(validPal).isEmpty());
        assertFalse(validator.validate(invalidPal).isEmpty());
    }

    @Test
    public void testNextVaccineFutureValidation() {
        Pal validPal = Pal.builder().name("Buddy").birthDate(Date.valueOf("2010-01-01")).nextVaccine(Date.valueOf("2050-01-01")).build();
        Pal invalidPal = Pal.builder().name("Buddy").birthDate(Date.valueOf("2010-01-01")).nextVaccine(Date.valueOf("2000-01-01")).build();
        assertTrue(validator.validate(validPal).isEmpty());
        assertFalse(validator.validate(invalidPal).isEmpty());
    }
}