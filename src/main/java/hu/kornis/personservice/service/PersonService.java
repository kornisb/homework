package hu.kornis.personservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.kornis.personservice.model.Person;
import hu.kornis.personservice.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public ResponseEntity<List<Person>> getAllPersons() {
		return ResponseEntity.ok().body(personRepository.findAll());
	}

	public ResponseEntity<Person> getPersonById(int id) {
		return personRepository.findById(id)
	            .map(ResponseEntity::ok)
	            .orElseGet(() -> ResponseEntity.notFound().build());
	}

	public ResponseEntity<Person> addPerson(Person person) {
		return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
	}

	@Transactional
	public ResponseEntity<Person> updatePersonById(int id, Person person) {
	    return personRepository.findById(id)
	            .map(existingPerson -> {
	                existingPerson.setFirstName(person.getFirstName());
	                existingPerson.setLastName(person.getLastName());
	                existingPerson.setAddresses(person.getAddresses());
	                existingPerson.setContacts(person.getContacts());
	                return existingPerson;
	            })
	            .map(personRepository::save)
	            .map(ResponseEntity::ok)
	            .orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<String> deletePersonById(int id) {
		ResponseEntity<String> response;
		if (personRepository.existsById(id)) {
			personRepository.deleteById(id);
			response = ResponseEntity.noContent().build();
		} else {
			response = ResponseEntity.notFound().build();
		}
		return response;
	}
}
