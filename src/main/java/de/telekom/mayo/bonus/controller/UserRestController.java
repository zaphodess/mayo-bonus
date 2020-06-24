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

import de.telekom.mayo.bonus.entities.User;
import de.telekom.mayo.bonus.repositories.UserRepo;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping
	public List<User> findAllUsers (){
		return userRepo.findAll();	
	}
	
	@GetMapping ("/{id}")
	public User findUserById (@PathVariable Long id){
		return this.userRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User newUser) {
		return this.userRepo.save(newUser);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	ResponseEntity<?> deleteTopic(@PathVariable Long id) {
		try {
			this.userRepo.deleteById(id);
			return new ResponseEntity<String>("Data deleted successfully", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<String>("Resource not found", HttpStatus.NOT_FOUND);
			}
		}
	
	@PutMapping("/{id}")
	public User replace(@RequestBody User newUser, @PathVariable Long id) {
		return userRepo.findById(id).map(user -> {
			user.setFirstName(newUser.getFirstName());
			user.setLastName(newUser.getLastName());
			user.setEmail(newUser.getEmail());
			user.setPassword(newUser.getPassword());
			user.setCo2Saved(newUser.getCo2Saved());
			user.setSpentCoins(newUser.getSpentCoins());
			user.setAvailableCoins(newUser.getAvailableCoins());
			user.setSelectedGender(newUser.getSelectedGender());
			return userRepo.save(user);
		}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
