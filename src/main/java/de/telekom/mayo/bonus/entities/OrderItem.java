package de.telekom.mayo.bonus.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import de.telekom.mayo.bonus.entities.OrderForm.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Product product;
	@ManyToOne
	private User user;
	private int amount;
	private int costInCoins;
	private LocalDate date;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	public static enum OrderStatus {
		on_wishlist, in_progress, rejected, delivery, done;
	}
	

}
