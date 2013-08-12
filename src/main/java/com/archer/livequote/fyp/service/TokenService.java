package com.archer.livequote.fyp.service;

import com.archer.livequote.fyp.domain.Token;

/**
 * A URL builder for links with reset password service.
 */
public interface TokenService {
    String build(String username, String guid);

    Token verify(String token, String hash);
}
