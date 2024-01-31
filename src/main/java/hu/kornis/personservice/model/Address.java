package hu.kornis.personservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Address {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String address;
	private String addressType;
}
