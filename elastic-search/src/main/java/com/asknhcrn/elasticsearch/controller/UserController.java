package com.asknhcrn.elasticsearch.controller;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asknhcrn.elasticsearch.entity.Product;
import com.asknhcrn.elasticsearch.repository.ProductRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final ProductRepository userRepository;
	
    @PostConstruct // localde hızlıca test etmek için bir kullanıcı olusturdum ki asagıdaki methodla arama yapabileyim.
    public void init(){
        Product product =new Product();
        product.setName("iphone");
        product.setDescription("iphone 11 pro");
        product.setCreatedDate(Calendar.getInstance().getTime());
        product.setId("I0001");
        userRepository.save(product);
    }

	public UserController(ProductRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@GetMapping("/{searchText}")
	public ResponseEntity<List<Product>> getUser(@PathVariable String searchText){
		List<Product> user=userRepository.findByNameLikeOrDescriptionLike(searchText, searchText);
		return ResponseEntity.ok(user);
		
	}

}
