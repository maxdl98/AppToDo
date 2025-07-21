package com.example.demo.controller;

import com.example.demo.entity.Domande;

public class RispostaDTO {


    private String riposta;
    private Long idDomanda;


    public RispostaDTO(String riposta,Long idDomanda) {
        this.riposta = riposta;
        this.idDomanda = idDomanda;
    }

    public String getRiposta() {
        return riposta;
    }

    public void setRiposta(String riposta) {
        this.riposta = riposta;
    }


    public Long getIdDomanda() {
        return idDomanda;
    }

    public void setIdDomanda(Long idDomanda) {
        this.idDomanda = idDomanda;
    }


    @Override
    public String toString() {
        return "RispostaDTO{" +
                "riposta='" + riposta + '\'' +
                ", idDomanda=" + idDomanda +
                '}';
    }
}
