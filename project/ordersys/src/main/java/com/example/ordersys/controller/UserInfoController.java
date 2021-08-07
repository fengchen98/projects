package com.example.ordersys.controller;

import com.example.ordersys.config.AppFinal;
import com.example.ordersys.mapper.UserMapper;
import com.example.ordersys.model.UserInfo;
import com.example.ordersys.tools.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Resource
    private UserMapper userMapper;

    /**
     * 用户注册（顾客）
     */
    @RequestMapping("/reg")
    public ResponseBody<Integer> register(UserInfo userInfo) {
        int data = userMapper.register(userInfo);
        return new ResponseBody<>(0, "", data);
    }

    /**
     * 查询所有用户列表
     */
    @RequestMapping("/ulist")
    public ResponseBody<List<UserInfo>> getUserList() {
        List<UserInfo> data = new ArrayList<>();
        data = userMapper.getUserList();
        return new ResponseBody<>(0, "", data);
    }

    /**
     * 登录方法
     */
    @RequestMapping("/login")
    public ResponseBody<UserInfo> login(UserInfo userInfo, HttpServletRequest request) {
        UserInfo user = userMapper.login(userInfo);
        if (user != null && user.getId() > 0) {
            // 登录成功，存储 session
            HttpSession session = request.getSession();
            session.setAttribute(AppFinal.USERINFO_SESSION_KEY,
                    user);
        }
        return new ResponseBody<>(0, "", user);
    }

    /**
     * 判断登录状态
     */
    @RequestMapping("/islogin")
    public ResponseBody<UserInfo> isLogin(HttpServletRequest request) {
        UserInfo userInfo = null;
        HttpSession session = request.getSession(false);
        if(session!=null &&
                session.getAttribute(AppFinal.USERINFO_SESSION_KEY)!=null){
            userInfo = (UserInfo) session.getAttribute(AppFinal.USERINFO_SESSION_KEY);
        }
        return new ResponseBody<>(0, "", userInfo);
    }

    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public ResponseBody<Integer> logout(HttpServletRequest request){
        int data = 0;
        HttpSession session = request.getSession(false);
        if(session!=null &&
                session.getAttribute(AppFinal.USERINFO_SESSION_KEY)!=null){
            session.removeAttribute(AppFinal.USERINFO_SESSION_KEY);
            data = 1;
        }
        return new ResponseBody<>(0,"",data);
    }

}
