package com.example.usermanager.tools;

import com.example.usermanager.model.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: usermanager
 * @description:
 * @author: FENG CHEN
 * @create: 2021-07-24 10:30
 */
public class SessionUtil {
    public static UserInfo getUserBySession(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        UserInfo userInfo=null;
        if (session!=null && (userInfo=(UserInfo)session.getAttribute(AppFinal.USERINFO_SESSION_KEY))!=null){

        }
        return userInfo;
    }
}
