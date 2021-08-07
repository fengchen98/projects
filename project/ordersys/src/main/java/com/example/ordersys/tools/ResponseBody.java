package com.example.ordersys.tools;

import lombok.Data;

/**
 * @program: ordersys
 * @description:
 * @author: FENG CHEN
 * @create: 2021-07-31 14:53
 */
@Data
public class ResponseBody<T> {
    private int status;
    private String msg;
    private T data;

    public ResponseBody(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
