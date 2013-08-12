package com.archer.livequote.fyp.util;

import com.google.common.base.Charsets;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.encrypt.BytesEncryptor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author ayang
 */
public class EncryptUtils {

    private final static String DEFAULT_CHARSET = "UTF-8";

    /**
     * @param text
     * @param text
     * @return
     */
    public static String encryptText(BytesEncryptor encryptor, String text) {
        byte[] encodedText = encryptor.encrypt(text.getBytes(Charsets.UTF_8));
        return new String(Base64.encode(encodedText), Charsets.UTF_8);
    }

    /**
     * @param text
     * @param text
     * @return
     */
    public static String decryptText(BytesEncryptor encryptor, String text) {
        byte[] decodedText = encryptor.decrypt(Base64.decode(text.getBytes(Charsets.UTF_8)));
        return new String(decodedText, Charsets.UTF_8);
    }

    /**
     * wrapper of URLEncoder.encode(), it handles null value.
     *
     * @param str
     * @return
     * @throws java.io.UnsupportedEncodingException
     *
     */
    public static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, Charsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }
}
