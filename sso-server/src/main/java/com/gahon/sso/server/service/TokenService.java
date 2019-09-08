package com.gahon.sso.server.service;

import com.gahon.sso.server.model.Token;
import com.gahon.sso.server.model.vo.TokenUserVo;

import java.time.LocalDateTime;

/**
 * @author Gahon
 * @date 2019/9/4
 */
public interface TokenService extends BaseService<Token> {

    Token getToken(String token);

    //    Token getTokenById(int id);
    Token addToken(int uid, String token);

    TokenUserVo getTokenUser(String token);

    boolean disableToken(String token);

    boolean updateTokenUpdateTime(Integer id, LocalDateTime updateTime);

}
