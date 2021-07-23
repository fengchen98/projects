package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/met")
public class MethedController {

    @GetMapping("/people/{pid}/animal/{aid}")
    public String method1(@PathVariable String pid,
                          @PathVariable("aid") String animalId) {
        return "用户ID：" + pid + "，动物ID：" + animalId;
    }

    @RequestMapping("/getname")
    public String method2(String name) {
        return "姓名：" + name;
    }

    @RequestMapping("/login")
    public String method3(@RequestBody String name, String password) {
        return "姓名：" + name + " ，密码：" + password;
    }

    @RequestMapping("/reg")
    public String method4(@RequestParam(required = false) String name) {
        return "姓名：" + name;
    }

    @RequestMapping("/reg2")
    public String reg(@RequestParam String username,
                      @RequestParam String password,
                      @RequestParam String img) {
        return "username:" + username +
                ",password:" + password + ",img:" + img;
    }

    @RequestMapping("/reg3")
    public String reg3(@RequestBody User user) {
        return "username:" + user.getUsername() +
                ",password:" + user.getPassword() +
                ",img:" + user.getPhoto();
    }

}
