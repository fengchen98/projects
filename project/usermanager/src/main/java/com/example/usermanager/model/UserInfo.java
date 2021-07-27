package com.example.usermanager.model;

import lombok.Data;

/**
 * @program: usermanager
 * @description:
 * @author: FENG CHEN
 * @create: 2021-07-23 16:42
 */
@Data
public class UserInfo {
    private int id;
    private String name;
    private String username;
    private String password;
    private String sex;
    private int age;
    private String address;
    private String qq;
    private String email;
    private int isadmin;
}
