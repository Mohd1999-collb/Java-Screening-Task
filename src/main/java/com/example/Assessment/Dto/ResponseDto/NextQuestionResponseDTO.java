package com.example.Assessment.Dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class NextQuestionResponseDTO {
    String correctAnswer;
    QuestionDTO nextQuestion;
}
