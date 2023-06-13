package com.example.Assessment.Controller;

import com.example.Assessment.Dto.RequestDto.AnswerRequestDTO;
import com.example.Assessment.Dto.ResponseDto.NextQuestionResponseDTO;
import com.example.Assessment.Dto.ResponseDto.QuestionDTO;
import com.example.Assessment.Exception.QuestionNotFoundException;
import com.example.Assessment.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/play")
    public ResponseEntity<Object> play() throws QuestionNotFoundException {
        // Generate a random question ID or select the next question ID
        // Call the questionService.getQuestionById() method to retrieve the question by ID
        // Return the ResponseEntity with the QuestionDTO
        try {
            QuestionDTO questionDTO = questionService.getQuestionById();
            return new ResponseEntity<>(questionDTO, HttpStatus.FOUND);
        }catch (QuestionNotFoundException e){
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/next")
    public ResponseEntity<NextQuestionResponseDTO> next(@RequestBody AnswerRequestDTO answerRequest) {
        // Call the questionService.checkAnswerAndGetNextQuestion() method passing the question ID and the answer from the request body
         NextQuestionResponseDTO nextQuestionResponseDTO = questionService.checkAnswerAndGetNextQuestion(answerRequest);
         return new ResponseEntity<>(nextQuestionResponseDTO, HttpStatus.CREATED);
    }
}
