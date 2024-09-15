package com.misicode.purpost.imageservice.domain.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class FileValidator implements ConstraintValidator<ValidFile, MultipartFile> {
    @Override
    public void initialize(ValidFile constraintAnnotation) {
        // Método vacío porque la lógica de inicialización no es necesaria para esta validación
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        return file != null && !file.isEmpty();
    }
}
