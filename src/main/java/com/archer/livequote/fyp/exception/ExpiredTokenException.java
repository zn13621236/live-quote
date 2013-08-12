package com.archer.livequote.fyp.exception;

/**
 * @author: ayang
 */
public class ExpiredTokenException extends InvalidTokenException {
    public ExpiredTokenException(String message) {
        super(message);
    }

    public ExpiredTokenException(Exception e) {
        super(e);
    }
}
