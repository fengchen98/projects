package com.example.demo.controller;

import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @program: demo
 * @description:
 * @author: FENG CHEN
 * @create: 2021-06-27 10:15
 */
@RequestMapping("/user")
@Controller
@Slf4j
public class UserController {

    //private Logger logger= LoggerFactory.getLogger(UserController.class);
    @RequestMapping("/index")
    @ResponseBody
    public String getIndex(){
            log.error("日志级别为：error");
        return "hello springboot";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Object login( User user, HttpServletRequest request){
        HashMap<String,Object> map=new HashMap<>();
        int status=-1;
        String msg="未知错误";
        String data="登录失败";
        if (user!=null && user.getUsername().equals("root") && user.getPassword().equals("root")){
            HttpSession session = request.getSession();
            //将用户信息存储到session中
            session.setAttribute("userinfo",user);
            status=0;
            msg="";
            data="登录成功";
        }else {
            status=0;
            data="登录失败";
            msg="用户名或密码错误";
        }
        map.put("status",status);
        map.put("data",data);
        map.put("msg",msg);
        return map;
    }


}
