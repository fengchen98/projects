package com.example.ordersys.mapper;

import com.example.ordersys.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: ordersys
 * @description:
 * @author: FENG CHEN
 * @create: 2021-07-31 14:57
 */
@Mapper
public interface UserMapper {
    public int register(UserInfo userInfo);

    public List<UserInfo> getUserList();

    public UserInfo login(UserInfo userInfo);
}
