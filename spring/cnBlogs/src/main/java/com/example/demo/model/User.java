package com.example.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * @program: demo
 * @description:
 * @author: FENG CHEN
 * @create: 2021-06-27 15:14
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String photo;
    private Date createtime;
    private Date updatetime;
    private int state;
}
