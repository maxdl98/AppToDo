package com.example.demo.dto;

import com.lowagie.text.pdf.PdfPCell;

public class PunteggiDto {

   public String nome;
   public int punteggio;
   public String email;

    public PunteggiDto() {
    }

    public PunteggiDto(String nome, int punteggio, String email) {
        this.nome = nome;
        this.punteggio = punteggio;
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }


    @Override
    public String toString() {
        return "PunteggiDto{" +
                "nome='" + nome + '\'' +
                ", punteggio=" + punteggio +
                '}';
    }
}
