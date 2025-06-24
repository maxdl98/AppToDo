package com.example.demo.repository;

public class DatiDto {


    private String email;
    private String problematica;
    private String contenuto;

    public String getEmail() {
        return email;
    }

    public DatiDto(String email,String problematica,String contenuto) {
        this.email = email;
        this.problematica = problematica;
        this.contenuto = contenuto;

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


    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }
}
