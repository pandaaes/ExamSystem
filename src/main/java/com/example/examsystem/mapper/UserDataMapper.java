package com.example.examsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.examsystem.model.UserData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDataMapper extends BaseMapper<UserData> {
}
