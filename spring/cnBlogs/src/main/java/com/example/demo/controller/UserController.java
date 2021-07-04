package com.example.demo.controller;

import com.example.demo.config.AppFinal;
import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

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

    //登录
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
            session.setAttribute(AppFinal.USERINFO_SESSIONKEY,user);
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

    //注册
    @RequestMapping("/reg")
    public String reg(String username,String password, @RequestPart MultipartFile file) throws IOException {

        //1.获取当前项目的路径
        String path= ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        path+="/upload/";
        log.info("path:"+path);
        //2.文件名
        String fileType=file.getOriginalFilename();
        fileType=fileType.substring(fileType.lastIndexOf("."));
        String fileName= UUID.randomUUID().toString()+fileType;

        file.transferTo(new File(path+fileName));
        return "redirect:/api/regsuccess.html";

    }

    @RequestMapping("/getcookie")
    @ResponseBody
    public Object getCookie(@CookieValue("mysessionid") String cookieid){
        return cookieid;
    }


}
