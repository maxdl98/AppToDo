package com.example.demo.entity;

import com.example.demo.entity.MinutiSpesi;
import com.example.demo.entity.Punteggio;
import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    private String email;

    @Getter
    @Setter
    private LocalDate data; // data di nascita o simile

    @Getter
    @Setter
    private String numero;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String regione;

    @Setter
    @Getter
    private LocalDate dataRegistrazione;


    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MinutiSpesi> sessioniMinuti;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Punteggio> listaPunteggi;
}
