package com.example.demo.service;


import com.example.demo.dto.UtenteDto;
import com.example.demo.repository.UtenteJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Utente;
import com.example.demo.repository.UtenteRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;  // Usa java.util.List

import java.util.Optional;


@Service
public class UtentiService {

    private final UtenteRepository utenteRepository;

    private final UtenteJpaRepository utenteJpaRepository;

    @Autowired
    public UtentiService(UtenteRepository utenteRepository, UtenteJpaRepository utenteJpaRepository) {
        this.utenteRepository = utenteRepository;
        this.utenteJpaRepository = utenteJpaRepository;
    }

    public Optional<Utente> trovaUtente(Long id) {
        return utenteRepository.findById(id);
    }

     public void deleteAll(){
       utenteRepository.deleteAll();
     }

    public Utente salvaUtente(Utente utente) {
        return utenteRepository.save(utente); 
    }
    
    public List<Utente> getAllUtenti() {
        return (List<Utente>) utenteRepository.findAll(); // Trova tutti gli utenti
    }
    
    public Optional<Utente> login(String email, String password) {
        return utenteRepository.findByEmailAndPassword(email, password);
    }
    
    public Optional<Utente> findByEmail(String email) {
    	return utenteRepository.findByEmail(email);  


    	
    }

    public Optional<Utente> findByNumero(String numero){
        return utenteRepository.findByNumero(numero);
    }

    public Optional<Utente> findById(Long id){
        return utenteRepository.findById(id);
    }



    public List<UtenteDto> getClassifica(int topN) throws Exception {

        Pageable pageable1 = PageRequest.of(0, topN);

        return utenteJpaRepository.findAllByOrderByDataRegistrazioneAsc(pageable1).stream()
                .map(d -> new UtenteDto(d.getNome(),d.getEmail(), d.getDataRegistrazione()))
                .toList();

    }


    public List<Utente> getAll() throws Exception{
        return utenteJpaRepository.findAll();
    }

   }
    
    
    
    

    

