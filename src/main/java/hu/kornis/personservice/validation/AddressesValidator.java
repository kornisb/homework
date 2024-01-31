package hu.kornis.personservice.validation;

import java.util.List;
import java.util.Optional;

import hu.kornis.personservice.model.Address;
import hu.kornis.personservice.validation.annotation.ValidateAddresses;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AddressesValidator implements ConstraintValidator<ValidateAddresses, List<Address>> {
    @Override
    public boolean isValid(List<Address> addresses, ConstraintValidatorContext constraintValidatorContext) {
    	return Optional.ofNullable(addresses)
    			.map(list -> list.size() <= 2)
    	        .orElse(false);
    }
}
