package com.example.demo.repository;


import com.example.demo.entity.Domande;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DomandeRepository extends CrudRepository<Domande,Long> {


    Optional<Domande> findById(Long id);





}
