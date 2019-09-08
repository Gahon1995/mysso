package com.gahon.sso.server;

import com.gahon.sso.server.model.Token;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsoDemoApplicationTests {

    Logger logger = LoggerFactory.getLogger(SsoDemoApplicationTests.class);

    @Test
    public void contextLoads() {
    }

    @Test
    public void tokenTest() {
        Token token = new Token();
        logger.info(token.toString());

    }

    @Test
    public void testDate() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = LocalDateTime.now().minusMinutes(1440);
        System.out.println("now = " + now);
        System.out.println("localDateTime = " + localDateTime);
        long l = Duration.between(now, localDateTime).toMinutes();
        System.out.println(l);

    }

}
