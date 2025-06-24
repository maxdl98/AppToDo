package com.example.demo.controller;

import com.example.demo.entity.UserEsempio;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.oauth2.jwt.Jwt; // ✅
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UtentiProva {

    @PreAuthorize("#id==#jwt.subject")
    @DeleteMapping(path="/{id}")
    public String deleteUser(@PathVariable String id, @AuthenticationPrincipal  Jwt jwt){
        return "Delete user with id: " + id + " and Jwt subject " + jwt.getSubject();
    }

    @PostAuthorize("returnObject.id == #jwt.subject")
    @GetMapping(path="/{id}")
    public UserEsempio getUser(@PathVariable String id, @AuthenticationPrincipal  Jwt jwt){
        return new UserEsempio("Massimo","De Luca", "1d0ff8e1-44eb-4596-9628-378375fe60c5");
    }

    @GetMapping("/saluto")
    public String saluto(){
        return "ciao";
    }

}
