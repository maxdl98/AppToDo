package com.example.demo.controller;

import com.example.demo.entity.Quiz;
import com.example.demo.repository.QuizRepository;
import com.example.demo.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {


    private final QuizService quizService;

    private final QuizRepository quizRepository;

    public QuizController(QuizService quizService, QuizRepository quizRepository) {
        this.quizService = quizService;
        this.quizRepository = quizRepository;
    }


    @PostMapping("/quiz")
    public ResponseEntity<Quiz> salvaQuiz(@RequestBody Quiz quiz) throws Exception {
        int punteggio = 10;

        String rispostaGiusta1 = "1989";
        String rispostaGiusta2 = "La teoria cognitiva";
        String rispostaGiusta3 = "C. Wright Mills";
        String rispostaGiusta4 = "Monti Urali";
        String rispostaGiusta5 = "Impressionismo";
        String rispostaGiusta6 = "HyperText Transfer Protocol";

        List<Quiz> listaQuiz = new ArrayList<Quiz>();



            if(quiz.getRisposta1().trim().equalsIgnoreCase(rispostaGiusta1)){
                quiz.setRisposta1(rispostaGiusta1);
            } else{
                punteggio--;
            }

            if(quiz.getRisposta2().trim().equalsIgnoreCase(rispostaGiusta2)){
                quiz.setRisposta2(rispostaGiusta2);
            } else{
                punteggio--;
            }
            if(quiz.getRisposta3().trim().equalsIgnoreCase(rispostaGiusta3)){
                quiz.setRisposta3(rispostaGiusta3);
            } else{
                punteggio--;
            }
            if(quiz.getRisposta4().trim().equalsIgnoreCase(rispostaGiusta4)){
                quiz.setRisposta4(rispostaGiusta4);
            } else{
                punteggio--;
            }

            if(quiz.getRisposta5().trim().equalsIgnoreCase(rispostaGiusta5)){
                quiz.setRisposta5(rispostaGiusta5);
            } else{
                punteggio--;
            }
            if(quiz.getRisposta6().trim().equalsIgnoreCase(rispostaGiusta6)){
                quiz.setRisposta6(rispostaGiusta6);
            } else{
                punteggio--;
            }

            quiz.setPunteggioTotale(punteggio);

            switch(punteggio){
                case 10: {
                    quiz.setVoto("10");
                    break;
                }case 9: {
                    quiz.setVoto("9");
                    break;
                }case 8: {
                    quiz.setVoto("8");
                    break;
                }case 7: {
                    quiz.setVoto("7");
                    break;
                }case 6: {
                    quiz.setVoto("6");
                    break;
                }case 5: {
                    quiz.setVoto("5");
                    break;
                }case 4: {
                    quiz.setVoto("4");
                    break;
                }
            }





        quizService.salvaQuiz(quiz);

        return ResponseEntity.ok(quiz);
    }








}
