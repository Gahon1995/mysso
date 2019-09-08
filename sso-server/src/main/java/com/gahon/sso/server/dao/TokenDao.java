package com.gahon.sso.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gahon.sso.server.model.Token;
import com.gahon.sso.server.model.vo.TokenUserVo;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * @author Gahon
 * @date 2019/9/4
 */
public interface TokenDao extends BaseMapper<Token> {

    TokenUserVo getTokenUser(String token);

    boolean disableToken(String token);

    boolean updateTokenTime(@Param("id") Integer id, @Param("update_time") LocalDateTime updateTime);

}
