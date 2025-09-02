package com.example.demo.controller;


import com.example.demo.entity.Domande;
import com.example.demo.service.DomandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class DomandeController {


    @Autowired
    private final DomandeService dservice;


    public DomandeController(DomandeService dservice) {
        this.dservice = dservice;
    }



    @PostMapping("/salvoDomanda")
    public ResponseEntity<Domande> save(@RequestBody Domande domande){

        Domande dom = dservice.save(domande);


        return new ResponseEntity<>(dom, HttpStatus.OK);



    }


    @GetMapping("/trovaDomanda/{id}")
    public ResponseEntity<Domande> findById(@PathVariable Long id){


        Optional<Domande> domanda = dservice.findById(id);

        return new ResponseEntity<>(domanda.get(),HttpStatus.OK);
    }


    @DeleteMapping("/deleteDomanda/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception{
         dservice.deleteById(id);
        return new ResponseEntity<String>("La domanda con il seguenti id: " + id  + "è stata eliminata", HttpStatus.OK);
    }


    @GetMapping("/peppeDomande")
    public Iterable<Domande> findAll(){
        return dservice.findAll();
    }



    @GetMapping("/randomQuestion")
   public ResponseEntity<List<Domande>>  getDomandeRandom() throws Exception {
        List<Domande> domande = dservice.getRandomQuestion();

        return new ResponseEntity<>(domande, HttpStatus.OK);



    }















}
