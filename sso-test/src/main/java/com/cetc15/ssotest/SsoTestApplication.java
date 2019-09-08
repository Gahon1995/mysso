package com.cetc15.ssotest;

import com.gahon.sso.client.config.EnableSsoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableSsoClient
public class SsoTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoTestApplication.class, args);
    }

}
