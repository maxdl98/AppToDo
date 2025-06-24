package com.example.demo.service;


import com.example.demo.entity.Admin;
import com.example.demo.entity.Utente;
import com.example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private final AdminRepository arepository;


    public AdminService(AdminRepository arepository){
        this.arepository = arepository;
    }

    public Admin salvaAdmin(Admin admin){
        return arepository.save(admin);
    }
    public Optional<Admin> login(String email, String password) {
        return arepository.findByEmailAndPassword(email, password);
    }


}
