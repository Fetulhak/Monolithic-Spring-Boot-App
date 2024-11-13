package com.fetulhak.quizapp.controller;

import com.fetulhak.quizapp.model.Question;
import com.fetulhak.quizapp.model.QuestionWrapper;
import com.fetulhak.quizapp.model.Response;
import com.fetulhak.quizapp.service.QuizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

   @Autowired
    private QuizeService quizeService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                             @RequestParam int numOfQuestions,
                                             String title) {
        return quizeService.createQuiz(category,numOfQuestions,title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id) {
        return quizeService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,
                                              @RequestBody List<Response> responses) {

        return quizeService.calculateResult(id,responses);
    }


}
