package hu.kornis.personservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.kornis.personservice.model.Person;
import hu.kornis.personservice.service.PersonService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("get/all")
	public ResponseEntity<List<Person>> getAllPersons() {
		return personService.getAllPersons();
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable int id) {
		return personService.getPersonById(id);
	}
	
	@PostMapping("add")
	public ResponseEntity<Person> addPerson(@RequestBody @Valid Person person) {
		return personService.addPerson(person);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Person> updatePersonById(@PathVariable int id, @RequestBody @Valid Person person) {
		return personService.updatePersonById(id, person);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deletePersonById(@PathVariable int id) {
		return personService.deletePersonById(id);
	}
}
