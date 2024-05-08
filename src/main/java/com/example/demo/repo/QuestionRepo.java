package com.example.demo.repo;

import com.example.demo.entities.Question;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface QuestionRepo extends JpaRepository<Question,Long> {
    public Question findByInsideQuestion(String insideQuestion);
    @Modifying
    @Query("UPDATE Question q SET q.insideQuestion = :insideQuestion WHERE q.id = :id")
    public void changeInsideQuestion(Long id ,String insideQuestion );

    @Modifying
    @Query("UPDATE Question q SET q.answer = :answer WHERE q.id = :id")
    public void changeAnswer(Long id, Boolean answer);
    @Modifying
    @Query("UPDATE Question q SET q.category = :category WHERE  q.id = :id")
    public void changeCategory(Long id, String category);
}
