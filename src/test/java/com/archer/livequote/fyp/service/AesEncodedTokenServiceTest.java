package com.archer.livequote.fyp.service;

import com.archer.livequote.fyp.domain.Token;
import com.archer.livequote.fyp.exception.InvalidTokenException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: ayang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/ApplicationContext.xml"})
public class AesEncodedTokenServiceTest {
    private static Logger logger = LoggerFactory.getLogger(AesEncodedTokenServiceTest.class);
    @Autowired
    private TokenService tokenService;

    @Test
    public void testBuild() throws Exception {
        String url = tokenService.build("a@real.com", "1");
        logger.info(url);
    }

    @Test
    public void testVerify() throws Exception {
        Token token = tokenService.verify("X1CsTnBezVbUKpwuHnk68oYuLY6IC+feUg42jKXohQHQLaYPjfKwGUTY/xZb61a1H4WVK1c6AzGTOQ4sA7hq6q+I7tSeNhoejBRuLanQ9es=", "27c4c7f6bf5b874254d4b58a85242789");
        Assert.assertEquals(token.getUsername(), "a@real.com");
        Assert.assertEquals(token.getGuid(), "1");
        Assert.assertEquals(token.getTimestamp(), 1376264730452L);
    }

    @Test(expected = InvalidTokenException.class)
    public void testInvalidTokenVerify() throws Exception {
        tokenService.verify("abcde", "06a697d0ba7753d424bd70c9a26da576");
    }
}
