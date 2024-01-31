package hu.kornis.personservice.model;

import hu.kornis.personservice.validation.annotation.ValidateContactType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Contact {
	
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank
	private String contact;
	@ValidateContactType
    private String contactType;
}
