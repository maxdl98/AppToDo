package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "risposte")
public class Risposte {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String risposta;


    private boolean flag;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_domande", nullable = false)
    private Domande domande;



    public Risposte(String risposta, Domande domande,boolean flag){
        this.risposta = risposta;
        this.domande = domande;
        this.flag = flag;
    }

    public Risposte(){}


    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getRisposta() {
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }


    public Domande getDomande() {
        return domande;
    }

    public void setDomande(Domande domande) {
        this.domande = domande;
    }

    @Override
    public String toString() {
        return "Risposte{" +
                "id=" + id +
                ", risposta='" + risposta + '\'' +
                '}';
    }
}
