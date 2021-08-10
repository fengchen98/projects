package com.example.lmsys.mapper;

import com.example.lmsys.model.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author FCCC
 * @version 1.0
 * @date 2021/8/10 10:12
 */
@Mapper
public interface AdminMapper {
    //注册
    public int register(Admin admin);
    //登录
    public Admin login(Admin admin);
}
