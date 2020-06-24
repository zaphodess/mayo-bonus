package de.telekom.mayo.bonus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import de.telekom.mayo.bonus.entities.OrderItem;
import de.telekom.mayo.bonus.repositories.OrderItemRepo;

@RestController
@RequestMapping("/api/v1/order-items")
public class OrderItemRestController {
	
	@Autowired
	private OrderItemRepo orderItemRepo;
	
	@GetMapping
	public List<OrderItem> findAllOrderItems (){
		return orderItemRepo.findAll();	
	}
	
	@GetMapping ("/{id}")
	public OrderItem findOrderItemById (@PathVariable Long id){
		return this.orderItemRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrderItem createOrderItem(@RequestBody OrderItem newOrderItem) {
		return this.orderItemRepo.save(newOrderItem);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	ResponseEntity<?> deleteTopic(@PathVariable Long id) {
		try {
			this.orderItemRepo.deleteById(id);
			return new ResponseEntity<String>("Data deleted successfully", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<String>("Resource not found", HttpStatus.NOT_FOUND);
			}
		}

	@PutMapping("/{id}")
	public OrderItem replace(@RequestBody OrderItem newOrderItem, @PathVariable Long id) {
		return orderItemRepo.findById(id).map(orderItem -> {
			orderItem.setProduct(newOrderItem.getProduct());
			orderItem.setAmount(newOrderItem.getAmount());
			orderItem.setCostInCoins(newOrderItem.getCostInCoins());
			orderItem.setDate(newOrderItem.getDate());
			orderItem.setUser(newOrderItem.getUser());
			return orderItemRepo.save(orderItem);
		}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
