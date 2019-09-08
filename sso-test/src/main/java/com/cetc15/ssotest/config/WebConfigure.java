//package com.cetc15.ssotest.config;
//
//import com.gahon.sso.client.interceptor.SsoInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @author Gahon
// * @date 2019/9/6
// */
//@Configuration
//public class WebConfigure implements WebMvcConfigurer {
////    @Bean
////    public SsoInterceptor ssoInterceptor() {
////        return new SsoInterceptor();
////    }
//
//    @Autowired
//    SsoInterceptor ssoInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(ssoInterceptor).addPathPatterns("/**");
//    }
//}
