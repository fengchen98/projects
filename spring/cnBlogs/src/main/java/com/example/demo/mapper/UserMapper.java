package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //添加用户的方法（注册功能）
    public int addUser(User user);

}
