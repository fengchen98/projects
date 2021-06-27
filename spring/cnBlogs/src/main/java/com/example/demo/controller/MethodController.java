package com.example.demo.controller;

import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: demo
 * @description:
 * @author: FENG CHEN
 * @create: 2021-06-27 15:31
 */
@RequestMapping("/met")
@RestController
@Slf4j
public class MethodController {
    @GetMapping("people/{pid}/animal/{aid}")
    public String method1(@PathVariable String pid,@PathVariable("aid") String animalID){
        return "用户ID"+pid+" 动物ID"+animalID;
    }



}
