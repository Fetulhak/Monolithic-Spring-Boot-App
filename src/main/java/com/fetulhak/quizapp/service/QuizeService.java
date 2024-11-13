package com.fetulhak.quizapp.service;

import com.fetulhak.quizapp.model.Question;
import com.fetulhak.quizapp.model.QuestionWrapper;
import com.fetulhak.quizapp.model.Quiz;
import com.fetulhak.quizapp.model.Response;
import com.fetulhak.quizapp.repository.QuestionRepo;
import com.fetulhak.quizapp.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizeService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuestionRepo questionRepo;


    public ResponseEntity<String> createQuiz(String category,
                                             int numOfQuestions,
                                             String title) {
        List<Question> questions = questionRepo.findRandomQuestionsByCategory(
                category,numOfQuestions
        );
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);

        return ResponseEntity.ok("Quiz created");

    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
            Optional<Quiz> quiz = quizRepo.findById(id);
            List<Question> questions = quiz.get().getQuestions();
            List<QuestionWrapper> questionWrappers = new ArrayList<>();
            for (Question question : questions) {
                QuestionWrapper qw = new QuestionWrapper(question.getId(),
                        question.getQuestionTitle(),
                        question.getOption1(),
                        question.getOption2(),
                        question.getOption3(),
                        question.getOption4());

                questionWrappers.add(qw);
            }

            return ResponseEntity.ok(questionWrappers);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

    Quiz quiz = quizRepo.findById(id).get();
    List<Question> questions = quiz.getQuestions();
    int right =0;
    int i=0;
    for (Response response : responses) {
        if(response.getResponse().equals(questions.get(i).getRightAnswer()))
        right++;
        i++;
    }
    return ResponseEntity.ok(right);
    }
}
