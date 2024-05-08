package com.example.demo.services;

import com.example.demo.DTO.QuestionDto;
import com.example.demo.entities.Question;
import com.example.demo.repo.QuestionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
     private final QuestionRepo questionRepo;

     public ResponseEntity<String> createQuestion(Question question){
          if (questionRepo.findByInsideQuestion(question.getInsideQuestion()) != null){
               return new ResponseEntity<>(question.getInsideQuestion() + "already exist",HttpStatus.FORBIDDEN);
          }
          questionRepo.save(question);
          return new ResponseEntity<>("saved", HttpStatus.CREATED);
     }

     public ResponseEntity<Optional<Question>> getQuestion(long id){
          Optional<Question> newQuestion = questionRepo.findById(id);
          return new ResponseEntity<>(newQuestion ,HttpStatus.OK);
     }

     public ResponseEntity<Optional<QuestionDto>> getQuestionForStudent(long id){
          Optional<Question> newQuestion = questionRepo.findById(id);
          QuestionDto questionDto = new QuestionDto(newQuestion.get().getInsideQuestion(),newQuestion.get().getCategory());
          return new ResponseEntity<>(Optional.of(questionDto),HttpStatus.OK);
     }

     public ResponseEntity<List<Question>> getAllQuestion() {
          return new ResponseEntity<>(questionRepo.findAll(),HttpStatus.OK);
     }

     public ResponseEntity<String> deleteQuestion(long id){
        if(questionRepo.existsById(id)){
             questionRepo.deleteById(id);
             return new ResponseEntity<>("deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("question does not exist", HttpStatus.FORBIDDEN);
     }
     public void updateQuestion(long id,Question newQuestion){
          Optional<Question> oldQuestion = questionRepo.findById(id);
          if (questionRepo.existsById(id)){
               deleteQuestion(id);
          }
          createQuestion(newQuestion);
     }

     public void changeInsideQuestion(Long id, String insideQuestion){
          questionRepo.changeInsideQuestion(id,insideQuestion);
     }
     public void changeAnswer(Long id, Boolean answer){
          questionRepo.changeAnswer(id,answer);
     }
     public void changeCategory(Long id, String category){
          questionRepo.changeCategory(id,category);
     }
}
