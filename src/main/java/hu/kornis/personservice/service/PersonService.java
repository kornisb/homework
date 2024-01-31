package hu.kornis.personservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import hu.kornis.personservice.model.Person;
import hu.kornis.personservice.model.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public ResponseEntity<List<Person>> getAllPersons() {
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Person> getPersonById(int id) {
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Person> addPerson(Person person) {
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Person> updatePersonById(int id, Person person) {
	    return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<String> deletePersonById(int id) {
		return ResponseEntity.ok().build();
	}
}
