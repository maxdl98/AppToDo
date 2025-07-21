package com.example.demo.service;


import com.example.demo.entity.Domande;
import com.example.demo.enums.MaterieEnum;
import com.example.demo.repository.DomandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomandeService {



    @Autowired
    private final DomandeRepository drepository;


    public DomandeService(DomandeRepository drepository){
        this.drepository = drepository;
    }


   public Domande findAll(){
        return (Domande) drepository.findAll();
   }

    public Domande save(Domande domanda){
        return drepository.save(domanda);
    }


    public Optional<Domande> findById(Long id){
        return drepository.findById(id);
    }





}
