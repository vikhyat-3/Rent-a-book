package com.spring.RentABook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class RentABookApplication {

    // @Autowired
    // private static ApplicationContext applicationContext;
	public static void main(String[] args) {
		
		SpringApplication.run(RentABookApplication.class, args);
	}
	

}
