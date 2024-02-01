package hu.kornis.personservice.model;

import java.util.List;

import hu.kornis.personservice.validation.annotation.ValidateAddresses;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@Valid
	@NotNull
	@ValidateAddresses
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> addresses;
	@Valid
	@OneToMany(cascade = CascadeType.ALL)
	private List<Contact> contacts;
}
