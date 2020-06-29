package de.telekom.mayo.bonus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductListController {
	
	@GetMapping("/product-list")
    public String productList() {
		
		return "product-list";
	}

}
