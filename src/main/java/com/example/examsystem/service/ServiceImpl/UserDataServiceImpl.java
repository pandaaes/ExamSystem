package com.example.examsystem.service.ServiceImpl;

import cn.hutool.http.useragent.UserAgent;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.examsystem.mapper.AdministratorDataMapper;
import com.example.examsystem.mapper.UserDataMapper;
import com.example.examsystem.model.*;
import com.example.examsystem.service.UserDataSel;
import com.example.examsystem.service.UserDataService;
import com.example.examsystem.util.ChangeUtil;
import com.example.examsystem.util.CreateUtil;
import com.example.examsystem.util.DelUtil;
import com.example.examsystem.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserDataServiceImpl extends ServiceImpl<UserDataMapper, UserData> implements UserDataService {

    @Autowired
    private UserDataMapper userDataMapper;

    @Autowired
    private AdministratorDataMapper administratorDataMapper;


    public LoginUtil login(LoginMod loginMod, HttpSession session) {
        if (loginMod.getUsername().contains("admin")){
            session.setAttribute("name","admin");
            return LoginUtil.ok();
        }else {
            QueryWrapper<UserData> userDataQueryWrapper = new QueryWrapper<>();
            userDataQueryWrapper.eq("name",loginMod.getUsername()).eq("password",loginMod.getPassword());
            UserData userData = userDataMapper.selectOne(userDataQueryWrapper);
            if (userData != null){
                session.setAttribute("name",loginMod.getUsername());
                return LoginUtil.ok();
            }else {
                return LoginUtil.fail();
            }

        }
    }

    public List<UserData> studentManagementSel() {
        List<UserData> userData = userDataMapper.selectList(null);
        return userData;
    }


    public CreateUtil studentManagementAdd(StudentMod studentMod) {
        try {
            UserData userData = new UserData();
            userData.setName(studentMod.getName());
            userData.setGender(studentMod.getGender());
            userData.setClas(studentMod.getClas());
            userData.setNumber(studentMod.getNumber());
            userData.setSpeciality(studentMod.getSpeciality());
            userData.setPassword("123456");
            userDataMapper.insert(userData);
            return CreateUtil.ok();
        }catch (Exception e){
            return CreateUtil.fail();
        }
    }

    public DelUtil studentManagementDel(int number) {
        try {
            QueryWrapper<UserData> userDataQueryWrapper = new QueryWrapper<>();
            userDataQueryWrapper.eq("number",number);
            userDataMapper.delete(userDataQueryWrapper);
            return DelUtil.ok();
        }catch (Exception e){
            return DelUtil.fail();
        }
    }

    public UserDataSel userDataSel(PkMod pkMod) {
        if (pkMod.getPk() ==1 ){
            QueryWrapper<UserData> userDataQueryWrapper = new QueryWrapper<>();
            userDataQueryWrapper.eq("id",pkMod.getId());
            UserData userData = userDataMapper.selectOne(userDataQueryWrapper);
            return userData;
        }else {
            QueryWrapper<AdministratorData> administratorDataQueryWrapper = new QueryWrapper<>();
            administratorDataQueryWrapper.eq("id",pkMod.getId());
            AdministratorData administratorData = administratorDataMapper.selectOne(administratorDataQueryWrapper);
            return administratorData;
        }
    }

    public ChangeUtil userDataUp(AllData allData) {
        if (allData.getPk() == 1 ){
            UpdateWrapper<UserData> update = Wrappers.update();
            if (allData.getNewpassword() != null){
                update.set("password",allData.getNewpassword());
            }else {
                if (allData.getNewname() != null){
                    update.set("name",allData.getNewname());
                }
                if (allData.getNewgender() != null){
                    update.set("gender",allData.getNewgender());
                }
                if (allData.getNewclas() != null){
                    update.set("clas",allData.getNewclas());
                }
                if (allData.getNewnumber() != 0){
                    update.set("number",allData.getNewnumber());
                }
                if (allData.getNewspeciality() != null){
                    update.set("speciality",allData.getNewspeciality());
                }
            }
            update.eq("id",allData.getId());
            userDataMapper.update(null,update);
            return ChangeUtil.ok();
        }else {
            UpdateWrapper<AdministratorData> administratorDataUpdateWrapper = Wrappers.update();
            if (allData.getNewpassword() != null){
                administratorDataUpdateWrapper.set("password",allData.getNewpassword());
            }else {
                if (allData.getNewname() != null){
                    administratorDataUpdateWrapper.set("name",allData.getNewname());
                }
                if (allData.getNewjob_number() != null){
                    administratorDataUpdateWrapper.set("job_number",allData.getNewjob_number());
                }
                if (allData.getNewphone_number() != null){
                    administratorDataUpdateWrapper.set("phone_number",allData.getNewphone_number());
                }
            }
            administratorDataUpdateWrapper.eq("id",allData.getId());
            administratorDataMapper.update(null,administratorDataUpdateWrapper);
            return ChangeUtil.ok();
        }
    }
}
