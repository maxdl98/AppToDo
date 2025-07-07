package com.example.ProvaApp.controller;


import com.example.ProvaApp.entity.Formatore;
import com.example.ProvaApp.service.FormatoreService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/formatore")
@CrossOrigin("http://localhost:4200")
public class FormatoreController {

    private final FormatoreService service;

    int cont = 0;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    public FormatoreController(FormatoreService service) {
        this.service = service;
    }


    @PostMapping("/save")
    public Formatore saveAll(@RequestBody Formatore formatore){

         return service.salvaAll(formatore);


    }


    @PostMapping("/invioMail")
    public ResponseEntity<Map<String,String>> invioMail
            (@RequestParam
             String email,
             @RequestBody Formatore formatore
              ) throws Exception {


        //salvo il formatore nel database in base ai dati che mi invia (nome,risposta,libriDisponibili)
         service.salvaAll(formatore);

         //creo un messaggio
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true,"UTF-8");

        //setto l'account dalla quale proverrà la mail
        helper.setFrom("delucamassimo9880@gmail.com");
        helper.setSubject("Risposta al ticket, ecco il libro consigliato: " + " " +  formatore.getLibriDisponibili());

        //l'email a cui verrà spedita la mail
        helper.setTo(email);


        //la mail sarebbe la risposta del formatore + i libri consigliati
        String rispostaFormatore = formatore.getRisposta();


        //setti il testo
        helper.setText(rispostaFormatore,false);


        ClassPathResource file = new ClassPathResource("static/privacy.pdf");
        helper.addAttachment("privacy.pdf", file);




        if(true){
            mailSender.send(message);
            cont++;

        }


        Map<String,String> response = new HashMap<String,String>();

        response.put("messagge" , "Email inviata con successo a: " + email);

         System.out.println(cont);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /*
    @GetMapping
    public ResponseEntity<List<Formatore>> getAll(){
        return new ResponseEntity<List<Formatore>>(service.getAll(), HttpStatus.OK);
    }
    */

    @GetMapping("/getFormatori")
    public ResponseEntity<List<Formatore>>getAll(){

       List<Formatore> listaFormatori = new ArrayList<Formatore>();
           listaFormatori =  service.getAll();

        return new ResponseEntity<>(listaFormatori, HttpStatus.OK);



    }



    @GetMapping("/getFormatori2")
    public Page<Formatore> getAllFormatori(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5")int size){
        return service.getFormatore2(page,size);
    }






}
