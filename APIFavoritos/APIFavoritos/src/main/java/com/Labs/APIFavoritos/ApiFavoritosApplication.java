package com.Labs.APIFavoritos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = {"com.Labs.APIFavoritos.Domain.entities"})
@EnableJpaRepositories(basePackages = {"com.Labs.APIFavoritos.Domain.Repository"})
@ComponentScan(basePackages = {"com.Labs.APIFavoritos"})
@SpringBootApplication
public class ApiFavoritosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiFavoritosApplication.class, args);
	}

}
