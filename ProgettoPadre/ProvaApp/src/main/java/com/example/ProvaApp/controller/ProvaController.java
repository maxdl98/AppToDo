package com.example.ProvaApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ProvaController {


    @GetMapping("/miagolare")
    public String miagolare(){
        
        return "miaooooo";
    }


}
