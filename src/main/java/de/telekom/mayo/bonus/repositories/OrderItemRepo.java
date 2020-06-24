package de.telekom.mayo.bonus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.telekom.mayo.bonus.entities.OrderItem;

@Repository
public interface OrderItemRepo extends JpaRepository <OrderItem, Long>{

}
