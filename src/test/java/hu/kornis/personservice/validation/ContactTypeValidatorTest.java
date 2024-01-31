package hu.kornis.personservice.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.validation.ConstraintValidatorContext;

@ExtendWith(MockitoExtension.class)
public class ContactTypeValidatorTest {

	@Mock
	private ConstraintValidatorContext constraintValidatorContext;
	
	@InjectMocks
	private ContactTypeValidator underTest;
	
	@Test
    void testValidContactType() {
        // GIVEN
        String validContactType = "Email";

        // WHEN
        boolean isValid = underTest.isValid(validContactType, constraintValidatorContext);

        // THEN
        assertTrue(isValid);
    }

    @Test
    void testValidContactTypeIgnoreCase() {
        // GIVEN
        String validContactType = "email";

        // WHEN
        boolean isValid = underTest.isValid(validContactType, constraintValidatorContext);

        // THEN
        assertTrue(isValid);
    }

    @Test
    void testInvalidContactType() {
        // GIVEN
        String invalidContactType = "InvalidType";

        // WHEN
        boolean isValid = underTest.isValid(invalidContactType, constraintValidatorContext);

        // THEN
        assertFalse(isValid);
    }
}
