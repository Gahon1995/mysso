package com.gahon.sso.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gahon.sso.server.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author Gahon
 */
public interface UserDao extends BaseMapper<User> {

    User getUserById(@Param("id") Integer id);
}
