package com.example.mybatis.dao;

import com.example.mybatis.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {

    //新增方法
    public int addUser(UserInfo userInfo);
}
