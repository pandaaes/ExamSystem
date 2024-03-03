package com.example.examsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentPkMod extends UserDataUpdate {
    private String newgender;
    private String newclas;
    private String newspeciality;
    private int newnumber;
}
