package com.archer.livequote.factory;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;


import com.archer.livequote.constant.Environment;


public class SessionFactory {
	
	public static Session getSession() {
		Session session = Session.getDefaultInstance(Environment.init(),
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(Environment.UserName,
								Environment.PassWord);
					}
				});
		return session;
	}

}
