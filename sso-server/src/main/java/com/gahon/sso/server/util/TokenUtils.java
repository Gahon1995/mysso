package com.gahon.sso.server.util;

import com.gahon.sso.server.model.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Gahon
 * @date 2019/9/5
 */
public class TokenUtils {

    private static Logger logger = LoggerFactory.getLogger(TokenUtils.class);

    public static String genToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 判断当前token是否已经过期
     *
     * @param token 需要进行判断的token对象
     * @return 过期时间与当前时间相差的分钟数，已经过期了返回的负值
     */
    public static long isTokenExpired(Token token) {
        if (StringUtils.isEmpty(token)) {
            return 0;
        }
        Integer expireMinute = token.getExpireMinute();
        LocalDateTime updateTime = token.getUpdateTime();
        LocalDateTime expireDateTime = updateTime.plusMinutes(expireMinute);
        LocalDateTime now = LocalDateTime.now();
//        logger.debug("现在时间: {}", now);
//        logger.debug("Token更新时间: {}", updateTime);
//        logger.debug("Token过期时间: {}", expireDateTime);
        return Duration.between(now, expireDateTime).toMinutes();
    }

}
