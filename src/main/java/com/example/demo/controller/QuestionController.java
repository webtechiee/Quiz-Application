package com.example.demo.controller;

import com.example.demo.DTO.QuestionDto;
import com.example.demo.entities.Question;
import com.example.demo.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("createQuestion")
    public ResponseEntity<String> createQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    @GetMapping("getQuestion")
    public ResponseEntity<Optional<Question>> getQuestion(@RequestParam long id) {
        return questionService.getQuestion(id);
    }

    @GetMapping("getAllQuestion")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @DeleteMapping("deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable long id) {
        return questionService.deleteQuestion(id);
    }

    @GetMapping("getQuestionForStudent")
    public ResponseEntity<Optional<QuestionDto>> getQuestionForStudent(@RequestParam("id") long id) {
        return questionService.getQuestionForStudent(id);
    }

    @PutMapping("updateQuestion")
    public void updateQuestion(@RequestParam("id") long id, @RequestBody  Question newQuestion) {
        questionService.updateQuestion(id, newQuestion);
    }
    @PutMapping("changeInsideQuestion")
    public void changeInsideQuestion(@RequestParam("id")Long id, @RequestParam("insideQuestion") String insideQuestion) {
        questionService.changeInsideQuestion(id,insideQuestion);
    }
    @PostMapping("changeAnswer")
    public void changeAnswer(@RequestParam Long id, @RequestParam Boolean answer){
        questionService.changeAnswer(id,answer);
    }
    @PostMapping("changeCategory")
    public void changeCategory(@RequestParam Long id,@RequestParam String category) {
        questionService.changeCategory(id,category);
}
}