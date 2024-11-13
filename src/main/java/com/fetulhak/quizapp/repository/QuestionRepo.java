package com.fetulhak.quizapp.repository;

import com.fetulhak.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);

   @Query(value="SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() " +
           "LIMIT :numOfQuestions", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numOfQuestions);
}
