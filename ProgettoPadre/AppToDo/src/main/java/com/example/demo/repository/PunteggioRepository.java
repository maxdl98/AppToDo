package com.example.demo.repository;


import com.example.demo.entity.Punteggio;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PunteggioRepository extends JpaRepository<Punteggio,Long> {

    List<Punteggio> findAllByOrderByPunteggioDesc(Pageable pageable);


}
