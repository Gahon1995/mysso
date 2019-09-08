package com.gahon.sso.server.service;

import com.gahon.sso.server.model.User;

/**
 * @author Gahon
 * @date 2019/9/4
 */
public interface UserService extends BaseService<User> {

//    User getUserById(int id);

    User login(String username, String password);


}
