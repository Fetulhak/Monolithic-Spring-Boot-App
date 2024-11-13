package com.fetulhak.quizapp.service;

import com.fetulhak.quizapp.model.Question;
import com.fetulhak.quizapp.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {


    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<List<Question> >getAllAuestions() {

        try {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<String> addQuestion( Question question) {

        questionRepo.save(question);
        return new ResponseEntity<>("Question added", HttpStatus.CREATED);
    }
}
