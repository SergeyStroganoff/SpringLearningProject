package org.example.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String> { // annotation and Type of date
    // we will apply this verification
    private String endOfEmail;

    @Override
    public void initialize(CheckEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        endOfEmail = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext constraintValidatorContext) {
        return enteredValue.endsWith(endOfEmail);
    }
}
