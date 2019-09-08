package com.gahon.sso.client.interceptor;


import com.gahon.sso.client.config.SsoConf;
import com.gahon.sso.client.login.SsoTokenLoginHelper;
import com.gahon.sso.client.model.LoginRequired;
import com.gahon.sso.client.model.User;
import com.gahon.sso.client.properties.SsoProperties;
import com.gahon.sso.client.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Gahon
 * @date 2019/9/6
 */
public class SsoInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(SsoInterceptor.class);

//    @Value("${sso.server}")
    private String ssoServer;
//    @Value("${sso.logout.path}")
    private String logoutPath;
//    @Value("${sso.check-login.path}")
    private String checkLoginPath;
//    @Value("${sso.excluded.paths}")
    private String excludedPaths;

    public SsoInterceptor(SsoProperties ssoProperties){
        this.ssoServer = ssoProperties.getSsoServer();
        this.logoutPath = ssoProperties.getLogoutPath();
        this.checkLoginPath = ssoProperties.getCheckLoginPath();
        this.excludedPaths = ssoProperties.getExcludedPaths();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
        if (loginRequired != null && !loginRequired.value()) {
            return true;
        }

        final String servletPath = request.getServletPath();
        logger.debug("SsoTokenFilter ==> servletPath: {}", servletPath);

//        判断当前地址是否在免登陆地址中
        if (excludedPaths != null && excludedPaths.trim().length() > 0) {
            final String[] split = excludedPaths.trim().split(",");
            if (Arrays.binarySearch(split, servletPath) >= 0) {
                logger.debug("跳过当前请求 ==> path: {}", servletPath);
                return true;
            }
        }

        String token = request.getHeader(SsoConf.SSO_TOKEN);
        logger.debug("token ==> {}", token);

        // 判断是否是退出登录请求
        if (logoutPath != null
                && logoutPath.trim().length() > 0
                && logoutPath.equals(servletPath)) {

            // logout
            SsoTokenLoginHelper.logout(token, ssoServer, logoutPath);

            // response
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().println("{\"code\":" + Result.SUCCESS_CODE + ", \"msg\":\"\"}");

            return true;
        }

        // 检查是否登录
        User user = SsoTokenLoginHelper.loginCheck(token, ssoServer, checkLoginPath);
        if (user == null) {
//            用户未登录
            // 修改response，直接返回
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().println("{\"code\":" + SsoConf.SSO_LOGIN_FAIL_RESULT.getCode() + ", \"msg\":\"" + SsoConf.SSO_LOGIN_FAIL_RESULT.getMsg() + "\"}");
            return false;
        }

        logger.debug("验证通过");
        // 将用户ID放入request中
        request.setAttribute(SsoConf.SSO_USER, user);

        return true;
    }
}
