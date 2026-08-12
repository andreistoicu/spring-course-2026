package org.example.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidateAuthorValidator implements ConstraintValidator<ValidateAuthor, String> {

    @Override
    public void initialize(ValidateAuthor constraintAnnotation) {
        // no initialization needed
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            // don't claim responsibility for null/blank: let @NotBlank handle it if used
            return true;
        }

        // Split by whitespace and count non-empty words
        String[] words = value.trim().split("\\s+");

        // Return true if at least 2 words
        return words.length >= 2;
    }
}

