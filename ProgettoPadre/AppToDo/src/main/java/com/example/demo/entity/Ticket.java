package com.example.demo.entity;

import jakarta.persistence.Id;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tickets")
public class Ticket {


    @Id
    private String id;

    private String email;

    private String problematica;

    private String contenuto;

    private Boolean resolved;

    private Binary file;


    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = false;



    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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


    public Binary getFile() {
        return file;
    }

    public void setFile(Binary file) {
        this.file = file;
    }




}
