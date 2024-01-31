package hu.kornis.personservice.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import hu.kornis.personservice.validation.ContactTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ContactTypeValidator.class)
public @interface ValidateContactType {

	public String message() default "Invalid contactType: It should be either Phone or Email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
