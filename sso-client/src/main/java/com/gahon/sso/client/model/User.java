package com.gahon.sso.client.model;


import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Gahon
 */
@Data
public class User {
    /**
     * 用户自增id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 用户创建时间
     */
    private LocalDateTime ctime;
}

