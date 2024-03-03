package com.example.examsystem.controller;

import com.example.examsystem.model.*;
import com.example.examsystem.service.ServiceImpl.AdministratorDataServiceImpl;
import com.example.examsystem.service.ServiceImpl.QuestionbankDataServiceImpl;
import com.example.examsystem.service.ServiceImpl.RecordingDataServiceImpl;
import com.example.examsystem.service.ServiceImpl.UserDataServiceImpl;
import com.example.examsystem.service.UserDataSel;
import com.example.examsystem.util.ChangeUtil;
import com.example.examsystem.util.CreateUtil;
import com.example.examsystem.util.DelUtil;
import com.example.examsystem.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserDataServiceImpl userDataService;

    @Autowired
    private AdministratorDataServiceImpl administratorDataService;

    @Autowired
    private QuestionbankDataServiceImpl questionbankDataService;

    @Autowired
    private RecordingDataServiceImpl recordingDataService;


    /**
     * 登录
     * @param loginMod
     * @param session
     * @return
     */
    @PostMapping("/login")
    public LoginUtil login(@RequestBody LoginMod loginMod, HttpSession session){
        return userDataService.login(loginMod,session);
    }

    /**
     * 获取所有用户数据
     * @return
     */
    @GetMapping("/studentmanagement")
    public List<UserData> studentManagementSel(){
        return userDataService.studentManagementSel();
    }

    /**
     * 添加用户数据
     */
    @PostMapping("/studentmanagement")
    public CreateUtil studentManagementAdd(@RequestBody StudentMod studentMod){
        return userDataService.studentManagementAdd(studentMod);
    }

    /**
     * 删除用户数据
     */
    @PutMapping("/studentmanagement/{number}")
    public DelUtil studentManagementDel(@PathVariable int number){
        return userDataService.studentManagementDel(number);
    }

    /**
     * 查询信息
     */
    @PostMapping("/userdata")
    public UserDataSel userDataSel(@RequestBody PkMod pkMod){
        return userDataService.userDataSel(pkMod);
    }

    /**
     * 修改
     */
    @PutMapping("/userdata")
    public ChangeUtil userDataUp(@RequestBody AllData allData){
        return userDataService.userDataUp(allData);
    }


}
