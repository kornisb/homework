package hu.kornis.personservice.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import hu.kornis.personservice.model.Address;
import jakarta.validation.ConstraintValidatorContext;

@ExtendWith(MockitoExtension.class)
public class AddressesValidatorTest {

	@Mock
	private ConstraintValidatorContext constraintValidatorContext;
	
	@InjectMocks
	private AddressesValidator underTest;
	
	@Test
	void testAddressesValidatorReturnFalseWhenCalledWithNullList() {
		// GIVEN

        // WHEN
        boolean result = underTest.isValid(null, constraintValidatorContext);

        // THEN
        assertFalse(result);
	}
	
	@Test
	void testAddressesValidatorReturnTrueWhenCalledWithEmptyList() {
		// GIVEN

        // WHEN
        boolean result = underTest.isValid(Collections.emptyList(), constraintValidatorContext);

        // THEN
        assertTrue(result);
	}

	@Test
	void testAddressesValidatorReturnTrueWhenCalledWithTwoElementList() {
		// GIVEN

        // WHEN
        boolean result = underTest.isValid(Arrays.asList(new Address(), new Address()), constraintValidatorContext);

        // THEN
        assertTrue(result);
	}
	
	@Test
	void testAddressesValidatorReturnFalseWhenCalledWithMoreThanTwoElementList() {
		// GIVEN

        // WHEN
        boolean result = underTest.isValid(Arrays.asList(new Address(), new Address(), new Address()), constraintValidatorContext);

        // THEN
        assertFalse(result);
	}
}
