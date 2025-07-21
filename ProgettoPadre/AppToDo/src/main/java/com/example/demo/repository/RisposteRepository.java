package com.example.demo.repository;


import com.example.demo.entity.Risposte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RisposteRepository extends CrudRepository<Risposte,Long> {




}
