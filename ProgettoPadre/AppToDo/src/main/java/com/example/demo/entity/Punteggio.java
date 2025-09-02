package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "punteggio")
public class Punteggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int punteggio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utente", nullable = false)
    @JsonBackReference
    private Utente utente;




    public Punteggio(){}

    public Punteggio(Long id , int punteggio, Utente utente){
        this.id = id;
        this.punteggio = punteggio;
        this.utente = utente;

    }




    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }


    @Override
    public String toString() {
        return "Punteggio{" +
                "id=" + id +
                ", punteggio=" + punteggio +
                ", utente=" + utente +
                '}';
    }
}
