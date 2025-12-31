package com.projects.quizapp;

import com.projects.quizapp.repository.QuestionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class TestController {

        private final QuestionRepository repo;

        public TestController(QuestionRepository repo) {
            this.repo = repo;
        }

        @GetMapping("/test")
        public Question test() {
            return repo.findAll().get(0);
        }
    }


