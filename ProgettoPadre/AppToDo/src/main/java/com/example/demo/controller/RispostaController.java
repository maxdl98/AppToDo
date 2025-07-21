package com.example.demo.controller;


import com.example.demo.entity.Domande;
import com.example.demo.entity.Risposte;
import com.example.demo.service.DomandeService;
import com.example.demo.service.RisposteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class RispostaController {


    @Autowired
    private final RisposteService rservice;

    @Autowired
    private final DomandeService dservice;


    public RispostaController(RisposteService rservice,DomandeService dservice) {
        this.rservice = rservice;
        this.dservice = dservice;
    }


    @PostMapping("/salvoRisposta")
    public ResponseEntity<Risposte> salva(@RequestBody Risposte risposte, Domande domanda){

        try {
            Risposte rispostaSalvata = rservice.save(risposte);
            return new ResponseEntity<>(rispostaSalvata, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }


    }




}
