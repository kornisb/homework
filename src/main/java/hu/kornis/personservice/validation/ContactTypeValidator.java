package hu.kornis.personservice.validation;

import java.util.Arrays;

import hu.kornis.personservice.validation.annotation.ValidateContactType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ContactTypeValidator implements ConstraintValidator<ValidateContactType, String> {
    @Override
    public boolean isValid(String contactType, ConstraintValidatorContext constraintValidatorContext) {
    	return Arrays.asList("Email".toLowerCase(), "Phone".toLowerCase()).contains(contactType.toLowerCase());
    }
}
