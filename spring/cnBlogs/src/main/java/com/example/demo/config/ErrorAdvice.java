package com.example.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@ControllerAdvice
public class ErrorAdvice {


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Object err2(Exception e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "-2");
        map.put("data", "");
        map.put("msg", e.getMessage());
        return map;
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Object err3(Exception e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "-3");
        map.put("data", "");
        map.put("msg", "空指针异常");
        return map;
    }

    @ExceptionHandler
    @ResponseBody
    public Object err(Exception e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "-1");
        map.put("data", "");
        map.put("msg", e.getMessage());
        return map;
    }

}
