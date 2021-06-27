package com.example.demo.controller;

import com.example.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @program: demo
 * @description:
 * @author: FENG CHEN
 * @create: 2021-06-27 11:29
 */
@Controller
@RequestMapping("/mvc")
@Slf4j
public class MVCController {
    //请求转发
    //URL地址不变
    //有可能导致外部资源访问不到
    @RequestMapping("/index")
    public String getIndex(){
        return "forward:/index.html";
    }


    //请求重定向（临时重定向）
    //URL地址放生了改变
    @RequestMapping("/index2")
    public String getIndex2(){
        return "redirect:/index.html";
    }

    @RequestMapping("/index3")
    @ResponseBody
    public String getIndex3(){
        return "index.html";
    }

    @Autowired
    private ObjectMapper objectMapper;

    @ResponseBody
    @RequestMapping("/index4")
    public User getIndex4(){
        User user=new User();
        user.setUsername("java");
        user.setPassword("java");
        return user;
    }
}
