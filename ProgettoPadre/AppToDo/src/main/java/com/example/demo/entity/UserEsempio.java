package com.example.demo.entity;

public class UserEsempio {

    public String nome,cognome;
    public String id;


    public UserEsempio(String nome,String cognome, String id) {
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
