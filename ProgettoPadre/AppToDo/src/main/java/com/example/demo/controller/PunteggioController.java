package com.example.demo.controller;


import com.example.demo.entity.Punteggio;
import com.example.demo.entity.Risposte;
import com.example.demo.service.PunteggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class PunteggioController {

    @Autowired
    private final PunteggioService pservice;


    public PunteggioController(PunteggioService pservice){

        this.pservice = pservice;
    }

    @PostMapping("/save2")
    public ResponseEntity<?> save(@RequestBody PunteggioRispostaRequest punteggioRispostaRequest) {

            pservice.save(punteggioRispostaRequest.getPunteggio(), punteggioRispostaRequest.getFlag(), punteggioRispostaRequest.getId());



        return new ResponseEntity<>( punteggioRispostaRequest.getPunteggio(), HttpStatus.OK);
    }


    @GetMapping("/classifica")
    public List<Punteggio> getClassifica(@RequestParam(defaultValue = "10") int topN) {
        return pservice.getClassifica(topN);
    }






}
