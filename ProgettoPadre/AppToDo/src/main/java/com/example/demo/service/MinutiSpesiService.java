package com.example.demo.service;

import com.example.demo.entity.MinutiSpesi;
import com.example.demo.entity.Utente;
import com.example.demo.repository.MinutiSpesiRepository;
import com.example.demo.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class MinutiSpesiService {

    @Autowired
    public UtenteRepository utenteRepository;

    @Autowired
    public MinutiSpesiRepository minutiSpesiRepository;


    public MinutiSpesi registraMinutiSpesi(Long utenteId, int minuti, LocalDate dataLogin){
        Optional<Utente> ut = utenteRepository.findById(utenteId);
        MinutiSpesi nuovaSessione = new MinutiSpesi();

        if(ut.isPresent()){
            nuovaSessione.setMinuti(minuti);
            nuovaSessione.setDataLogin(dataLogin);
            nuovaSessione.setUtente(ut.get());
        }

        return minutiSpesiRepository.save(nuovaSessione);

    }


}
