package com.misicode.purpost.imageservice.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FileValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFile {
    String message() default "El campo debe tener un archivo válido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

