package com.example.demo.repository;


import com.example.demo.entity.Punteggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PunteggioRepository extends JpaRepository<Punteggio,Long> {


}
