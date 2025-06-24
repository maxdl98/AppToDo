package com.example.demo.entity;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "operatore")
public class Operatore {

    @Id
    private String id;

    private String nome;

    private String email;

    private String problematica;

    private String messaggio;


    public Operatore() {

    }


    public Operatore(String messaggio) {
     this.messaggio = messaggio;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
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


    public String getProblematica() {
        return problematica;
    }

    public void setProblematica(String problematica) {
        this.problematica = problematica;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public String toString() {
        return "Operatore{" +
                "messaggio='" + messaggio + '\'' +
                '}';
    }
}
