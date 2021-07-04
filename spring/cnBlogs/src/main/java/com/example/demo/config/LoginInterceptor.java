package com.example.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: demo
 * @description:登录拦截器
 * @author: FENG CHEN
 * @create: 2021-07-04 12:22
 */
public class LoginInterceptor implements HandlerInterceptor {
    //自定义拦截方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断session是否有值
        HttpSession session=request.getSession();
        if (session!=null && session.getAttribute(AppFinal.USERINFO_SESSIONKEY )!=null){
            return true;
        }
        return false;
    }
}
