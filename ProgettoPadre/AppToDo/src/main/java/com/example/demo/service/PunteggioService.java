package com.example.demo.service;


import com.example.demo.entity.Domande;
import com.example.demo.entity.Punteggio;
import com.example.demo.entity.Risposte;
import com.example.demo.entity.Utente;
import com.example.demo.repository.PunteggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PunteggioService {


    @Autowired
    private final PunteggioRepository prepository;


    @Autowired
    private final UtentiService uservice;


    @Autowired
    private final DomandeService dservice;

    int punteggioIniziale = 10;


    public PunteggioService(PunteggioRepository prepository, UtentiService uservice, DomandeService dservice){
        this.prepository = prepository;
        this.uservice = uservice;
        this.dservice = dservice;
    }


    public Punteggio save(Punteggio punteggio, boolean flagUtente, Long id2){


        Long id = punteggio.getUtente().getId();

        Optional<Utente> ut = uservice.findById(id);



        if(ut.isPresent()){

            Iterable<Domande> domande = dservice.findAll();

            domande.forEach(element ->{
               List<Risposte> listaRisposte = element.getListaRisposte();


               if(element.getId().equals(id2)){
                   if(!listaRisposte.isEmpty()){


                           if(flagUtente){
                               punteggio.setPunteggio(this.punteggioIniziale);
                           }

                           else{
                               punteggio.setPunteggio(this.punteggioIniziale--);
                           }
                       }
                   }




            });



            Punteggio p = prepository.save(punteggio);



        }

        return punteggio;
    }







}
