package de.telekom.mayo.bonus.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	// CO2 ist der Wert, den wir brauchen, das Mayo-Backend müsste das liefern.
	private Long co2Saved;
	private int spentCoins;
	private int availableCoins;
	// Gender
	@Enumerated(EnumType.STRING)
	private Gender selectedGender;

	public static enum Gender {
		male, female, third;
	}
	

	// Optional?
	// private String username;

	
	

}
