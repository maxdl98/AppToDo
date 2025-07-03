package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Utente;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;



@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class AdminController {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    private final AdminService aservice;

    @Autowired
    private final AdminRepository arepository;


    public AdminController(AdminService aservice, AdminRepository arepository){
        this.aservice = aservice;
        this.arepository = arepository;
    }


    @PostMapping("/admin")
    public ResponseEntity<Admin> salvaAdmin(@RequestBody Admin admin){


            System.out.println(admin);

            String hashedPassword = passwordEncoder.encode(admin.getPassword());
            admin.setPassword(hashedPassword);

            Admin admin1 = aservice.salvaAdmin(admin);

            return new ResponseEntity<>(admin1, HttpStatus.OK);




    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        // Cerca l'utente nel database tramite email e password
        Optional<Admin> adminOpt = arepository.findByEmailAndPassword(email, password);

        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();

            // Generazione del token JWT
            String token = Jwts.builder()
                    .setSubject(admin.getEmail())
                    .claim("nome", admin.getNome())
                    .claim("id", admin.getId())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 ora
                    .signWith(SignatureAlgorithm.HS256, "chiaveSuperSegreta123")
                    .compact();

            // Risposta con utente e token
            Map<String, Object> response = new HashMap<>();
            response.put("id", admin.getId());
            response.put("nome", admin.getNome());
            response.put("email", admin.getEmail());
            response.put("token", token);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenziali errate");
        }
    }





}
