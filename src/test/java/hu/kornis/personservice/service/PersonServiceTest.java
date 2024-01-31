package hu.kornis.personservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import hu.kornis.personservice.model.Person;
import hu.kornis.personservice.repository.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	@Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService underTest;

    @Test
    public void getAllPersons_ReturnsListOfPersons() {
        // GIVEN
        List<Person> persons = Arrays.asList(new Person(), new Person());
        when(personRepository.findAll()).thenReturn(persons);

        // WHEN
        ResponseEntity<List<Person>> response = underTest.getAllPersons();

        // THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(persons, response.getBody());
    }

    @Test
    public void getPersonById_ExistingId_ReturnsPerson() {
        // GIVEN
        int existingId = 1;
        Person existingPerson = new Person();
        when(personRepository.findById(existingId)).thenReturn(Optional.of(existingPerson));

        // WHEN
        ResponseEntity<Person> response = underTest.getPersonById(existingId);

        // THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(existingPerson, response.getBody());
    }

    @Test
    public void getPersonById_NonExistingId_ReturnsNotFound() {
        // GIVEN
        int nonExistingId = 2;
        when(personRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        // WHEN
        ResponseEntity<Person> response = underTest.getPersonById(nonExistingId);

        // THEN
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void addPerson_ReturnsCreatedPerson() {
        // GIVEN
        Person newPerson = new Person();
        when(personRepository.save(newPerson)).thenReturn(newPerson);

        // WHEN
        ResponseEntity<Person> response = underTest.addPerson(newPerson);

        // THEN
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newPerson, response.getBody());
    }

    @Test
    public void updatePersonById_ExistingId_ReturnsUpdatedPerson() {
        // GIVEN
        int existingId = 1;
        Person existingPerson = new Person();
        Person updatedPerson = new Person();
        when(personRepository.findById(existingId)).thenReturn(Optional.of(existingPerson));
        when(personRepository.save(existingPerson)).thenReturn(updatedPerson);

        // WHEN
        ResponseEntity<Person> response = underTest.updatePersonById(existingId, existingPerson);

        // THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedPerson, response.getBody());
    }

    @Test
    public void updatePersonById_NonExistingId_ReturnsNotFound() {
        // GIVEN
        int nonExistingId = 2;
        when(personRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        // WHEN
        ResponseEntity<Person> response = underTest.updatePersonById(nonExistingId, new Person());

        // THEN
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void deletePersonById_ExistingId_ReturnsNoContent() {
        // GIVEN
        int existingId = 1;
        when(personRepository.existsById(existingId)).thenReturn(true);

        // WHEN
        ResponseEntity<String> response = underTest.deletePersonById(existingId);

        // THEN
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(personRepository, times(1)).deleteById(existingId);
    }

    @Test
    public void deletePersonById_NonExistingId_ReturnsNotFound() {
        // GIVEN
        int nonExistingId = 2;
        when(personRepository.existsById(nonExistingId)).thenReturn(false);

        // WHEN
        ResponseEntity<String> response = underTest.deletePersonById(nonExistingId);

        // THEN
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(personRepository, never()).deleteById(anyInt());
    }
}
