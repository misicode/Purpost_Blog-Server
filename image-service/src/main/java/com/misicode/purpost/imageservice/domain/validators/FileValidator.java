package com.misicode.purpost.imageservice.domain.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.http.codec.multipart.FilePart;

public class FileValidator implements ConstraintValidator<ValidFile, FilePart> {
    @Override
    public void initialize(ValidFile constraintAnnotation) {
        // Método vacío porque la lógica de inicialización no es necesaria para esta validación
    }

    @Override
    public boolean isValid(FilePart file, ConstraintValidatorContext context) {
        return file != null && !file.filename().isEmpty();
    }
}
