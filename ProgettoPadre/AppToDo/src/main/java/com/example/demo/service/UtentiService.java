package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Utente;
import com.example.demo.repository.UtenteRepository;
import java.util.List;  // Usa java.util.List

import java.util.Optional;


@Service
public class UtentiService {

    private final UtenteRepository utenteRepository;

    @Autowired
    public UtentiService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
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

    
   }
    
    
    
    

    

