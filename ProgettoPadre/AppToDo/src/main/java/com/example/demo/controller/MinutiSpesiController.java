package com.example.demo.controller;

import com.example.demo.entity.MinutiSpesi;
import com.example.demo.service.MinutiSpesiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/minutisesi") // Mappatura base per il controller
@CrossOrigin(origins = "http://localhost:4200") // Permette richieste da Angular
public class MinutiSpesiController {

    @Autowired
    private MinutiSpesiService minutiSpesiService;

    // Endpoint per registrare i minuti spesi
    // Utilizza @PathVariable per l'ID utente e @RequestBody per il payload JSON
    @PostMapping("/registra/{idUtente}")
    public ResponseEntity<MinutiSpesi> registraMinuti(
            @PathVariable Long idUtente,
            @RequestBody Map<String, Object> payload) {

        int minuti = (Integer) payload.get("minuti");
        LocalDate dataLogin = LocalDate.parse((String) payload.get("dataLogin"));

        MinutiSpesi sessioneSalvata = minutiSpesiService.registraMinutiSpesi(idUtente, minuti, dataLogin);

        return ResponseEntity.ok(sessioneSalvata);
    }
}