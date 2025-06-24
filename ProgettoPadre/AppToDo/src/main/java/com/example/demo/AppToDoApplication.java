package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.demo.controller.UtentiController;

@EntityScan(basePackages = {"com.example.demo", "utente"})
@SpringBootApplication
public class AppToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppToDoApplication.class, args);
	}
	

	
	
	

}
