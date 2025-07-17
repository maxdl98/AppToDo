package com.example.demo.service;


import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChangePasswordService {


    @Autowired
    private final AdminService adminService;

    public ChangePasswordService(AdminService adminService) {
        this.adminService = adminService;
    }



    public Optional <Admin> cambioPassword(String vecchiaPassword, String nuovaPassword){

        Optional<Admin> Admin = adminService.findByPassword(vecchiaPassword);


        if((Admin.isPresent())&&(nuovaPassword.length() >= 6)){
            Admin.get().setPassword(nuovaPassword);
        }

     return Admin;

    }






}
