package com.projects.quizapp.service;

import com.projects.quizapp.dto.CreateQuestionDto;
import com.projects.quizapp.dto.QuestionDto;
import com.projects.quizapp.entity.Question;
import com.projects.quizapp.mapper.QuestionMapper;
import com.projects.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuestionMapper questionMapper;

    public ResponseEntity<List<QuestionDto>> getAllQuestion(){
        try {
            return new ResponseEntity<>(questionRepository.findAll()
                    .stream()
                    .map(questionMapper::toDto)
                    .toList()
                    , HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<QuestionDto>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepository.findByCategory(category)
                    .stream()
                    .map(questionMapper::toDto)
                    .toList()
                    , HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(questionRepository.findByCategory(category)
                .stream()
                .map(questionMapper::toDto)
                .toList()
                , HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(CreateQuestionDto createQuestionDto) {
        Question question = questionMapper.toEntity(createQuestionDto);

        questionRepository.save(question);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
