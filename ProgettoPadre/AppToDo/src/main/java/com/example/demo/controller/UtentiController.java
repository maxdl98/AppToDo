package com.example.demo.controller;

import com.example.demo.entity.Utente;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.service.SmsRequest;
import com.example.demo.service.SmsSent;
import com.example.demo.service.SmsService;
import com.example.demo.service.UtentiService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.apache.coyote.Response;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/utenti")
@CrossOrigin(origins = "http://localhost:4200") // Consente richieste cross-origin
public class UtentiController {

    private final UtentiService utenteService;
    private final UtenteRepository utenteRepository;

    @Autowired
    public UtentiController(UtentiService utenteService, UtenteRepository utenteRepository) {
        this.utenteService = utenteService;
        this.utenteRepository = utenteRepository;
    }
    
    
    @Autowired
	private JavaMailSender mailSender;
    
   @Autowired
   private SmsService service;

   @Autowired
   private BCryptPasswordEncoder passwordEncoder;











    @GetMapping("/num")
    public ResponseEntity<Map<String,String>> findByNumero(@RequestParam String numero){

        System.out.println("numero ricevuto: " + numero);


          Optional<Utente> ut = utenteRepository.findByNumero(numero);


          if(ut.isPresent()){
              Map<String,String> mappa1 = new HashMap<>();

              mappa1.put("numero: " , ut.get().getNumero());
              return new ResponseEntity<>(mappa1, HttpStatus.OK);

          } else{
              return new ResponseEntity<>( HttpStatus.BAD_REQUEST);

          }


    }








    @GetMapping("/Messaggio")
    public ResponseEntity<String> riceviSms(@RequestParam String numero) {


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("numero ricevuto_________: " + numero );

        Optional<Utente> UtenteNumero = utenteRepository.findByNumero(numero);

        System.out.println(numero);
        String mex ="";
        if(UtenteNumero.isPresent()){
            System.out.println("Invio SMS a: " + numero);
             mex = service.sendSMS(numero, "Ciao benvenuto in Ixplò :). Per qualsiasi necessità puoi rivolgerti a noi");

        } else{
            return new ResponseEntity<String>("c'è un errore", HttpStatus.BAD_REQUEST);
        }


        return ResponseEntity.ok(mex);
    }









	@DeleteMapping("/del")
	public ResponseEntity<String> deleteAll()throws Exception{
        utenteRepository.deleteAll();
        return new ResponseEntity<>(" gli utenti sono stati eliminati", HttpStatus.OK);
    }


    @GetMapping("/sendHtmlEmail")
    public ResponseEntity<Map<String, String>> sendHtmlEmail(@RequestParam String email) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setFrom("delucamassimo9880@gmail.com");
        helper.setSubject("La brochure del nostro corso");
        
        Optional<Utente> optEmail = utenteRepository.findByEmail(email);
        
        if(optEmail.isPresent()) {
            helper.setTo(email);

        }
        
        

        String htmlContent = """
           <html>
  <body style="font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 20px;">
  <h2 style="color: #004080;">Ecco i corsi disponibili a breve:</h2>
  <ul style="list-style-type: none; padding: 0;">
    <li style="background-color: #d9f0d9; margin-bottom: 10px; padding: 10px; border-radius: 5px; color: #006600;">
      <strong>Psicologia</strong><br>
      Disponibile dal <strong>3 Giugno 2025</strong>
    </li>
    <li style="background-color: #cce0ff; margin-bottom: 10px; padding: 10px; border-radius: 5px; color: #003366;">
      <strong>Sociologia</strong><br>
      Disponibile dal <strong>10 Giugno 2025</strong>
    </li>
    <li style="background-color: #d9f0d9; margin-bottom: 10px; padding: 10px; border-radius: 5px; color: #006600;">
      <strong>Filosofia</strong><br>
      Disponibile dal <strong>17 Giugno 2025</strong>
    </li>
    <li style="background-color: #cce0ff; margin-bottom: 10px; padding: 10px; border-radius: 5px; color: #003366;">
      <strong>Politica</strong><br>
      Disponibile dal <strong>24 Giugno 2025</strong>
    </li>
    <li style="background-color: #cce0ff; margin-bottom: 10px; padding: 10px; border-radius: 5px; color: #000000;">
      <strong>Informatica</strong><br>
      Disponibile dal <strong>1 Luglio 2025</strong>
    </li>
    <li style="background-color: #cce0ff; margin-bottom: 10px; padding: 10px; border-radius: 5px; color: #006614;">
      <strong>Geografia</strong><br>
      Disponibile dal <strong>8 Luglio 2025</strong>
    </li>
  </ul>


  <p style="color: #004080; margin-top: 20px;">
    Per maggiori informazioni puoi chiamare il numero: <strong>+39 123 456 7890</strong>
  </p>

  <img style="width: 200px; height: 200px;" src="https://ixplo.net/wp-content/uploads/2022/06/119190021_174921640788259_5477648727438480328_n.jpg">
</body>

      
  
</html>

            """;

        helper.setText(htmlContent, true);  // true indica che il testo è HTML

        mailSender.send(message);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Email inviata con successo a " + email);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

  

    // Endpoint per creare un nuovo utente
    //@Secured("ROLE_developer")
    @PostMapping("/uti")
    public ResponseEntity<Utente> creaUtente(@RequestBody Utente utente) {
        try {
            System.out.println(utente.getNumero());

            String hashedPassword = passwordEncoder.encode(utente.getPassword());
            utente.setPassword(hashedPassword);

            Utente nuovoUtente = utenteService.salvaUtente(utente);
            return new ResponseEntity<>(nuovoUtente, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    

    // Endpoint per ottenere tutti gli utenti
    @GetMapping("/getAll")
    public ResponseEntity<List<Utente>> getAllUtenti() {
        List<Utente> utenti = utenteService.getAllUtenti();
        if (utenti.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Se non ci sono utenti
        }
        return new ResponseEntity<>(utenti, HttpStatus.OK);
    }
    
    @GetMapping("/email")
    public ResponseEntity<Map<String, String>> findByEmail(@RequestParam String email) {
        Optional<Utente> emailOpt = utenteService.findByEmail(email);

        if (!emailOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Map<String, String> response = new HashMap<>();
        response.put("email", emailOpt.get().getEmail());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    // Endpoint per il login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");




        // Cerca l'utente nel database tramite email e password
        Optional<Utente> utenteOpt = utenteRepository.findByEmailAndPassword(email, password);

        if (utenteOpt.isPresent()) {
            Utente utente = utenteOpt.get();

            // Generazione del token JWT
            String token = Jwts.builder()
                    .setSubject(utente.getEmail())
                    .claim("nome", utente.getNome())
                    .claim("id", utente.getId())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 ora
                    .signWith(SignatureAlgorithm.HS256, "chiaveSuperSegreta123")
                    .compact();

            // Risposta con utente e token
            Map<String, Object> response = new HashMap<>();
            response.put("id", utente.getId());
            response.put("nome", utente.getNome());
            response.put("email", utente.getEmail());
            response.put("token", token);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenziali errate");
        }
    }
}
