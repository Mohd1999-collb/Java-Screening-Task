package com.example.Assessment.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "Question")
public class Question {
    @Id
    Long questionId;

    @Column(name = "Question")
    String question;

    @Column(name = "Answer")
    String answer;
}
