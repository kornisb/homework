package hu.kornis.personservice.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import jakarta.servlet.http.HttpServletResponse;

@ExtendWith(MockitoExtension.class)
public class ApplicationExceptionHandlerTest {

	@Mock
    private HttpServletResponse response;
	
    @Mock
    private BindingResult bindingResult;
    
    @InjectMocks
    private ApplicationExceptionHandler underTest;

    @Test
    public void testApplicationExceptionHandlerWithFieldErrorsShouldReturnErrorMap() {
    	// GIVEN
        MethodArgumentNotValidException exception = createExceptionWithErrors();

        // WHEN
        ResponseEntity<Map<String, String>> result = underTest.handleMethodArgumentException(exception);

        // THEN
        assertEquals(2, result.getBody().size());
        assertEquals("Field error 1", result.getBody().get("field1"));
        assertEquals("Field error 2", result.getBody().get("field2"));
    }

    @Test
    public void testApplicationExceptionHandlerWithNoFieldErrorsShouldReturnEmptyMap() {
    	// GIVEN
    	MethodArgumentNotValidException exception = createExceptionWithNoErrors();

    	// WHEN
    	ResponseEntity<Map<String, String>> result = underTest.handleMethodArgumentException(exception);

        // THEN
        assertEquals(0, result.getBody().size());
    }

    @Test
    public void testApplicationExceptionHandlerShouldReturnBadRequestStatus() {
    	// GIVEN
    	MethodArgumentNotValidException exception = createExceptionWithNoErrors();

    	// WHEN
        ResponseEntity<Map<String, String>> result = underTest.handleMethodArgumentException(exception);

        // THEN
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    private MethodArgumentNotValidException createExceptionWithErrors() {
    	when(bindingResult.getFieldErrors()).thenReturn(Arrays.asList(
                new FieldError("objectName", "field1", "Field error 1"),
                new FieldError("objectName", "field2", "Field error 2")
        ));
        return new MethodArgumentNotValidException(null, bindingResult);
    }

    private MethodArgumentNotValidException createExceptionWithNoErrors() {
    	when(bindingResult.getFieldErrors()).thenReturn(Arrays.asList());
        return new MethodArgumentNotValidException(null, bindingResult);
    }
}
