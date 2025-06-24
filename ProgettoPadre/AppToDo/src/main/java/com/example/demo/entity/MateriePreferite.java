package com.example.demo.entity;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


public class MateriePreferite {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nomeMateria;

    @Column(nullable = true)
    private String descrizione;

    @Column(name = "data_creazione", nullable = false) // Mappa al nome della colonna nel DB
    private LocalDateTime dataCreazione;

    public MateriePreferite(Long id, String nomeMateria, String descrizione,LocalDateTime dataCreazione) {
        this.id = id;
        this.nomeMateria = nomeMateria;
        this.descrizione = descrizione;
        this.dataCreazione = dataCreazione;
    }





    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(LocalDateTime dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }


    @Override
    public String toString() {
        return "MateriePreferite{" +
                "id=" + id +
                ", nomeMateria='" + nomeMateria + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", dataCreazione=" + dataCreazione +
                '}';
    }
}
