package com.gahon.sso.server.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Gahon
 * @date 2019/9/5
 */
@Component
@Data
public class SsoConfig {
    @Value("${token.expire.minute}")
    private Integer expireMinute;
}
