package com.archer.livequote.email.service;

import java.util.Locale;
import java.util.Map;

/**
 * @author Aaron Yang
 */
public interface EmailService {

    public void sendEmail(String template, String[] to, Map<String, Object> parameters);

    public void sendEmail(String template, final String[] to, final Map<String, Object> parameters, Locale locale);

    public void sendEmail(String from, String subject, String content, final String[] to, boolean html);

}
