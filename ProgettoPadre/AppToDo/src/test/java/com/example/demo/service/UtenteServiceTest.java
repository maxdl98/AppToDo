package com.example.demo.service;


import com.example.demo.dto.UtenteDto;
import com.example.demo.entity.Utente;
import com.example.demo.repository.UtenteJpaRepository;
import com.example.demo.repository.UtenteRepository;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UtenteServiceTest {


    @Mock
    private UtenteRepository utenteRepository;

    @Mock
    private UtenteJpaRepository utenteJpaRepository;


    @InjectMocks
    private UtentiService utenteService;


    @Test
    public void UtenteService_createUtente_ReturnUtenteDto(){

        Utente utente = Utente.builder()
                .nome("Gennaro")
                .email("gennaro12@gmail.com")
                .data(LocalDate.parse("2001-04-09"))
                .numero("39394908158")
                .password("Gennarone")
                .regione("Calabria")
                .dataRegistrazione(LocalDate.parse("2024-02-04")).build();


      when(utenteRepository.save(Mockito.any(Utente.class))).thenReturn(utente);

      Utente uti = utenteService.salvaUtente(utente);

      Assertions.assertThat(uti).isNotNull();









    }




    @Test
    public void UtenteService_findyByEmail_Return_Optional_Utente(){

        Utente utente = Utente.builder()
                .nome("Gennaro")
                .email("gennaro12@gmail.com")
                .data(LocalDate.parse("2001-04-09"))
                .numero("39394908158")
                .password("Gennarone")
                .regione("Calabria")
                .dataRegistrazione(LocalDate.parse("2024-02-04")).build();


        when(utenteRepository.findByEmail("gennaro12@gmail.com")).thenReturn(Optional.of(utente));



        Optional<Utente> result = utenteService.findByEmail("gennaro12@gmail.com");

        Assertions.assertThat(result).isPresent();
    }





    @Test
    public void findByEmail_returnOptionalUtente_whenEmailExist(){
        //Mock manuali
        UtenteRepository UtenteRepoMock = Mockito.mock(UtenteRepository.class);

        UtenteJpaRepository UtenteJpaRepoMock = Mockito.mock(UtenteJpaRepository.class);

        UtentiService utenteService1 = new UtentiService(UtenteRepoMock,UtenteJpaRepoMock);

        Utente utente = Utente.builder()
                .nome("Gennaro")
                .email("gennaro12@gmail.com")
                .data(LocalDate.parse("2001-04-09"))
                .numero("39394908158")
                .password("Gennarone")
                .regione("Calabria")
                .dataRegistrazione(LocalDate.parse("2024-02-04")).build();


        when(UtenteRepoMock.findByEmail("gennaro12@gmail.com")).thenReturn((Optional.of(utente)));

        Optional<Utente> result = utenteService1.findByEmail("gennaro12@gmail.com");

        Assertions.assertThat(result).isPresent();




    }



    @Test
    public void LoginUtente_returnOptionalUtente(){


        Utente utente = Utente.builder()
                .nome("Gennaro")
                .email("gennaro12@gmail.com")
                .data(LocalDate.parse("2001-04-09"))
                .numero("39394908158")
                .password("Gennarone")
                .regione("Calabria")
                .dataRegistrazione(LocalDate.parse("2024-02-04")).build();

        when(utenteRepository.findByEmailAndPassword(utente.getEmail(),utente.getPassword())).thenReturn(Optional.of(utente));


        Optional<Utente> result = utenteService.login(utente.getEmail(),utente.getPassword());


        Assertions.assertThat(result).isPresent();



    }


    @Test
    public void trovaUtente_returnOptionalUtente(){

        Utente utente = Utente.builder()
                .nome("Gennaro")
                .email("gennaro12@gmail.com")
                .data(LocalDate.parse("2001-04-09"))
                .numero("39394908158")
                .password("Gennarone")
                .regione("Calabria")
                .dataRegistrazione(LocalDate.parse("2024-02-04")).build();

        when(utenteRepository.findById(utente.getId())).thenReturn(Optional.of(utente));

        Optional<Utente> risultato = utenteService.trovaUtente(utente.getId());


        Assertions.assertThat(risultato).isPresent();







    }



    @Test
    public void deleteAll_test(){
        Utente utenteSalvato2 = Utente.builder()
                .nome("Gennaro")
                .email("gennaro12@gmail.com")
                .data(LocalDate.parse("2001-04-09"))
                .numero("39394908158")
                .password("Gennarone")
                .regione("Calabria")
                .dataRegistrazione(LocalDate.parse("2024-02-04")).build();

        Utente utenteSalvato3 = Utente.builder()
                .nome("Gennaro")
                .email("gennaro12@gmail.com")
                .data(LocalDate.parse("2001-04-09"))
                .numero("39394908158")
                .password("Gennarone")
                .regione("Calabria")
                .dataRegistrazione(LocalDate.parse("2024-02-04")).build();

        Utente utenteSalvato4 = Utente.builder()
                .nome("Gennaro")
                .email("gennaro12@gmail.com")
                .data(LocalDate.parse("2001-04-09"))
                .numero("39394908158")
                .password("Gennarone")
                .regione("Calabria")
                .dataRegistrazione(LocalDate.parse("2024-02-04")).build();

        when(utenteRepository.save(utenteSalvato2)).thenReturn(utenteSalvato2);
        when(utenteRepository.save(utenteSalvato3)).thenReturn(utenteSalvato3);
        when(utenteRepository.save(utenteSalvato4)).thenReturn(utenteSalvato4);



        Utente utenteSalvato = utenteService.salvaUtente(utenteSalvato2);
        Utente utenteSalvato22 = utenteService.salvaUtente(utenteSalvato3);
        Utente utenteSalvato33= utenteService.salvaUtente(utenteSalvato4);



        doAnswer(invocation -> {
            System.out.println("deleteAll() chiamato sul repository!");
            return null;
        }).when(utenteRepository).deleteAll();



        utenteService.deleteAll();



        Assertions.assertThat(utenteSalvato).isNotNull();
        Assertions.assertThat(utenteSalvato22).isNotNull();
        Assertions.assertThat(utenteSalvato33).isNotNull();


    }



    @Test
    public void findByNumero_returnOptionalUtente(){

        Utente utente12 = Utente.builder()
                .nome("Gennaro")
                .email("gennaro12@gmail.com")
                .data(LocalDate.parse("2001-04-09"))
                .numero("393924908158")
                .password("Gennarone")
                .regione("Calabria")
                .dataRegistrazione(LocalDate.parse("2024-02-04")).build();


        when(utenteRepository.findByNumero(utente12.getNumero())).thenReturn(Optional.of(utente12));



        Optional<Utente> utente = utenteService.findByNumero(utente12.getNumero());


        Assertions.assertThat(utente).isPresent();

    }


    @Test
    public void getClassificaTest_ReturnListUtenteDto() throws Exception {

        int topN = 10;


        Utente utente1 = Utente.builder()
                .nome("Gennaro")
                .email("gennaro12@gmail.com")
                .data(LocalDate.parse("2001-04-09"))
                .numero("393924908158")
                .password("Gennarone")
                .regione("Calabria")
                .dataRegistrazione(LocalDate.parse("2024-02-04")).build();


        Utente utente2 = Utente.builder()
                .nome("Gennaro")
                .email("gennaro12@gmail.com")
                .data(LocalDate.parse("2001-04-09"))
                .numero("393924908158")
                .password("Gennarone")
                .regione("Calabria")
                .dataRegistrazione(LocalDate.parse("2024-02-04")).build();


        Utente utente3 = Utente.builder()
                .nome("Gennaro")
                .email("gennaro12@gmail.com")
                .data(LocalDate.parse("2001-04-09"))
                .numero("393924908158")
                .password("Gennarone")
                .regione("Calabria")
                .dataRegistrazione(LocalDate.parse("2024-02-04")).build();


        Pageable pageable = PageRequest.of(0, topN);














    }






}
