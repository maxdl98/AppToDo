package com.example.demo.service;


import com.example.demo.entity.Domande;
import com.example.demo.entity.Punteggio;
import com.example.demo.entity.Risposte;
import com.example.demo.entity.Utente;
import com.example.demo.repository.PunteggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PunteggioService {

    private final Map<Long, Integer> punteggiUtenti3 = new HashMap<>();
    private final Map<Long, Integer> contatoriUtente = new HashMap<>();

    @Autowired
    private final PunteggioRepository prepository;


    @Autowired
    private final UtentiService uservice;


    @Autowired
    private final DomandeService dservice;


    public PunteggioService(PunteggioRepository prepository, UtentiService uservice, DomandeService dservice) {
        this.prepository = prepository;
        this.uservice = uservice;
        this.dservice = dservice;
    }



    public Punteggio save(Punteggio punteggio, boolean flagUtente, Long idDomanda) {
        Long idUtente = punteggio.getUtente().getId();
        Optional<Utente> utenteOpt = uservice.findById(idUtente);
        Optional<Domande> domandaOpt = dservice.findById(idDomanda);

        if (utenteOpt.isPresent() && domandaOpt.isPresent()) {
            List<Risposte> risposte = domandaOpt.get().getListaRisposte();

            if (!risposte.isEmpty()) {
                int punteggioCorrente = punteggiUtenti3.getOrDefault(idUtente, 10);
                int domandeRisposte = contatoriUtente.getOrDefault(idUtente, 0);

                if (!flagUtente && punteggioCorrente > 0) {
                    punteggioCorrente--;
                }

                punteggiUtenti3.put(idUtente, punteggioCorrente);
                contatoriUtente.put(idUtente, domandeRisposte + 1);

                if (domandeRisposte + 1 == 10) {
                    punteggio.setPunteggio(punteggioCorrente);
                    punteggio.setUtente(utenteOpt.get());

                    punteggiUtenti3.remove(idUtente);
                    contatoriUtente.remove(idUtente);

                    return prepository.save(punteggio);
                } else {
                    punteggio.setPunteggio(punteggioCorrente);
                    return punteggio;
                }
            }
        }

        return punteggio;
    }





    public List<Punteggio> getClassifica(int topN) {
        Pageable pageable = PageRequest.of(0, topN);
        return prepository.findAllByOrderByPunteggioDesc(pageable);
    }

}


