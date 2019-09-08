package com.gahon.sso.server.service;

import com.gahon.sso.server.model.User;
import com.gahon.sso.server.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @Test
    public void addUser() {
        List<User> userList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            User user = new User();
//            user.setId(0);
            user.setUsername("user" + i);
            user.setPassword("123456");
            user.setSex("男");
            userList.add(user);
        }
        userService.saveBatch(userList);
    }

    @Test
    public void getUser() {
        User user = userDao.getUserById(1);
        System.out.println(user);
    }
}