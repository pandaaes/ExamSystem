package com.example.examsystem.service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.examsystem.mapper.AdministratorDataMapper;
import com.example.examsystem.model.AdministratorData;
import com.example.examsystem.service.AdministratorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorDataServiceImpl extends ServiceImpl<AdministratorDataMapper, AdministratorData> implements AdministratorDataService {

    @Autowired
    private AdministratorDataMapper administratorDataMapper;
}
