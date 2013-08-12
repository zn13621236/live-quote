package com.archer.livequote.fyp.service;

import com.archer.livequote.fyp.domain.Token;
import com.archer.livequote.fyp.exception.ExpiredTokenException;
import com.archer.livequote.fyp.exception.FypException;
import com.archer.livequote.fyp.exception.InvalidTokenException;
import com.archer.livequote.fyp.util.EncryptUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.concurrent.TimeUnit;

import static com.archer.livequote.fyp.util.EncryptUtils.urlEncode;
import static com.archer.livequote.util.Constants.*;


/**
 * A URL builder for links with reset password service.
 *
 * @author Aaron Yang
 */
@Component
public class AesEncodedTokenService implements TokenService, InitializingBean {
    private static Logger logger = LoggerFactory.getLogger(AesEncodedTokenService.class);

    @Value("${fyp.token.expiration}")
    private long tokenExpiration = 86400;

    @Value("${fyp.token.private.key}")
    private String privateKey;

    @Value("${fyp.token.private.salt}")
    private String salt;

    @Value("${fyp.url}")
    private String baseUrl;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Md5PasswordEncoder md5PasswordEncoder;

    private BytesEncryptor bytesEncryptor;

    private String build(Token token) {
        logger.info("Fyp token is {}", token);
        Stopwatch stopwatch = new Stopwatch().start();
        try {
            String json = objectMapper.writeValueAsString(token);
            String encodedToken = EncryptUtils.encryptText(bytesEncryptor, json);
            String hashedToken = md5PasswordEncoder.encodePassword(encodedToken, salt);
            logger.info("Encoded token is '{}' and hash is '{}'", encodedToken, hashedToken);
            StringBuilder sb = new StringBuilder(baseUrl).append(QUESTION_MARK);
            sb.append(PARAM_TOKEN).append(EQ).append(urlEncode(encodedToken)).append(AND).append(PARAM_HASH).append(EQ);
            sb.append(urlEncode(hashedToken));
            return sb.toString();
        } catch (JsonProcessingException e) {
            throw new FypException(e);
        } finally {
            logger.info("Build fyp url takes {} milliseconds", stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
        }
    }

    public String build(String username, String guid) {
        return build(new Token(username, guid));
    }

    @Override
    public Token verify(String encodedToken, String hash) {
        Stopwatch stopwatch = new Stopwatch().start();
        String hashedToken = md5PasswordEncoder.encodePassword(encodedToken, salt);
        if (hashedToken.equals(hash)) {
            try {
                String json = EncryptUtils.decryptText(bytesEncryptor, encodedToken);
                Token token = objectMapper.readValue(json, Token.class);
                logger.info("Fyp token is {}", token);
                if (!token.isExpired(tokenExpiration)) {
                    return token;
                } else {
                    throw new ExpiredTokenException("Token is expired");
                }
            } catch (Exception e) {
                throw new InvalidTokenException(e);
            } finally {
                logger.info("Verify fyp url takes {} milliseconds", stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
            }
        }
        throw new InvalidTokenException("Token was changed by man in middle");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.isTrue(tokenExpiration > 0, "Token expiration must be larger than 0");
        Assert.hasText(baseUrl, "Fyp url must be specified");
        Assert.hasText(privateKey, "AES private key must be specified");
        Assert.hasText(salt, "Salt must be specified");
        bytesEncryptor = Encryptors.standard(privateKey, salt);
    }
}
