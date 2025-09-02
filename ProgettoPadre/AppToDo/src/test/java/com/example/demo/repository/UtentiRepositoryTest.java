package com.example.demo.repository;

import com.example.demo.entity.Utente;
import org.assertj.core.api.Assertions;
import org.hibernate.validator.constraints.CodePointLength;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.mysql.cj.conf.PropertyKey.logger;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase
public class UtentiRepositoryTest {

    @Autowired
    private UtenteRepository utenteRepository;


    @Test
    public void Utente_Repository_Save_Utente(){
        Utente utente = Utente.builder()
                .nome("Giuseppe")
                .email("GiuseppeConza@gmail.com")
                .data(LocalDate.parse("2004-02-01"))
                .numero("39394908158")
                .password("Giuseppino!")
                .regione("Campania")
                .dataRegistrazione(LocalDate.parse("2024-10-10")).build();



       Utente savedUtente = utenteRepository.save(utente);



       //Assert
        Assertions.assertThat(savedUtente).isNotNull();
        Assertions.assertThat(savedUtente.getNumero().contains("49")).isTrue();

    }



    @Test
    public void getAll_Utenti(){
        Utente utente = Utente.builder()
                .nome("Giuseppe")
                .email("GiuseppeConza@gmail.com")
                .data(LocalDate.parse("2004-02-01"))
                .numero("39394908158")
                .password("Giuseppino!")
                .regione("Campania")
                .dataRegistrazione(LocalDate.parse("2024-10-10")).build();

        Utente utente2 = Utente.builder()
                .nome("Gennaro")
                .email("gennaro12@gmail.com")
                .data(LocalDate.parse("2001-04-09"))
                .numero("39394908158")
                .password("Gennarone")
                .regione("Calabria")
                .dataRegistrazione(LocalDate.parse("2024-02-04")).build();


        utenteRepository.save(utente);
        utenteRepository.save(utente2);


       List<Utente> listaUtenti = (List<Utente>) utenteRepository.findAll();

        Assertions.assertThat(listaUtenti).isNotNull();

        Assertions.assertThat(listaUtenti.size()).isEqualTo(2);


    }


    @Test
    public void findById_TestUtente(){
        Utente utente = Utente.builder()
                .nome("Gennaro")
                .email("gennaro12@gmail.com")
                .data(LocalDate.parse("2001-04-09"))
                .numero("39394908158")
                .password("Gennarone")
                .regione("Calabria")
                .dataRegistrazione(LocalDate.parse("2024-02-04")).build();

        Utente ut = utenteRepository.save(utente);

      Utente utentino = utenteRepository.findById(ut.getId()).get();



      Assertions.assertThat(utentino).isNotNull();
    }







}
