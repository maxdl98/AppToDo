package com.example.ProvaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EntityScan(basePackages = {"com.example.ProvaApp", "formatore"})
@EnableMongoRepositories(basePackages = "com.example.ProvaApp.repository")
@SpringBootApplication
public class ProvaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvaAppApplication.class, args);
	}

}
