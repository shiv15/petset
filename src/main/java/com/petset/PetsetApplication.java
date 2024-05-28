package com.petset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.petset.dao")
@ComponentScan("com.petset")
@EntityScan("com.petset.model")
public class PetsetApplication extends SpringBootServletInitializer {

	public static void main(String[] args)  {
		SpringApplication.run(PetsetApplication.class, args);
	}

}
