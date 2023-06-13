package com.example.Assessment.Dto.RequestDto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AnswerRequestDTO {
    Long questionId;
    String question;
    String answer;
}
