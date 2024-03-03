package com.example.examsystem.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.examsystem.service.LearningRecordsSel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@TableName("recording")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordingData implements LearningRecordsSel {
    public int id;
    public LocalDateTime times;
    public String learningPeopleName;
    public String chapter;
    public int fraction;
}
