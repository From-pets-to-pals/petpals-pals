package com.petpals.pals.domain.model.pal;

import com.petpals.pals.domain.model.pal.SpecieConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SpecieEnumerationValidator implements ConstraintValidator<SpecieConstraint,String> {
    private Set<String> allowedValues;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void initialize(SpecieConstraint constraintAnnotation) {
        Class<? extends Enum> enumSelected = constraintAnnotation.enumClass();
        allowedValues = (Set<String>) EnumSet.allOf(enumSelected).stream().map(e -> ((Enum<? extends Enum<?>>) e).name())
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || allowedValues.contains(value);
    }

}
