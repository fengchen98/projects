package com.example.lmsys.controller;

import com.example.lmsys.mapper.AdminMapper;
import com.example.lmsys.model.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author FCCC
 * @version 1.0
 * @date 2021/8/10 10:41
 */
@SpringBootTest

class AdminControllerTest {
    @Resource
    private AdminMapper adminMapper;

    @Test
    void register() {
        Admin admin=new Admin();
        admin.setEmail("111@qq.com");
        admin.setPassword("123");
        System.out.println(adminMapper.register(admin));
    }

    @Test
    void login() {
        Admin admin=new Admin();
        admin.setEmail("111@qq.com");
        admin.setPassword("123");
        System.out.println(adminMapper.login(admin));
    }
}