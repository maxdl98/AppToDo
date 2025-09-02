package com.example.demo.service;


import com.example.demo.entity.Domande;
import com.example.demo.enums.MaterieEnum;
import com.example.demo.repository.DomandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DomandeService {



    @Autowired
    private final DomandeRepository drepository;


    public DomandeService(DomandeRepository drepository){
        this.drepository = drepository;
    }


    public Iterable<Domande> findAll() {
        return drepository.findAll();
    }



    public Domande save(Domande domanda){
        return drepository.save(domanda);
    }


    public void deleteById(Long id)throws Exception{
        drepository.deleteById(id);
    }


    public Optional<Domande> findById(Long id){
        return drepository.findById(id);
    }


    public List<Domande> getRandomQuestion() throws Exception{


        List<Domande> domandeList = new ArrayList<>();

        drepository.findAll().forEach(domandeList::add);

        Collections.shuffle(domandeList);


        return domandeList.subList(0, Math.min(10, domandeList.size()));


/* il return sta dicendo, che se la lista contiene 10 o più domande, allora ne restituirà 10,
altrimenti restituirà tutti le domande della lista :D.


 */

    }










}
