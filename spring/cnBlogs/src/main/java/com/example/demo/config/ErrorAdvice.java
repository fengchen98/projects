package com.example.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @program: demo
 * @description:
 * @author: FENG CHEN
 * @create: 2021-07-04 15:46
 */
@ControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object error(Exception e){
        HashMap<String,Object> map=new HashMap<>();
        map.put("status","-1");
        map.put("data","");
        map.put("msg",e.getMessage());
        return map;
    }
}
