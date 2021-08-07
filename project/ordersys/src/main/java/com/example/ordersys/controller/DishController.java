package com.example.ordersys.controller;

import com.example.ordersys.mapper.DishMapper;
import com.example.ordersys.model.Dish;
import com.example.ordersys.tools.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: ordersys
 * @description:
 * @author: FENG CHEN
 * @create: 2021-08-01 11:24
 */
@RestController
@RequestMapping("/dish")
public class DishController {

    @Resource
    private DishMapper dishMapper;

    @RequestMapping("/list")
    public ResponseBody<List<Dish>> getList(){
        List<Dish> data=dishMapper.getList();
        return new ResponseBody<>(0,"",data);
    }
}
