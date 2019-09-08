package com.gahon.sso.client.config;


import com.gahon.sso.client.util.Result;

/**
 * @author Gahon
 * @date 2019/9/5
 */
public class SsoConf {
    /**
     * sso sessionid, between browser and sso-server (web + token client)
     */
    public static final String SSO_TOKEN = "sso_token";


    /**
     * redirect url (web client)
     */
    public static final String REDIRECT_URL = "redirect_url";

    /**
     * sso user, request attribute (web client)
     */
    public static final String SSO_USER = "sso_user";


    /**
     * sso server address (web + token client)
     */
    public static final String SSO_SERVER = "sso_server";

    /**
     * login url, server relative path (web client)
     */
    public static final String SSO_LOGIN = "/login";
    /**
     * logout url, server relative path (web client)
     */
    public static final String SSO_LOGOUT = "/logout";


    /**
     * logout path, client relatice path
     */
    public static final String SSO_LOGOUT_PATH = "SSO_LOGOUT_PATH";
    /**
     * logout path, client relatice path
     */
    public static final String SSO_CHECK_LOGIN_PATH = "SSO_CHECK_LOGIN_PATH";

    /**
     * excluded paths, client relatice path, include path can be set by "filter-mapping"
     */
    public static final String SSO_EXCLUDED_PATHS = "SSO_EXCLUDED_PATHS";

    /**
     * login fail result
     */
    public static final Result<String> SSO_LOGIN_FAIL_RESULT = new Result<>(501, "sso not login.");
}
