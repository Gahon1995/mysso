package com.gahon.sso.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gahon.sso.server.dao.UserDao;
import com.gahon.sso.server.model.User;
import com.gahon.sso.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gahon
 * @date 2019/9/4
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User login(String username, String password) {
        return this.getOne(new QueryWrapper<User>().eq("username", username).eq("password", password));
    }
}
