package com.example.Assessment.Service;

import com.example.Assessment.Dto.RequestDto.AnswerRequestDTO;
import com.example.Assessment.Dto.ResponseDto.NextQuestionResponseDTO;
import com.example.Assessment.Dto.ResponseDto.QuestionDTO;
import com.example.Assessment.Exception.QuestionNotFoundException;

public interface QuestionService {

    QuestionDTO getQuestionById() throws QuestionNotFoundException;

//    NextQuestionResponseDTO checkAnswerAndGetNextQuestion(AnswerRequestDTO answerRequest);
    NextQuestionResponseDTO checkAnswerAndGetNextQuestion(AnswerRequestDTO answerRequest);
}
