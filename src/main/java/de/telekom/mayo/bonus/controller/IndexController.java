//package de.telekom.mayo.bonus.controller;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import de.telekom.mayo.bonus.entities.User;
//import de.telekom.mayo.bonus.repositories.UserRepo;
//
//@Controller
//public class IndexController {
//	
//	@Autowired
//	private UserRepo userRepo;
//	
//	@GetMapping("/")
//    public String home(Model out) {
//		//use ID 1 to test logged in status, use 5 or more to test not logged in status
//		User user = userRepo.findById(1L).orElse(null);
//		String firstName;
//		boolean accountStatus;
//		long yourCo2Saving = getIndividualCo2();
//		long yourMayoCoins = yourCo2Saving/100L;
//		long yourMayoCoinsSpent = 0L;
//		long yourMayoCoinsAvailable = 0L;
//		
//		if (user!=null) {
//			firstName=user.getFirstName();
//			accountStatus=true;
//			out.addAttribute("saved_co2", yourCo2Saving);
//			out.addAttribute("your_mayo_coins", yourMayoCoins);
//		}
//		else {
//			firstName="Stranger";
//			accountStatus=false;
//					
//		}
//		out.addAttribute("first_name", firstName);
//		out.addAttribute("account_status", accountStatus);
//		
//		//Adding in if Statement when methods to retrieve data are finished?
//		// out.addAttribute("saved_co2", yourCo2Saving);
//		out.addAttribute("your_mayo_coins", yourMayoCoins);
//				
//        return "index";
//    }
//	
//	public Long getIndividualCo2 ( ) {
//		// implement DataRetrieval
//		
//		return 660L;
//	}
//
//
//}
