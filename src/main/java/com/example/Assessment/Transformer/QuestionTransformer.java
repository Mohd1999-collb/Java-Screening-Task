package com.example.Assessment.Transformer;

import com.example.Assessment.Dto.RequestDto.AnswerRequestDTO;
import com.example.Assessment.Dto.ResponseDto.NextQuestionResponseDTO;
import com.example.Assessment.Dto.ResponseDto.QuestionDTO;
import com.example.Assessment.Model.Question;

public class QuestionTransformer {
    public static  Question answerRequestToQuestion(AnswerRequestDTO answerRequestDTO){
        return Question.builder()
                .questionId(answerRequestDTO.getQuestionId())
                .answer(answerRequestDTO.getAnswer())
                .question(answerRequestDTO.getQuestion())
                .build();
    }

    public static NextQuestionResponseDTO questionToNextQuestionResponseDTO(Question question){
        QuestionDTO question1 = new QuestionDTO();
        question1.setQuestion(question.getQuestion());
        question1.setQuestionId(question.getQuestionId());

        return NextQuestionResponseDTO.builder()
                .correctAnswer(question.getAnswer())
                .nextQuestion(question1)
                .build();
    }

    public static QuestionDTO questionToQuestionDTO(Question question){
        return QuestionDTO.builder()
                .questionId(question.getQuestionId())
                .question(question.getQuestion())
                .answer(question.getAnswer())
                .build();
    }
}
