package com.example.demo.repository;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SicurezzaConfig {


   @Bean
    public BCryptPasswordEncoder passowordEncoder(){
       return new BCryptPasswordEncoder();
   }


}
