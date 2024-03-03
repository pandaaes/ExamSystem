package com.example.examsystem.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.examsystem.service.UserDataSel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData implements UserDataSel {
    public int id;
    public String name;
    public String gender;
    public String clas;
    public int number;
    public String speciality;
    public String password;
    public String topic1;
    public String topic2;
    public String topic3;


}
