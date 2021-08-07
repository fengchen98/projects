package com.example.ordersys.model;

import lombok.Data;

import java.util.Date;

/**
 * @program: ordersys
 * @description:
 * @author: FENG CHEN
 * @create: 2021-07-31 14:47
 */
@Data
public class OrderInfo {
    private int id;
    private int uid;
    private Date createtime;
    private int status;
}
