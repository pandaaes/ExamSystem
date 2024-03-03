package com.example.examsystem.model;


import com.baomidou.mybatisplus.annotation.TableName;
import com.example.examsystem.service.UserDataSel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("administrator")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministratorData implements UserDataSel {
    public int id;
    public int jobNumber;
    public String password;
    public String name;
    public int phoneNumber;

}
