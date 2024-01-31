package hu.kornis.personservice.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;

import lombok.Data;

@Data
@Entity
public class Person {

	@Id
	@GeneratedValue
	private Integer id;
	private String firstName;
	private String lastName;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> addresses;
	@Valid
	@OneToMany(cascade = CascadeType.ALL)
	private List<Contact> contacts;
}
