package com.example.demo.repo;

import com.example.demo.entities.Quiz;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional 
public interface QuizRepo extends JpaRepository<Quiz,Long> {
}
