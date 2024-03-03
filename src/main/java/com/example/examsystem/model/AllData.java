package com.example.examsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllData {
    private int pk;
    private int id;
    private String newname;
    private String newpassword;
    private String newjob_number;
    private String newphone_number;
    private String newgender;
    private String newclas;
    private String newspeciality;
    private int newnumber;
}
