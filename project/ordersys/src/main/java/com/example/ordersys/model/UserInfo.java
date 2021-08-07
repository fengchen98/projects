package com.example.ordersys.model;

import lombok.Data;

/**
 * @program: ordersys
 * @description:
 * @author: FENG CHEN
 * @create: 2021-07-31 14:55
 */
@Data
public class UserInfo {
    private int id;
    private String username;
    private String password;
    private int isadmin;
}
