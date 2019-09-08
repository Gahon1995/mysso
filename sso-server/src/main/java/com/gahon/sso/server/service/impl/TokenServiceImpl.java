package com.gahon.sso.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gahon.sso.server.dao.TokenDao;
import com.gahon.sso.server.model.SsoConfig;
import com.gahon.sso.server.model.Token;
import com.gahon.sso.server.model.vo.TokenUserVo;
import com.gahon.sso.server.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Gahon
 * @date 2019/9/4
 */
@Service
public class TokenServiceImpl extends ServiceImpl<TokenDao, Token> implements TokenService {

    @Autowired
    TokenDao tokenDao;

    @Autowired
    SsoConfig ssoConfig;

    @Override
    public Token getToken(String token) {
        return this.getOne(new QueryWrapper<Token>().eq("token", token));
    }

    @Override
    public Token addToken(int uid, String token) {
        Token token1 = new Token();
        token1.setUid(uid);
        token1.setToken(token);
        token1.setExpireMinute(ssoConfig.getExpireMinute());
        this.save(token1);
        return token1;
    }

    @Override
    public TokenUserVo getTokenUser(String token) {
        return tokenDao.getTokenUser(token);
    }

    @Override
    public boolean disableToken(String token) {
        return tokenDao.disableToken(token);
    }

    @Override
    public boolean updateTokenUpdateTime(Integer id, LocalDateTime updateTime) {
        return this.update(new UpdateWrapper<Token>().eq("id", id).set("update_time", updateTime));
    }
}
