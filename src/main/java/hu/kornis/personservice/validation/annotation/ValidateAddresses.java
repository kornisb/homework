package hu.kornis.personservice.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import hu.kornis.personservice.validation.AddressesValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AddressesValidator.class)
public @interface ValidateAddresses {

	public String message() default "Maximum number of addresses is 2";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
