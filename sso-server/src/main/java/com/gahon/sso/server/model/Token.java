package com.gahon.sso.server.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author Gahon
 */
@Data
public class Token {
    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 登录用户uid
     */
    private int uid;

    /**
     * 存储token，用于判断用户是否登录
     */
    private String token;

    /**
     * token是否过期
     */
    private int disable;

    /**
     * token过期时长，按分钟数算
     */
    private Integer expireMinute;

    /**
     * token上次刷新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * token创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}

