package com.gahon.sso.client.properties;

/**
 * @author Gahon
 * @date 2019/9/6
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SuppressWarnings("ConfigurationProperties")
@ConfigurationProperties(prefix = "sso")
@Data
public class SsoProperties {
    private String ssoServer;
    private String logoutPath;
    private String checkLoginPath;
    private String excludedPaths;
}
