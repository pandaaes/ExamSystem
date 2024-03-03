package com.example.examsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdminPkMod extends UserDataUpdate{
    private String newjob_number;
    private String newphone_number;
}
