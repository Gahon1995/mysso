package com.gahon.sso.server.controller;

import com.gahon.sso.server.model.Token;
import com.gahon.sso.server.model.User;
import com.gahon.sso.server.model.vo.TokenUserVo;
import com.gahon.sso.server.service.TokenService;
import com.gahon.sso.server.service.UserService;
import com.gahon.sso.server.util.Result;
import com.gahon.sso.server.util.ResultGenerate;
import com.gahon.sso.server.util.TokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gahon
 * @date 2019/9/5
 */
@RestController
@RequestMapping("/sso")
public class SsoController {
    Logger logger = LoggerFactory.getLogger(SsoController.class);

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;


    @PostMapping("/login")
    public Result login(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return ResultGenerate.fail("用户名或密码不能为空");
        }
        final User user = userService.login(username, password);
        if (user == null) {
            return ResultGenerate.fail("用户名或密码错误");
        }
        logger.info("user: " + user + " login");

        String token = TokenUtils.genToken();

        Token token1 = tokenService.addToken(user.getId(), token);
        logger.info("add token: {}", token1);

        Map<String, String> map = new HashMap<>(1);
        map.put("token", token1.getToken());
        return ResultGenerate.success(map);
    }

    @RequestMapping("/logout")
    public Result logout(@RequestParam("token") String token) {
//        Token userToken = tokenService.getToken(token);
//        if (userToken == null) {
//            return ResultGenerate.success();
//        }
//        忽略token的是不是已经存在
        tokenService.disableToken(token);
        return ResultGenerate.success();
    }

    @RequestMapping("/checkLogin")
    public Result checkLogin(@RequestParam("token") String token) {
        TokenUserVo userToken = tokenService.getTokenUser(token);
        if (userToken == null || userToken.getDisable() == 1) {
            return ResultGenerate.fail("登录token不存在");
        }
        User user = userToken.getUser();
        long tokenExpired = TokenUtils.isTokenExpired(userToken);
        logger.debug("checkLogin ==> 用户: {}(id: {}) 剩余过期时间: {} min", user.getUsername(), user.getId(), tokenExpired);
        if (tokenExpired <= 0) {
            return ResultGenerate.fail("登录过期, 请重新登录");
        } else if (tokenExpired < (userToken.getExpireMinute() / 2)) {
            tokenService.updateTokenUpdateTime(userToken.getId(), LocalDateTime.now());
            logger.debug("checkLogin ==> 用户: {}(id: {}) 更新updateTime", user.getUsername(), user.getId());
        }
        return ResultGenerate.success(user);
    }
}
