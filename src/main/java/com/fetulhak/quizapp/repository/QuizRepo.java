package com.fetulhak.quizapp.repository;

import com.fetulhak.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {
}
