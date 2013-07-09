package com.archer.livequote.to_be_expired;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.archer.livequote.to_be_expired.Environment;

@Component
public class SessionFactory {
    @Value(value = "${mail.username}")
     String userName;

    @Value(value = "${mail.password}")
     String passWord;

    public  Session getSession() {
	Session session = Session.getDefaultInstance(Environment.init(),
		new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(userName, passWord);
		    }
		});
	
	System.out.println("user name :"+userName);
	System.out.println("password :=="+ passWord);
	return session;
    }

}
