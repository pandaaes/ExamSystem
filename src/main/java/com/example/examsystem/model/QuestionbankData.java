package com.example.examsystem.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("questionbank")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionbankData {
    public int id;
    public String chapter;
    public String title;
    public String opA;
    public String opB;
    public String opC;
    public String opD;
    public String correctAnswer;

}
