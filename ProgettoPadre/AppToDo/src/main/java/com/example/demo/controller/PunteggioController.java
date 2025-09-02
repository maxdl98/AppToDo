package com.example.demo.controller;

import com.example.demo.entity.Utente;
import com.example.demo.service.AdminService;
import com.example.demo.service.UtentiService;
import com.lowagie.text.Document;

import com.example.demo.dto.PunteggiDto;
import com.example.demo.entity.Punteggio;
import com.example.demo.entity.Risposte;
import com.example.demo.service.PunteggioService;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class PunteggioController {

    @Autowired
    private final PunteggioService pservice;

    @Autowired
    private final UtentiService uservice;

    @Autowired
    private final AdminController adcontroller;






    public PunteggioController(PunteggioService pservice, UtentiService uservice, AdminController adcontroller){
        this.pservice = pservice;
        this.uservice = uservice;
        this.adcontroller = adcontroller;
    }



    @GetMapping("/trovaUtente/{id}")
    public ResponseEntity<String>trovaUtente(@PathVariable Long id) throws Exception{
        boolean trovato = pservice.utenteHaGiaRisposto(id);

        if(trovato){
            return new ResponseEntity<>("l'utente con tale id è già presente nel db",  HttpStatus.BAD_REQUEST);
        } else{
            return ResponseEntity.ok("Utente non ha ancora risposto.");
        }



    }



    @PostMapping("/save2")
    public ResponseEntity<?> save(@RequestBody PunteggioRispostaRequest punteggioRispostaRequest) throws Exception {
        System.out.println("Richiesta ricevuta:");
        System.out.println("Utente ID: " + punteggioRispostaRequest.getPunteggio().getUtente().getId());
        System.out.println("Flag: " + punteggioRispostaRequest.getFlag());
        System.out.println("ID Domanda: " + punteggioRispostaRequest.getId_domanda());

         Punteggio punteggio = new Punteggio();


       Set<Long> utentiCheHannoRisposto = new HashSet<>();



        LocalDate oggi = LocalDate.now();


        LocalDate dataFineSettimanaSabato = oggi.with(DayOfWeek.SATURDAY);


            if (pservice.utenteHaGiaRisposto(punteggioRispostaRequest.getPunteggio().getUtente().getId())) {
                throw new IllegalStateException("Hai già completato il quiz. Non puoi rispondere di nuovo.");
            }


        punteggio =   pservice.save(punteggioRispostaRequest.getPunteggio(),punteggioRispostaRequest.getFlag(),punteggioRispostaRequest.getId_domanda());
        List<Utente> listaUtente = uservice.getAll();
        List<Punteggio> listaPunteggio = pservice.getAll();


            for(Utente u : listaUtente){
                boolean haRisposto = false;
                for(Punteggio p:listaPunteggio){
                    if(u.getId().equals(p.getUtente().getId())){
                        utentiCheHannoRisposto.add(p.getUtente().getId());

                    }

                }


            }

           int contatore1 = utentiCheHannoRisposto.size();






        if(contatore1 == listaUtente.size()){
           System.out.println(listaUtente.size());
            ResponseEntity<String> risposta = adcontroller.invioMail();
            System.out.println("Stato risposta email: " + risposta.getStatusCode());
            System.out.println("Messaggio: " + risposta.getBody());

            Thread.sleep(10000);

            pservice.deleteAll();


        }









        return new ResponseEntity<>(punteggio,HttpStatus.OK);


    }


    @GetMapping("/getAllPunteggi")
    public ResponseEntity<List<Punteggio>> getAllPunteggi() throws Exception{
        List<Punteggio> listaPunteggi = pservice.getAll();

        return new ResponseEntity<>(listaPunteggi,HttpStatus.OK);
    }


    @DeleteMapping("/deletePunteggi")
    public ResponseEntity<String> deleteAllPunteggi() {
        pservice.deleteAll();
        return ResponseEntity.ok("Punteggi eliminati con successo.");
    }





    @GetMapping("/classifica")
    public List<PunteggiDto> getClassifica(@RequestParam(defaultValue = "10") int topN) {
        return pservice.getClassificaDto(topN);
    }


    @GetMapping("/classificaPdf")
    public ResponseEntity<byte[]> exportPdf() throws Exception{
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Document document = new Document();

        PdfWriter.getInstance(document,out);

        document.open();

        document.add(new Paragraph("Classifica Punteggio"));

        List<PunteggiDto> listaPunteggiDto = pservice.getClassificaDto(5);




        PdfPTable table = new PdfPTable(2);

        table.addCell("Nome");
        table.addCell("Punteggio");


        for(PunteggiDto p : listaPunteggiDto){
            table.addCell(p.getNome());
            table.addCell(Integer.toString(p.getPunteggio()));
        }

        document.add(table);

        document.close();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment","classifica.pdf");


        return new ResponseEntity<>(out.toByteArray(), headers, HttpStatus.OK);






    }









}
