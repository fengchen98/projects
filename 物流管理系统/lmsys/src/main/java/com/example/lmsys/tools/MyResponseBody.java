package com.example.lmsys.tools;

import lombok.Data;

/**
 * @author FCCC
 * @version 1.0
 * @date 2021/8/10 10:13
 */
@Data
public class MyResponseBody<T> {
    private int status;
    private String msg;
    private T data;

    public MyResponseBody(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
