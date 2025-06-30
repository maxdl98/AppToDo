package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    private LocalDate data; // può essere anche "dataNascita" se preferisci

    private String numero;

    private String password;

    private String regione;

    private LocalDate dataRegistrazione;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MinutiSpesi> sessioniMinuti;

    // Costruttori
    public Utente() {}

    public Utente(String nome, String email, LocalDate dataRegistrazione,String numero, String password,String regione) {
        this.nome = nome;
        this.email = email;
        this.numero = numero;
        this.regione = regione;
        this.password = password;
        this.dataRegistrazione = dataRegistrazione;
    }

    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero ="+"+numero;
    }

    public void setRegione(String regione){
        this.regione = regione;
    }


    public String getRegione(){
        return regione;
    }


    public LocalDate getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(LocalDate dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }
}
