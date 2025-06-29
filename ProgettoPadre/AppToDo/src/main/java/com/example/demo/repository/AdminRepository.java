package com.example.demo.repository;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,String> {
    Optional<Admin> findByEmailAndPassword(String email, String password);

}
