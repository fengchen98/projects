package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring_AOP
 * @description:
 * @author: FENG CHEN
 * @create: 2021-07-21 10:44
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public int login(String username,String password){
        System.out.println("执行了 login 方法");
        return 0;
    }

    @RequestMapping("/register")
    public int register(String username,String password){
        System.out.println("执行了 register 方法");
        return 0;
    }

}
