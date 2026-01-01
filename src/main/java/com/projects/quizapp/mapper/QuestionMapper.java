package com.projects.quizapp.mapper;

import com.projects.quizapp.dto.CreateQuestionDto;
import com.projects.quizapp.dto.QuestionDto;
import com.projects.quizapp.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    //    by using mapstruct
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    // Entity → DTO (GET)
    QuestionDto toDto(Question question);

    // Create DTO → Entity (POST)
//    @Mapping(target = "id", ignore = true)
    Question toEntity(CreateQuestionDto createQuestionDto);


//    create manual mapper
//    public static QuestionDto toDto(Question question){
//        return new QuestionDto(
//                question.getId(),
//                question.getQuestionTitle(),
//                question.getOption1(),
//                question.getOption2(),
//                question.getOption3(),
//                question.getOption4(),
//                question.getDifficultyLevel(),
//                question.getCategory()
//        );
//    }
//
//    public static Question toEntity(QuestionDto questionDto){
//        return new Question(
//                questionDto.getId(),
//                questionDto.getQuestionTitle(),
//                questionDto.getOption1(),
//                questionDto.getOption2(),
//                questionDto.getOption3(),
//                questionDto.getOption4(),
//                questionDto.getDifficultyLevel(),
//                questionDto.getCategory()
//        );
//    }



}
