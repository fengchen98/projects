package com.example.usermanager.mapper;

import com.example.usermanager.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: usermanager
 * @description:
 * @author: FENG CHEN
 * @create: 2021-07-23 16:45
 */
@Mapper
public interface UserMapper {



    public UserInfo login(String username, String password);
    public int add(UserInfo userInfo);


   public UserInfo getUser(int uid);

   public int update(UserInfo userInfo);

    public List<UserInfo> getListByPage(String name, String address, String email, int skipCount, int psize, Integer isadmin);

    public int getCount(String name, String address, String email, Integer isadmin);

    public int del(int id, Integer isadmin);

    public int dels(String[] ids);
}
