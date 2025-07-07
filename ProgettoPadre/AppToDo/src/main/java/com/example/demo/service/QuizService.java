package com.example.demo.service;

import com.example.demo.entity.Quiz;
import com.example.demo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private final QuizRepository qrepository;




    public QuizService(QuizRepository qrepository){
        this.qrepository = qrepository;
    }



    public Quiz salvaQuiz(Quiz quiz){
        return qrepository.save(quiz);
    }





}
