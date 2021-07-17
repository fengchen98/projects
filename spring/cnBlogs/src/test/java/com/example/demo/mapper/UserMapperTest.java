package com.example.demo.mapper;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
//@Transactional
        // 保证方法可以正常执行，并且不会存储到数据库中
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void addUser() {
        User user = new User();
        user.setUsername("孙猴子");
        user.setPassword("吃俺老孙一棒");
        user.setPhoto("abc.png");
        int result = userMapper.addUser(user); // 返回的拥有的修改的行数

        System.out.println(result);
        System.out.println("-----------------------id:" + user.getId());
    }

    @Test
    void getUserById() {
        User user = userMapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    void getUserByNameAndPassword() {
        User user = userMapper.getUserByNameAndPassword("八戒", "123");
        System.out.println(user);
    }

    @Test
    void getAll() {
        List<User> list = userMapper.getAll();
        list.forEach(System.out::println);
    }

    @Test
    void delById() {
        int reuslt = userMapper.delById(14);
        System.out.println(reuslt);
    }

    @Test
    void upUser() {
        int result = userMapper.upUser(9, "猪八戒");
        System.out.println(result);
    }

    @Test
    void getList() {
        List<User> list = userMapper.getList("desc");
        list.forEach(System.out::println);
    }

    @Test
    void getListByName() {
//        String username = "孙";
        String username = "%' or username='%";
        // 手动过滤 SQL 注入
        username = username.replace("'", "").replace("or", "");
        List<User> list = userMapper.getListByName(username);
        list.forEach(System.out::println);
    }

    @Test
    void getListByName2() {
//        String username = "孙";
        String username = "%' or username='%";
        List<User> list = userMapper.getListByName2(username);
        list.forEach(System.out::println);
    }

    @Test
    void getFullUser() {
        User user = userMapper.getFullUser(1);
        System.out.println(user);
    }

    @Test
    void testGetFullUser() {
    }
}