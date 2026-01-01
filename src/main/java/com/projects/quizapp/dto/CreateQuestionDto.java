package com.projects.quizapp.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateQuestionDto {
        private Integer id;
        private String questionTitle;
        private String option1;
        private String option2;
        private String option3;
        private String option4;
        private String rightAnswer;
        private String difficultyLevel;
        private String category;

}

