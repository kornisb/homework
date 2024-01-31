package hu.kornis.personservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.kornis.personservice.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	
}
