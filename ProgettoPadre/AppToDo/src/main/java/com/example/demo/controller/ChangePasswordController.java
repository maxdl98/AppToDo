package com.example.demo.controller;


import com.example.demo.entity.Admin;
import com.example.demo.entity.PasswordChange;
import com.example.demo.service.ChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:4200")
public class ChangePasswordController {



    @Autowired
    private final ChangePasswordService cservice;

    public ChangePasswordController(ChangePasswordService cservice){
        this.cservice = cservice;
    }


    @PostMapping("/changePassword")
    public ResponseEntity<Admin> changePassword(@RequestBody PasswordChange passwordChange) throws Exception {

        if(!passwordChange.vecchiaPassword.equals(passwordChange.nuovaPassword)){
            Optional<Admin> admin =    cservice.cambioPassword(passwordChange.vecchiaPassword,passwordChange.nuovaPassword );
            return new ResponseEntity<>(admin.get(), HttpStatus.OK);

        } else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }



}
