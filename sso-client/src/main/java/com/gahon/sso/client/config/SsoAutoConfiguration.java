package com.gahon.sso.client.config;

/**
 * @author Gahon
 * @date 2019/9/6
 */
// 定义 java 配置类

import com.gahon.sso.client.interceptor.SsoInterceptor;
import com.gahon.sso.client.properties.SsoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//// 相当于一个普通的 java 配置类
//@Configuration
//// 将 application.properties 的相关的属性字段与该类一一对应，并生成 Bean
//@EnableConfigurationProperties(SsoProperties.class)
public class SsoAutoConfiguration {

//    public SsoAutoConfiguration() {
//        System.out.println("init SsoAutoConfiguration");
//    }
//
//    @Autowired
//    SsoProperties ssoProperties;
//
//    @Bean
////    @ConditionalOnMissingBean(SsoInterceptor.class)
//    public SsoInterceptor ssoInterceptor(){
//        System.out.println("init ssoInterceptor");
//        return new SsoInterceptor(ssoProperties);
//    }

}
