package com.example.examsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentMod {
    public String name;
    public String gender;
    public String clas;
    public int number;
    public String speciality;
    public String password="123456";
}
