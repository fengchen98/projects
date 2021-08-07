package com.example.ordersys.model;

import lombok.Data;

/**
 * @program: ordersys
 * @description:
 * @author: FENG CHEN
 * @create: 2021-07-31 14:50
 */
@Data
public class OrderDetail {
    private int oid;
    private int did;
    private Dish dish;
}
