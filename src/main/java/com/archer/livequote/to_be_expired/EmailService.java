package com.archer.livequote.to_be_expired;

import javax.mail.Message;

import com.archer.livequote.dto.EmailTemplate;

public interface EmailService {

	 boolean sendEmail(EmailTemplate eTemplate);

	Message setMessage(EmailTemplate eTemplate);

	
	
	
}
