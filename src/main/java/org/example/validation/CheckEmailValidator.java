package org.example.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail,String> {

    private String endOfEmail;

    @Override
    public void initialize(CheckEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        endOfEmail = constraintAnnotation.value(); // get value from annotation for check
    }

    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext context) {
        return enteredValue.endsWith(endOfEmail); // checking process
    }
}
