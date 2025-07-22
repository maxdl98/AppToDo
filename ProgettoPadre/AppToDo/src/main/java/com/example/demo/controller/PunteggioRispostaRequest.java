package com.example.demo.controller;

import com.example.demo.entity.Punteggio;
import com.example.demo.entity.Risposte;

public class PunteggioRispostaRequest {


    private boolean flag;

    private Punteggio punteggio;

    private Long id;

     public PunteggioRispostaRequest(){}
    public PunteggioRispostaRequest(boolean flag, Punteggio punteggio,  Long id) {
        this.flag = flag;
        this.punteggio = punteggio;
        this.id = id;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "PunteggioRispostaRequest{" +
                "flag=" + flag +
                ", punteggio=" + punteggio +
                ", id=" + id +
                '}';
    }
}
