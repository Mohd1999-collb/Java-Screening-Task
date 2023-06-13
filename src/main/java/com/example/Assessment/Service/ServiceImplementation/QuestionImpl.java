package com.example.Assessment.Service.ServiceImplementation;

import com.example.Assessment.Dto.RequestDto.AnswerRequestDTO;
import com.example.Assessment.Dto.ResponseDto.NextQuestionResponseDTO;
import com.example.Assessment.Dto.ResponseDto.QuestionDTO;
import com.example.Assessment.Exception.QuestionNotFoundException;
import com.example.Assessment.Model.Question;
import com.example.Assessment.Repository.QuestionRepository;
import com.example.Assessment.Service.QuestionService;
import com.example.Assessment.Transformer.QuestionTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionImpl implements QuestionService {
    @Autowired
    private final  QuestionRepository questionRepository;

    public QuestionImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public QuestionDTO getQuestionById() throws QuestionNotFoundException {
        /*Generate the random number from 1 to 10*/
        int random = (int)(Math.random() * 10 + 1);

        Optional<Question> questionOptional = questionRepository.findById((long)random);
        if (questionOptional.isEmpty()){
            throw new QuestionNotFoundException("Question does not exist.");
        }

        Question question = questionOptional.get();

        /*Prepare question DTO*/
        return QuestionTransformer.questionToQuestionDTO(question);
    }

    @Override
    public NextQuestionResponseDTO checkAnswerAndGetNextQuestion(AnswerRequestDTO answerRequest) {
        /*Create the question and answer entity*/
        Question question = QuestionTransformer.answerRequestToQuestion(answerRequest);

        /*Saved into database*/
        Question savedQuestion = questionRepository.save(question);

        /*Convert savedQuestion to NextQuestionResponseDTO*/
        return QuestionTransformer.questionToNextQuestionResponseDTO(savedQuestion);
    }
}
