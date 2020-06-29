package de.telekom.mayo.bonus.config;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import de.telekom.mayo.bonus.entities.Image;
//import de.telekom.mayo.bonus.entities.Image.ImageFormat;
import de.telekom.mayo.bonus.entities.OrderItem;
import de.telekom.mayo.bonus.entities.Product;
import de.telekom.mayo.bonus.entities.ProductCategory;
import de.telekom.mayo.bonus.entities.User;
import de.telekom.mayo.bonus.entities.User.Gender;
import de.telekom.mayo.bonus.repositories.ImageRepo;
import de.telekom.mayo.bonus.repositories.OrderItemRepo;
import de.telekom.mayo.bonus.repositories.ProductCategoryRepo;
import de.telekom.mayo.bonus.repositories.ProductRepo;
import de.telekom.mayo.bonus.repositories.UserRepo;
import de.telekom.mayo.bonus.service.AvailableCoinsService;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private UserRepo userRepo;
	private ProductRepo productRepo;
	private ProductCategoryRepo productCategoryRepo;
	private OrderItemRepo orderItemRepo;
//	private OrderFormRepo orderFormRepo;
	private ImageRepo imageRepo;
	private AvailableCoinsService availableCoinsService;

	@Autowired
	public DataLoader(UserRepo userRepo, ProductRepo productRepo, ProductCategoryRepo productCategoryRepo,
			OrderItemRepo orderItemRepo, ImageRepo imageRepo, AvailableCoinsService availableCoinsService) {
		super();
		this.userRepo = userRepo;
		this.productRepo = productRepo;
		this.productCategoryRepo = productCategoryRepo;
		this.orderItemRepo = orderItemRepo;
//		this.orderFormRepo = orderFormRepo;
		this.imageRepo = imageRepo;
		this.availableCoinsService = availableCoinsService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		User user1 = new User();
		user1.setFirstName("Monika");
		user1.setLastName("Messerer");
		user1.setEmail("monika.messerer@t-online.de");
		user1.setSelectedGender(Gender.female);
		user1.setCo2Saved(250L);
		user1.setSpentCoins(20);
		user1.setAvailableCoins(availableCoinsService.calculateAvailableCoins(250L, 0));
		userRepo.save(user1);
		
		User user2 = new User();
		user2.setFirstName("Carl");
		user2.setLastName("von Heesen");
		user2.setEmail("monika.messerer@telekom.de");
		user2.setSelectedGender(Gender.male);
		user2.setCo2Saved(500L);
		userRepo.save(user2);
		
		User user3 = User
				.builder()
				.firstName("Emanuel")
				.lastName("Macron")
				.email("emanuel@governement.fr")
				.selectedGender(Gender.male)
				.co2Saved(900L)
				.spentCoins(20)
				.availableCoins(availableCoinsService.calculateAvailableCoins(900L, 20))
				.build();
		userRepo.save(user3);
		
			
		ProductCategory cat1 = new ProductCategory();
		cat1.setCategory("Spenden");
		cat1.setCategoryDescription("Das ist steuerlich absetzbar und politisch korrekt.");
		productCategoryRepo.save(cat1);
		
		ProductCategory cat2 = new ProductCategory();
		cat2.setCategory("Parteispenden");
		cat2.setCategoryDescription("Das ist steuerlich noch viel günstiger als richtige Spenden, politisch aber voll inkorrekt.");
		productCategoryRepo.save(cat2);
		
		
		List<ProductCategory> productCategory1 = Arrays.asList(cat1);
		List<ProductCategory> productCategory2 = Arrays.asList(cat2);
		List<ProductCategory> productCategory3 = Arrays.asList(cat1, cat2);
		
		Product product1 = new Product();
		product1.setName("Greenpeace");
		product1.setDescription("Damit rettest du den Planeten und die Zukunft deiner Kinder!");
		product1.setProductCategories(productCategory1);
		product1.setPoints(20);
		productRepo.save(product1);
		
		Product product2 = new Product();
		product2.setName("Die Partei");
		product2.setDescription("Nein, wir sind nicht obsolet. Wir retten die Welt. Hilf uns dabei!");
		product2.setPoints(10);
		product2.setProductCategories(productCategory2);
		productRepo.save(product2);
		
		Product product3 = Product.builder().name("WWF").description("Save all these lions and icebears!").points(40).productCategories(productCategory1).build();
		productRepo.save(product3);
		
		Product product4 = Product
				.builder()
				.name("SOS Kinderdorf")
				.description("Help the orphans!")
				.points(30)
				.productCategories(productCategory3)
				.build();
		productRepo.save(product4);
		
		OrderItem orderItem1 = OrderItem
				.builder()
				.date(LocalDate.of(2020,02,02))
				.product(product1)
				.amount(3)
				.costInCoins(product1.getPoints() * 3) 
				.user(user3)
				.build();
		orderItemRepo.save(orderItem1);
		
		OrderItem orderItem2 = OrderItem
				.builder()
				.date(LocalDate.of(2020,05,27))
				.product(product2)
				.amount(8)
				.costInCoins(product2.getPoints() * 8)  
				.user(user1)
				.build();
		orderItemRepo.save(orderItem2);
		
		try {
			Image image1 = new Image();		
			image1.setImageFormat("image/jpeg");
			image1.setContent(DataLoader.class.getResourceAsStream("hummeln-blumenwiese.jpg").readAllBytes());
			image1.setReferenceId(product1.getId());			
			imageRepo.save(image1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
//		try {
//			Image image1 = new Image();		
//			image1.setImageFormat("image/png");
//			image1.setContent(DataLoader.class.getResourceAsStream("unhcr.png").readAllBytes());
//			image1.setReferenceId(product1.getId());			
//			imageRepo.save(image1);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		}




		
	}
}
