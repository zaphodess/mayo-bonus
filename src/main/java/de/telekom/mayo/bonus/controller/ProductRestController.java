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

import de.telekom.mayo.bonus.entities.Product;
import de.telekom.mayo.bonus.repositories.ProductRepo;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {
	
	@Autowired
	private ProductRepo productRepo;
	
	@GetMapping
	public List<Product> findAllProducts (){
		return productRepo.findAll();	
	}
	
	@GetMapping ("/{id}")
	public Product findProductById (@PathVariable Long id){
		return this.productRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product newProduct) {
		return this.productRepo.save(newProduct);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	ResponseEntity<?> deleteTopic(@PathVariable Long id) {
		try {
			this.productRepo.deleteById(id);
			return new ResponseEntity<String>("Data deleted successfully", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<String>("Resource not found", HttpStatus.NOT_FOUND);
			}
		}
	
	@PutMapping("/{id}")
	public Product replace(@RequestBody Product newProduct, @PathVariable Long id) {
		return productRepo.findById(id).map(product -> {
			product.setName(newProduct.getName());
			product.setDescription(newProduct.getDescription());
			product.setPoints(newProduct.getPoints());
			product.setProductCategories(newProduct.getProductCategories());
			return productRepo.save(product);
		}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
		
}

