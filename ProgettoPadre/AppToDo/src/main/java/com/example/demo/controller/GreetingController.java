package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/v1")
public class GreetingController {

    @Autowired
    private MessageSource messageSource;




    @GetMapping("/greet")
    public String greet(@RequestParam(defaultValue = "Utente") String nome, Locale locale){
        String greeting = messageSource.getMessage("greeting",null,locale);
        return greeting + ", " + nome + "!";

    }

}
