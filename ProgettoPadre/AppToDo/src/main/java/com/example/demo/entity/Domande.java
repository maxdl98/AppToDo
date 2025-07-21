package com.example.demo.entity;


import com.example.demo.enums.MaterieEnum;
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

    @Enumerated(EnumType.STRING) // o EnumType.ORDINAL
    private MaterieEnum materia;


    @OneToMany(mappedBy = "domande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Risposte> listaRisposte;



    public Domande(){}

    public Domande(Long id, String testoDomanda, MaterieEnum materia, List<Risposte> listaRisposte){
        this.testoDomanda = testoDomanda;
        this.materia = materia;
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


    public MaterieEnum getMateria() {
        return materia;
    }

    public void setMateria(MaterieEnum materia) {
        this.materia = materia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Domande{" +
                "id=" + id +
                ", testoDomanda='" + testoDomanda + '\'' +
                ", materia='" + materia + '\'' +
                '}';
    }
}
