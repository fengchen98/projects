package com.example.mybatis.model;

import lombok.Data;

import java.util.Date;

/**
 * @program: mybatis
 * @description:
 * @author: FENG CHEN
 * @create: 2021-07-04 17:24
 */
@Data
public class UserInfo {
    private int id;
    private String username;
    private String password;
    private String photo;
    private Date createtime;
    private Date updatetime;
    private int state;

}
