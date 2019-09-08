package com.cetc15.ssotest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gahon
 * @date 2019/9/6
 */
@RestController
public class HelloControoler {

    @RequestMapping("/")
    public String sayHello() {
        return "hello";
    }
}
