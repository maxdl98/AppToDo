package com.example.demo.controller;

import com.example.demo.entity.Punteggio;
import com.example.demo.entity.Risposte;

public class PunteggioRispostaRequest {


    private boolean flag;

    private Punteggio punteggio;

    private Long id_domanda;



     public PunteggioRispostaRequest(){}
    public PunteggioRispostaRequest(Punteggio punteggio,boolean flag,  Long id_domanda) {
        this.flag = flag;
        this.punteggio = punteggio;
        this.id_domanda = id_domanda;
    }

    public PunteggioRispostaRequest(Long id_domanda, boolean flag) {
        this.id_domanda = id_domanda;
        this.flag = flag;
    }

    public Punteggio getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(Punteggio punteggio) {
        this.punteggio = punteggio;
    }


    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag= flag;
    }


    public Long getId_domanda() {
        return id_domanda;
    }

    public void setId_domanda(Long id) {
        this.id_domanda = id;
    }


    @Override
    public String toString() {
        return "PunteggioRispostaRequest{" +
                "flag=" + flag +
                ", punteggio=" + punteggio +
                ", id_domanda=" + id_domanda +
                '}';
    }
}
