package com.gahon.sso.client.config;

import com.gahon.sso.client.interceptor.SsoInterceptor;
import com.gahon.sso.client.properties.SsoProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Gahon
 * @date 2019/9/6
 */
@Configuration
@EnableConfigurationProperties(SsoProperties.class)
public class WebConfigure implements WebMvcConfigurer {
    private Logger logger = LoggerFactory.getLogger(WebConfigure.class);
    public WebConfigure() {
        logger.info("启用登录验证");
    }

    @Autowired
    SsoProperties ssoProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SsoInterceptor(ssoProperties)).addPathPatterns("/**");
    }
}
