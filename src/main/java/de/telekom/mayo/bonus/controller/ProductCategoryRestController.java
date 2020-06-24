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
import de.telekom.mayo.bonus.entities.ProductCategory;
import de.telekom.mayo.bonus.repositories.ProductCategoryRepo;

@RestController
@RequestMapping("/api/v1/product-categories")
public class ProductCategoryRestController {
	
	@Autowired
	private ProductCategoryRepo productCategoryRepo;
	
	@GetMapping
	public List<ProductCategory> findAllProductCategories (){
		return productCategoryRepo.findAll();	
	}
	
	@GetMapping ("/{id}")
	public ProductCategory findProductCategoryById (@PathVariable Long id){
		return this.productCategoryRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductCategory createProductCategory(@RequestBody ProductCategory newProductCategory) {
		return this.productCategoryRepo.save(newProductCategory);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	ResponseEntity<?> deleteTopic(@PathVariable Long id) {
		try {
			this.productCategoryRepo.deleteById(id);
			return new ResponseEntity<String>("Data deleted successfully", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<String>("Resource not found", HttpStatus.NOT_FOUND);
			}
		}
	
	@PutMapping("/{id}")
	public ProductCategory replace(@RequestBody ProductCategory newProductCategory, @PathVariable Long id) {
		return productCategoryRepo.findById(id).map(productCategory -> {
			productCategory.setCategory(newProductCategory.getCategory());
			productCategory.setCategoryDescription(newProductCategory.getCategoryDescription());
			return productCategoryRepo.save(productCategory);
		}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	

}
