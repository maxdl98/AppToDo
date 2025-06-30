package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore; // Aggiungi questo import

@Entity
@Table(name = "minuti_spesi")
public class MinutiSpesi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int minuti;

    private LocalDate dataLogin;

    // Questa è la relazione "many-to-one"
    // '@JoinColumn' specifica la colonna nel database che sarà la chiave esterna
    @ManyToOne(fetch = FetchType.LAZY) // E' una relazione a molti a uno, e il fetch è lazy
    @JoinColumn(name = "id_utente", nullable = false) // Il nome della colonna nel DB
    @JsonIgnore // Evita loop infiniti di serializzazione JSON
    private Utente utente;

    public MinutiSpesi() {}

    public MinutiSpesi(int minuti, LocalDate dataLogin, Utente utente) {
        this.minuti = minuti;
        this.dataLogin = dataLogin;
        this.utente = utente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMinuti() {
        return minuti;
    }

    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }

    public LocalDate getDataLogin() {
        return dataLogin;
    }

    public void setDataLogin(LocalDate dataLogin) {
        this.dataLogin = dataLogin;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}