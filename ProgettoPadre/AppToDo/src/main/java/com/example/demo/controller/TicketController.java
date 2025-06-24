package com.example.demo.controller;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.example.demo.entity.Operatore;
import com.example.demo.entity.Ticket;
import com.example.demo.repository.DatiDto;
import com.example.demo.repository.DatiTickets;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {

    private final TicketService ticketService;
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketController(TicketService ticketService, TicketRepository ticketRepository) {
        this.ticketService = ticketService;
        this.ticketRepository = ticketRepository;

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        try{
            List<Ticket> listaTickets = new ArrayList<>();

          listaTickets =  ticketService.findAll();

          return new  ResponseEntity<>(listaTickets,HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
          return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/submit")
    public ResponseEntity<Map<String,String>> submitTicket(@RequestParam String email, @RequestParam String problematica, @RequestParam String contenuto, @RequestPart(value = "file" , required = false) MultipartFile file) {
        Map<String, String> mappa2 = null;
        try {

            Map<String, String> mappa1 = new HashMap<>();

            mappa2 = new HashMap<>();

            Ticket ticket = new Ticket();
            ticket.setProblematica(problematica);
            ticket.setContenuto(contenuto);
            ticket.setEmail(email);
            ticket.setResolved(false);

            System.out.println(problematica);

            if (file != null && !file.isEmpty()) {
                byte[] fileBytes = file.getBytes();
                Binary binaryFile = new Binary(fileBytes);
                ticket.setFile(binaryFile);

            }


            System.out.println(ticket);

            Operatore operatore = new Operatore();


            switch (problematica) {
                case "Tasse": {
                    operatore.setMessaggio("Per gli studenti portatori di handicap, le tasse sono dimezzate. Questo è un messaggio automatico." +
                            "Un'operatore al più presto si mettera in contatto con lei ");
                    break;

                }

                case "Immatricolazione": {
                    operatore.setMessaggio("Stiamo in ferie, dovrai passare un'altra volta");

                    break;
                }
                case "Iscrizione agli anni successivi", "Studente impegnato a tempo parziale": {
                    operatore.setMessaggio("un'operatore la contatterà quanto prima");

                    break;
                }
                default:
                    operatore.setMessaggio("non ci occupiamo di questi casi, mi dispiace ");
                    System.out.println("un'operatore la contatterà");
            }


            ticketService.salvaTicket(ticket);
            mappa1.put("ecco la risposta dell'operatore: ", operatore.getMessaggio());

            mappa2.put("ci sono errori", operatore.getMessaggio());
            return new ResponseEntity<Map<String, String>>(mappa1, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();

            return new ResponseEntity<Map<String, String>>(mappa2, HttpStatus.BAD_REQUEST);

        }

    }


    @GetMapping("/getAllEmail")
    public List<DatiDto> getAllEmails() {
        return ticketRepository.findAllEmails()
                .stream()
                .map(e -> new DatiDto(e.getEmail(), e.getProblematica(), e.getContenuto()))
                .collect(Collectors.toList());
    }



    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) throws Exception{
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=segnalazioni.xlsx");


        List<DatiTickets> dati = ticketRepository.findAllEmails();

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("segnalazioni");

        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("Email");
        header.createCell(1).setCellValue("Problematica");
        header.createCell(2).setCellValue("Contenuto");

        int rowIdx = 1;

        for(DatiTickets d: dati){
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(d.getEmail());
            row.createCell(1).setCellValue(d.getProblematica());
            row.createCell(2).setCellValue(d.getContenuto());
        }


        workbook.write(response.getOutputStream());
        workbook.close();







    }











    @GetMapping("/exportPdf")
    public ResponseEntity<byte[]> exportPdf() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        // Esempio di intestazione
        document.add(new Paragraph("Lista Tickets"));

        // Dati fittizi o da database
        List<DatiTickets> tickets = ticketRepository.findAllEmails(); // esempio

        PdfPTable table = new PdfPTable(3); // 3 colonne
        table.addCell("Email");
        table.addCell("Problematica");
        table.addCell("Contenuto");


        for (DatiTickets t : tickets) {
            table.addCell(t.getEmail());
            table.addCell(t.getProblematica());
            table.addCell(t.getContenuto());
         }

        document.add(table);
        document.close();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "tickets.pdf");

        return new ResponseEntity<>(out.toByteArray(), headers, HttpStatus.OK);
    }












}
