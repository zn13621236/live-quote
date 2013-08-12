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
        Token token = tokenService.verify("4KdBlquI5Y/O51BGD0jMR34ohQkdaT5cr1YAvHDDAocnFcywnnLq2hkoNll5ubVEn97ZaB/5JnPoMgPHJ2C7M+q6sJzil5XRAiAcf+60GFc=", "3cbe78507ada85290eea037bf306923f");
        Assert.assertEquals(token.getUsername(), "a@real.com");
        Assert.assertEquals(token.getGuid(), "1");
        Assert.assertEquals(token.getTimestamp(), 1376344278986L);
    }

    @Test(expected = InvalidTokenException.class)
    public void testInvalidTokenVerify() throws Exception {
        tokenService.verify("abcde", "3cbe78507ada85290eea037bf306923f");
    }
}
