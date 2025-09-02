package com.example.demo.repository;

import com.example.demo.dto.UtenteDto;
import com.example.demo.entity.Utente;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface UtenteJpaRepository extends JpaRepository<Utente, Long> {


    Page<Utente> findAllByOrderByDataRegistrazioneAsc(Pageable pageable);

    public List<Utente> findAll();




}
