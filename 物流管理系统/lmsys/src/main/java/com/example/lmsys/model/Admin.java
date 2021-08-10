package com.example.lmsys.model;

import lombok.Data;

/**
 * @author FCCC
 * @version 1.0
 * @date 2021/8/10 10:07
 */
@Data
public class Admin {
    private int id;
    private String create_at;
    private String email;
    private String password;
    private String roles;

}
