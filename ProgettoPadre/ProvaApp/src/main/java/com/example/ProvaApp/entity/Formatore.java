package com.example.ProvaApp.entity;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "formatore")
public class Formatore {

    @Id
    private String id ;

    private String nome;


    private String risposta;

    private String libriDisponibili;

   public Formatore(){}


    public Formatore(String nome) {
        this.nome = nome;
    }

    public Formatore(String nome,String risposta,String libriDisponibili){
        this.nome = nome;
        this.risposta = risposta;
        this.libriDisponibili = libriDisponibili;
;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getRisposta() {
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }


    public String getLibriDisponibili() {
        return libriDisponibili;
    }

    public void setLibriDisponibili(String libriDisponibili) {
        this.libriDisponibili = libriDisponibili;
    }

    @Override
    public String toString() {
        return "Formatore{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", risposta='" + risposta + '\'' +
                ", libriDisponibili='" + libriDisponibili + '\'' +
                '}';
    }
}
