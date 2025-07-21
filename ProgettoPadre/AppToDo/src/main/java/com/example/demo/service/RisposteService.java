package com.example.demo.service;


import com.example.demo.entity.Domande;
import com.example.demo.entity.Risposte;
import com.example.demo.repository.RisposteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RisposteService {

    @Autowired
    private final RisposteRepository Rrepository;

    @Autowired
    private final DomandeService dservice;


    public RisposteService(RisposteRepository Rrepository, DomandeService dservice) {
        this.Rrepository = Rrepository;
        this.dservice = dservice;
    }


    public Risposte save(Risposte risposta) {


        Domande domanda = risposta.getDomande();
        Optional<Domande> trovoDomanda = dservice.findById(domanda.getId());


        if (domanda == null || domanda.getId() == null) {
            throw new IllegalArgumentException("Domanda o ID domanda è null");
        }


        if (trovoDomanda.isEmpty()) {
            throw new IllegalArgumentException("Domanda non trovata con ID: " + domanda.getId());
        }

        // Assicura che l'entità Domande sia gestita da JPA
        risposta.setDomande(trovoDomanda.get());

        return Rrepository.save(risposta);


    }
}
