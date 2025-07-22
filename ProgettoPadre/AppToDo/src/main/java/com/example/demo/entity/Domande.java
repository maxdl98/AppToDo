package com.example.demo.entity;


import com.example.demo.enums.MaterieEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "domande")
public class Domande {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String testoDomanda;

    private String materia;


    @OneToMany(mappedBy = "domande", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Risposte> listaRisposte;



    public Domande(){}

    public Domande(Long id, String testoDomanda, String materia, List<Risposte> listaRisposte){
        this.testoDomanda = testoDomanda;
        this.materia = materia;
        this.listaRisposte = listaRisposte;
    }

    public Domande(Long id) {
        this.id = id;
    }

    public String getTestoDomanda() {
        return testoDomanda;
    }

    public void setTestoDomanda(String testoDomanda) {
        this.testoDomanda = testoDomanda;
    }


    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Risposte> getListaRisposte() {
        return listaRisposte;
    }

    public void setListaRisposte(List<Risposte> listaRisposte) {
        this.listaRisposte = listaRisposte;
    }


    @Override
    public String toString() {
        return "Domande{" +
                "id=" + id +
                ", testoDomanda='" + testoDomanda + '\'' +
                ", materia='" + materia + '\'' +
                ", listaRisposte=" + listaRisposte +
                '}';
    }
}
