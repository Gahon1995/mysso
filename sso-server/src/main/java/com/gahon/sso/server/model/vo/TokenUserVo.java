package com.gahon.sso.server.model.vo;

import com.gahon.sso.server.model.Token;
import com.gahon.sso.server.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Gahon
 * @date 2019/9/5
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TokenUserVo extends Token {
    /**
     * 登录用户信息
     */
    private User user;
}
