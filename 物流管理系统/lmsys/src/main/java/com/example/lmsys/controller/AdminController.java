package com.example.lmsys.controller;

import com.example.lmsys.config.AppFinal;
import com.example.lmsys.mapper.AdminMapper;
import com.example.lmsys.model.Admin;
import com.example.lmsys.tools.MyResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author FCCC
 * @version 1.0
 * @date 2021/8/10 10:11
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminMapper adminMapper;

    //注册功能(管理员)
    @RequestMapping("/register")
    public MyResponseBody<Integer> register(Admin admin){
        int data=adminMapper.register(admin);
        return new MyResponseBody<>(0,"",data);
    }

    //登录功能
    @RequestMapping("/login")
    public MyResponseBody<Admin> login(Admin admin, HttpServletRequest request){
        Admin data=adminMapper.login(admin);
        if (data!=null && data.getId()>0){
            //登录成功
            HttpSession session=request.getSession();
            session.setAttribute(AppFinal.USERINFO_SESSION_KEY,data);
        }
        return new MyResponseBody<>(0,"",data);
    }

    //退出功能
    @RequestMapping("/logout")
    public MyResponseBody<Integer> logout(HttpServletRequest request){
        int data = 0;
        HttpSession session = request.getSession(false);
        if(session!=null &&
                session.getAttribute(AppFinal.USERINFO_SESSION_KEY)!=null){
            session.removeAttribute(AppFinal.USERINFO_SESSION_KEY);
            data = 1;
        }
        return new MyResponseBody<>(0,"",data);

    }


}
