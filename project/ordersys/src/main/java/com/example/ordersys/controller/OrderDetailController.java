package com.example.ordersys.controller;

/**
 * @program: ordersys
 * @description:
 * @author: FENG CHEN
 * @create: 2021-08-07 14:31
 */

import com.example.ordersys.mapper.OrderDetailMapper;
import com.example.ordersys.model.OrderDetail;
import com.example.ordersys.tools.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/detail")
public class OrderDetailController {

    @Resource
    private OrderDetailMapper orderDetailMapper;

    @RequestMapping("/list")
    public ResponseBody<List<OrderDetail>> getList(int oid){
        List<OrderDetail> list = orderDetailMapper.getList(oid);
        return new ResponseBody<>(0,"",list);
    }

}
