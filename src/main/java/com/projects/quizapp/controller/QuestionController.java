package com.projects.quizapp.controller;

import com.projects.quizapp.dto.CreateQuestionDto;
import com.projects.quizapp.dto.QuestionDto;
import com.projects.quizapp.entity.Question;
import com.projects.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<QuestionDto>> getAllQuestions(){
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<QuestionDto>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody CreateQuestionDto createQuestionDto){
        return questionService.addQuestion(createQuestionDto);
    }
}