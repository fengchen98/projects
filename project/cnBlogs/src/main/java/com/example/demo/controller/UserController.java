package com.example.demo.controller;

import com.example.demo.config.AppFinal;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.ArticleInfo;
import com.example.demo.model.User;
import com.example.demo.tool.HtmlText;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserMapper userMapper;

    @Value("${myimgpath}")
    private String imgpath;


    // 创建一个当前类日志对象
//    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/getalist")
    @ResponseBody
    public Object getFullUser(int uid) {
        User user = userMapper.getFullUser(uid);
        // 对文章的正文进行截取操作
        List<ArticleInfo> list = user.getAlist();
        for (ArticleInfo item : list) {
            // 去除html标签
            String desc = HtmlText.Html2Text(item.getContent());
            // 截取字符串
            if (desc.length() > 64) {
                desc = desc.substring(0, 64) + "...";
            }
            item.setContent(desc);
        }
        user.setAlist(list);
        return user;
    }

    @RequestMapping("/sayhi")
    @ResponseBody
    public String getIndex() {
        log.error("我的日志信息，级别：error");
        log.warn("我的日志信息，级别：warn");
        log.info("我的日志信息，级别：info");
        log.debug("我的日志信息，级别：debug");
        log.trace("我的日志信息，级别：trace");
        return "你好，SpringBoot";
    }

    @RequestMapping("/login")
    @ResponseBody // 当前方法返回的为数据而非视图
    public Object login(User user, HttpServletRequest request) throws JsonProcessingException {
        User user2 = userMapper.getUserByNameAndPassword(user.getUsername(),
                user.getPassword());
        if (user2 == null) {
            user2 = user;
        } else {
            // 登录成功，设置
            HttpSession session = request.getSession();
            // 存放到 Session
            session.setAttribute(AppFinal.USERINFO_SESSIONKEY, user2);
        }
        return user2;

//        // 返回的对象
//        HashMap<String, Object> map = new HashMap<>();
//        int status = -1; // 非正常返回
//        String msg = "未知错误";
//        String data = "登录失败";
//        if (user != null &&
//                user.getUsername().equals("root") &&
//                user.getPassword().equalsIgnoreCase("root")) {
//            // 登录信息存储到 Session
//            HttpSession session = request.getSession();
//            session.setAttribute(AppFinal.USERINFO_SESSIONKEY, user);
//            status = 0;
//            msg = "";
//            data = "登录成功";
//        } else {
//            status = 0;
//            msg = "用户名错误";
//            data = "登录失败";
//        }
//        map.put("status", status);
//        map.put("msg", msg);
//        map.put("data", data);
//        return map;
    }


    @RequestMapping("/login2")
    @ResponseBody // 当前方法返回的为数据而非视图
    public Object login2(@RequestParam String name, HttpServletRequest request) {
        // 返回的对象
        HashMap<String, Object> map = new HashMap<>();
        int status = -1; // 非正常返回
        String msg = "未知错误";
        String data = "登录失败";
        if (name.equals("root")) {
            // 登录信息存储到 Session
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            status = 0;
            msg = "";
            data = "登录成功";
        } else {
            status = 0;
            msg = "用户名错误";
            data = "登录失败";
        }
        map.put("status", status);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }

    @RequestMapping("/login3")
    @ResponseBody // 当前方法返回的为数据而非视图
    public Object login3(@RequestParam(name = "name") String username,
                         String password,
                         HttpServletRequest request) {
        // 返回的对象
        HashMap<String, Object> map = new HashMap<>();
        int status = -1; // 非正常返回
        String msg = "未知错误";
        String data = "登录失败";
        map.put("status", status);
        map.put("msg", msg);
        map.put("data", username);
        return map;
    }

    @RequestMapping("/reg")
    public String regin(String username, String password,
                        @RequestPart MultipartFile file) throws IOException {
        // todo:非空效验
        // 1.动态获取当前项目的路径
//        String path = ClassUtils.getDefaultClassLoader().
//                getResource("static").getPath();
        String path = imgpath;
        //path += AppFinal.IMAGE_PAHT;
        log.info("path:" + path);
        // 2.文件名（全局唯一id【UUID】）+文件的原始类型
        String fileType = file.getOriginalFilename(); // img.png
        fileType = fileType.substring(fileType.lastIndexOf("."));
        // 文件名
        String fileName = UUID.randomUUID().toString() + fileType;
        // 将文件保存到服务器
        file.transferTo(new File(path + fileName));
        // 将用户信息存储到服务器
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoto(AppFinal.IMAGE_PAHT + fileName); //设置头像地址
        int result = userMapper.addUser(user);
        if (result > 0) {
            // 操作成功
            return "redirect:/login.html";
        } else {
            return "redirect:/reg_err.html";
        }
    }

    @RequestMapping("/getcookie")
    @ResponseBody
    public Object getCookie(@CookieValue(value = "mysessionid", required = false) String cookieid) {
        return cookieid;
    }

    @RequestMapping("/test")
    @ResponseBody
    public Object test() {
//        int i = 10 / 0;
        String username = null;
        System.out.println(username.hashCode());
        return "Hello";
    }


    @RequestMapping("/method1")
    @ResponseBody
    public Object method1() {
//        HashMap<String, Object> map = new HashMap<>();
        Object data = "method1";
//        map.put("status", 0);
//        map.put("data", data);
//        map.put("msg", "");
//        return map;
        return data;
    }

    @RequestMapping("/method2")
    @ResponseBody
    public Object method2() {
//        HashMap<String, Object> map = new HashMap<>();

        Object data = "method2";
//        map.put("status", 0);
//        map.put("data", data);
//        map.put("msg", "");
//        return map;
        return data;
    }


}
