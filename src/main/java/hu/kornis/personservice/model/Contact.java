package hu.kornis.personservice.model;

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
	private String contact;
    private String contactType;
}
