package com.fetulhak.quizapp.controller;


import com.fetulhak.quizapp.model.Question;
import com.fetulhak.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

   @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllAuestions(){
         return questionService.getAllAuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory( @PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
       return questionService.addQuestion(question);
    }


    @PostMapping("/addMultiple")
    public ResponseEntity<String> addQuestions(@RequestBody List<Question> questions) {
        for (Question question : questions) {
            questionService.addQuestion(question);
        }
        return ResponseEntity.ok("Questions added successfully!");
    }


}
