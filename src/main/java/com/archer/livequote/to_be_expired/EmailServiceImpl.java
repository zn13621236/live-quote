package com.archer.livequote.to_be_expired;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.archer.livequote.dao.CompanyDao;
import com.archer.livequote.factory.SessionFactory;

@Service("emailService")
public class EmailServiceImpl implements EmailService{

	@Autowired
	CompanyDao cdao;
	@Autowired
	SessionFactory sessionFactory;
	@Value("${mail.username}")
	String userName;
	
	
	@Async
	@Override
	public boolean sendEmail(EmailTemplate eTemplate) {
         
		try {
			Message message = setMessage(eTemplate);
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Message setMessage(EmailTemplate eTemplate) {
		Message message = new MimeMessage(sessionFactory.getSession());
		try {
			message.setFrom(new InternetAddress(userName));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(eTemplate.getToEmails()));
			message.setSubject(eTemplate.getSubject());
			message.setText(eTemplate.getText());
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return message;
	}

}
