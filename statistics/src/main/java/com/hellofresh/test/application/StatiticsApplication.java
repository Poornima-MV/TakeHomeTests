package com.hellofresh.test.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * @author Poornima Vadakeyil
 * Spring boot starter class
 */

@SpringBootApplication
@ComponentScan("com.hellofresh.test")
public class StatiticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatiticsApplication.class, args);
	}

	

}
