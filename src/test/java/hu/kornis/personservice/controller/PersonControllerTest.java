package hu.kornis.personservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import hu.kornis.personservice.model.Person;
import hu.kornis.personservice.service.PersonService;

@ExtendWith(MockitoExtension.class)
public class PersonControllerTest {

	@Mock
    private PersonService personService;
	
	@InjectMocks
    private PersonController underTest;

    @Test
    public void testPersonControllerGetAllPersonsShouldReturnListOfPersons() {
        // GIVEN
        List<Person> persons = Arrays.asList(new Person(), new Person());
        Mockito.when(personService.getAllPersons()).thenReturn(new ResponseEntity<>(persons, HttpStatus.OK));

        // WHEN
        ResponseEntity<List<Person>> result = underTest.getAllPersons();

        // THEN
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(persons, result.getBody());
    }

    @Test
    public void testPersonControllerGetPersonByIdValidIdShouldReturnPerson() {
        // GIVEN
        int validId = 1;
        Person person = new Person();
        Mockito.when(personService.getPersonById(validId)).thenReturn(new ResponseEntity<>(person, HttpStatus.OK));

        // WHEN
        ResponseEntity<Person> result = underTest.getPersonById(validId);

        // THEN
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(person, result.getBody());
    }
    
    @Test
    public void testPersonControllerGetPersonByIdNonExistingIdShouldReturnNotFound() {
        // GIVEN
        int nonExistingId = 999;
        when(personService.getPersonById(nonExistingId)).thenReturn(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        // WHEN
        ResponseEntity<Person> result = underTest.getPersonById(nonExistingId);

        // THEN
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertNull(result.getBody());
    }

    @Test
    public void testPersonControllerAddPersonValidPersonShouldReturnCreatedPerson() {
        // GIVEN
        Person validPerson = new Person();
        Mockito.when(personService.addPerson(validPerson)).thenReturn(new ResponseEntity<>(validPerson, HttpStatus.CREATED));

        // WHEN
        ResponseEntity<Person> result = underTest.addPerson(validPerson);

        // THEN
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(validPerson, result.getBody());
    }

    @Test
    public void testPersonControllerUpdatePersonByIdValidIdAndPersonShouldReturnUpdatedPerson() {
        // GIVEN
        int validId = 1;
        Person validPerson = new Person();
        Mockito.when(personService.updatePersonById(validId, validPerson))
                .thenReturn(new ResponseEntity<>(validPerson, HttpStatus.OK));

        // WHEN
        ResponseEntity<Person> result = underTest.updatePersonById(validId, validPerson);

        // THEN
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(validPerson, result.getBody());
    }
    
    @Test
    public void testPersonControllerUpdatePersonByIdNonExistingIdShouldReturnNotFound() {
        // GIVEN
        int nonExistingId = 999;
        Person person = new Person();
        when(personService.updatePersonById(nonExistingId, person)).thenReturn(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        // WHEN
        ResponseEntity<Person> result = underTest.updatePersonById(nonExistingId, person);

        // THEN
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertNull(result.getBody());
    }

    @Test
    public void testPersonControllerDeletePersonByIdValidIdDShouldReturnSuccessMessage() {
        // GIVEN
        int validId = 1;
        Mockito.when(personService.deletePersonById(validId)).thenReturn(new ResponseEntity<>("Success", HttpStatus.OK));

        // WHEN
        ResponseEntity<String> result = underTest.deletePersonById(validId);

        // THEN
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Success", result.getBody());
    }
    
    @Test
    public void testPersonControllerDeletePersonByIdNonExistingIdShouldReturnNotFound() {
        // GIVEN
        int nonExistingId = 999;
        when(personService.deletePersonById(nonExistingId)).thenReturn(ResponseEntity.notFound().build());

        // WHEN
        ResponseEntity<String> result = underTest.deletePersonById(nonExistingId);

        // THEN
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertNull(result.getBody());
    }
}
