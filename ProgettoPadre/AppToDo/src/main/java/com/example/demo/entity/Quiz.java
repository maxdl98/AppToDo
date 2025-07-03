package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String risposta1;
    private String risposta2;
    private String risposta3;
    private String risposta4;
    private String risposta5;


    public Quiz(String risposta1,String risposta2,String risposta3, String risposta4, String risposta5) {
        this.risposta1 = risposta1;
        this.risposta2 = risposta2;
        this.risposta3 = risposta3;
        this.risposta4 = risposta4;
        this.risposta5 = risposta5;
    }

    public String getRisposta1() {
        return risposta1;
    }

    public void setRisposta1(String risposta1) {
        this.risposta1 = risposta1;
    }


    public String getRisposta2() {
        return risposta2;
    }

    public void setRisposta2(String risposta2) {
        this.risposta2 = risposta2;
    }


    public String getRisposta3() {
        return risposta3;
    }

    public void setRisposta3(String risposta3) {
        this.risposta3 = risposta3;
    }


    public String getRisposta4() {
        return risposta4;
    }

    public void setRisposta4(String risposta4) {
        this.risposta4 = risposta4;
    }


    public String getRisposta5() {
        return risposta5;
    }

    public void setRisposta5(String risposta5) {
        this.risposta5 = risposta5;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "risposta1='" + risposta1 + '\'' +
                ", risposta2='" + risposta2 + '\'' +
                ", risposta3='" + risposta3 + '\'' +
                ", risposta4='" + risposta4 + '\'' +
                ", risposta5='" + risposta5 + '\'' +
                '}';
    }
}
