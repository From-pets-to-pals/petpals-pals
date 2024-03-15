package com.petpals.pals.domain.model.pal;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = SpecieEnumerationValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, PARAMETER, CONSTRUCTOR })
@Retention(RUNTIME)
public @interface SpecieConstraint {
    String message() default "{com.xxx.bean.validation.constraints.StringEnumeration.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    Class<? extends Enum<?>> enumClass();
}
