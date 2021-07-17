package com.example.demo.controller;

import com.example.demo.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/mvc")
//@Controller // spring 初始化此类
@ResponseBody
@RestController
@Slf4j
public class MVCController {

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/index8")
    public User getIndex8(){
        User user = new User();
        user.setUsername("Java");
        user.setPassword("hello");
        return user;
    }

    @RequestMapping("/index7")
    @ResponseBody // 返回类型为自定义的类型，而非视图
    public String getIndex7() throws JsonProcessingException {
        User user = new User();
        user.setUsername("Java");
        user.setPassword("hello");
        // 将对象转换成 JSON 字符串
        String result =
                objectMapper.writeValueAsString(user);
        log.error(result);
        return result;
    }

    @RequestMapping(value = "/index6",method = RequestMethod.GET)
    @ResponseBody // 返回类型为自定义的类型，而非视图
    public String getIndex6(){
        return "/index.html";
    }

    @PostMapping("/index5")
    public String getIndex5(){
        log.error("我是 index5");
        return "/index.html";
    }

    @GetMapping("/index4")
    public String getIndex4(){
        log.error("我是 index4");
        return "/index.html";
    }

    @RequestMapping("/index")
    public String getIndex(){
        log.error("我是 index.html");
        return "redirect:/index.html";
    }

    @RequestMapping("/index2")
    public String getIndex2(){
        log.error("我是请求转发");
        return "forward:/index.html";
    }

    /**
     * 实现 301 跳转
     * @param response
     * @return
     */
    @RequestMapping("/index3")
    public String getIndex3(HttpServletResponse response){
        response.setStatus(301);
//        response.setHeader("Location","http://localhost:8081/index.html");
        response.setHeader("Location","/index.html");
        return null;
    }

}
