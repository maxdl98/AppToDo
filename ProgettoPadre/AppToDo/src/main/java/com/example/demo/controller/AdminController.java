package com.example.demo.controller;

import com.example.demo.dto.PunteggiDto;
import com.example.demo.dto.UtenteDto;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Punteggio;
import com.example.demo.entity.Utente;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;
import com.example.demo.service.PunteggioService;
import com.example.demo.service.UtentiService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.*;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class AdminController {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private final AdminService aservice;

    @Autowired
    private final AdminRepository arepository;

    @Autowired
    private final UtentiService uservice;

    @Autowired
    private final PunteggioService pservice;


    public AdminController(AdminService aservice, AdminRepository arepository, PunteggioService pservice, UtentiService uservice){
        this.aservice = aservice;
        this.arepository = arepository;
        this.pservice = pservice;
        this.uservice = uservice;
    }


    @PostMapping("/admin")
    public ResponseEntity<Admin> salvaAdmin(@RequestBody Admin admin){


            System.out.println(admin);

            String hashedPassword = passwordEncoder.encode(admin.getPassword());
            admin.setPassword(hashedPassword);

            Admin admin1 = aservice.salvaAdmin(admin);

            return new ResponseEntity<>(admin1, HttpStatus.OK);




    }







    @GetMapping("password")
    public ResponseEntity<Optional<Admin>>findByPassword(@RequestParam String password) throws Exception{
        Optional<Admin> adminPassword = aservice.findByPassword(password);

        if(adminPassword.isPresent()){
            return new ResponseEntity<>(adminPassword, HttpStatus.OK);
        } else{
             throw new Error("c'è un errore");
        }

    }


    @PostMapping("/invioMailAutomatica")
    public ResponseEntity<String> invioMail() throws Exception{

        try{
            String email = "";
            List<PunteggiDto> informazioni = pservice.getClassificaDto(3);
            for(PunteggiDto p:informazioni){
                MimeMessage message = javaMailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");



                helper.setFrom("delucamassimo9880@gmail.com");

                helper.setSubject("C'è un premio per te che sarei arrivato tra i primi 3");
                email = p.getEmail();
                helper.setTo(p.getEmail());

                String risposta = "Hai vinto un fantastico premio, scegli tra:" +
                        "1) Apple Watch" +
                        "2): Smart Tv + " +
                        "3) Cuffie bluethoot";

                helper.setText(risposta,false);


                javaMailSender.send(message);


            }




        }catch(Exception e){
            e.printStackTrace();
        }


        return new ResponseEntity<String>("Email inviata con successo!", HttpStatus.OK);





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
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenziali errate");
        }
    }





}
