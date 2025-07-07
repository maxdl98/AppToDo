package com.example.ProvaApp.service;

import com.example.ProvaApp.entity.Formatore;
import com.example.ProvaApp.repository.FormatoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormatoreService   {


    private final FormatoreRepository formatoreRepository;

    @Autowired
    public FormatoreService(FormatoreRepository formatoreRepository){
        this.formatoreRepository = formatoreRepository;
    }


    public Formatore salvaAll(Formatore formatore){
        return formatoreRepository.save(formatore);
    }
    
    public List<Formatore> getAll(){
        return formatoreRepository.findAll();
    }


    public Page<Formatore> getFormatore2(int page, int size){
        return formatoreRepository.findAll(PageRequest.of(page,size));
    }






}
