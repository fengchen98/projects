package com.example.ordersys.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: ordersys
 * @description:
 * @author: FENG CHEN
 * @create: 2021-07-31 14:48
 */
@Data
public class Dish {
    private int id;
    private String name;
    private BigDecimal price;
}
