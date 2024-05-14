package com.sc.data.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.sc.data.validation") 
@EntityScan("com.sc.data.validation.entity")
@EnableJpaRepositories("com.sc.data.validation.repository")
public class DataValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataValidationApplication.class, args);
	}

}
