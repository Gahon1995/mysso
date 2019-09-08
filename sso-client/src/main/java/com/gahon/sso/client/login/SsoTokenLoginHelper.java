package com.gahon.sso.client.login;


import com.alibaba.fastjson.JSONObject;
import com.gahon.sso.client.model.HttpClientResult;
import com.gahon.sso.client.model.User;
import com.gahon.sso.client.util.HttpClientUtils;
import com.gahon.sso.client.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gahon
 * @date 2019/9/6
 */
public class SsoTokenLoginHelper {
    private static Logger logger = LoggerFactory.getLogger(SsoTokenLoginHelper.class);


    public static User loginCheck(String token, String ssoServer, String checkLoginPath) {
        Map<String, String> map = new HashMap<>(1);
        map.put("token", token);
        try {
            final HttpClientResult httpClientResult = HttpClientUtils.doGet(ssoServer + checkLoginPath, map);
            if (httpClientResult.getCode() != 200) {
                logger.info("请求登录验证失败 ==>  code:{}", httpClientResult.getCode());
                return null;
            }

            final Result<User> model = new Result<>();
            final Result result = JSONObject.parseObject(httpClientResult.getContent(), model.getClass());
            if (result.getCode() != 200) {
                logger.info("用户未登录 ==> code:{}, msg:{}", result.getCode(), result.getMsg());
                return null;
            }

            return JSONObject.parseObject(result.getData().toString(), User.class);

        } catch (Exception e) {
            e.printStackTrace();
            logger.info("验证是否登录出现错误 ==> token:{}, path: {}, exception_info: {}", token, ssoServer + checkLoginPath, e.toString());
            return null;
        }
    }

    public static void logout(String token, String ssoServer, String logoutPath) {
        Map<String, String> map = new HashMap<>(1);
        map.put("token", token);

        try {
            final HttpClientResult logoutResult = HttpClientUtils.doPost(ssoServer + logoutPath, map);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
