package com.gahon.sso.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.gahon.sso.core.util.HttpUtils;
import com.gahon.sso.server.model.User;
import com.gahon.sso.server.util.Result;
import com.gahon.sso.server.util.ResultGenerate;
import com.gahon.sso.server.service.TokenService;
import com.gahon.sso.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gahon
 * @date 2019/9/4
 */

@RestController
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @GetMapping("/")
    public String index() {
//        System.out.println("HttpUtils.test() = " + HttpUtils.test());
        logger.info("info", " test");
        logger.debug("debug", " debug test");
        return "Hello Gahon";
    }

    @GetMapping("/user")
    public Result getUser(@RequestParam("id") @Nullable Integer id, @RequestParam("name") @Nullable String name) {
        if (id != null) {
            return ResultGenerate.success(userService.getById(id));
        } else if (!StringUtils.isEmpty(name)) {
            return ResultGenerate.success(userService.getOne(new QueryWrapper<User>().eq("username", name)));
        }
        return ResultGenerate.fail("请传入id或者姓名");
    }

    @GetMapping("/token")
    public Result getToken(@RequestParam("token") @Nullable String token) {
        if (!StringUtils.isEmpty(token)) {
            return ResultGenerate.success(tokenService.getToken(token));
        }
        return ResultGenerate.fail("请传入token");
    }
}
