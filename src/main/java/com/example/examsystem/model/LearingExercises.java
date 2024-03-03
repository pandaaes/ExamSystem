package com.example.examsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class LearingExercises {
    private String[] answerlist = new String[100];
    private String chapterid;
    private String learningPeopleName;
}
