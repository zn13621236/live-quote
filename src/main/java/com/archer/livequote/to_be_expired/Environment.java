package com.archer.livequote.to_be_expired;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;


public class Environment {

	public static Properties props;
	public static String SmtpHost;
	public static String SmtpSocketFactoryClass;
	public static String SmtpSocketFactoryPort;
	public static String SmtpAuth;
	public static String SmtpPort;
	public static String UserName;
	public static String PassWord;
	public static String MongoHost;
	public static int MongoPort;
	public static String DBName;
	
	static {
		props = new Properties();
		try {
		    String inputFile1 = "email.properties";
		        ClassPathResource inputSource = new ClassPathResource(inputFile1);
		        String inputFileLocation = inputSource.getFile().getAbsolutePath();
			props.load(new FileInputStream(inputFileLocation));
			String inputFile2 = "db.properties";
			inputSource = new ClassPathResource(inputFile2);
		        inputFileLocation = inputSource.getFile().getAbsolutePath();
			props.load(new FileInputStream(inputFileLocation));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Environment.SmtpHost = props.getProperty("mail.smtp.host");
		Environment.SmtpSocketFactoryClass = props
				.getProperty("mail.smtp.socketFactory.class");
		Environment.SmtpSocketFactoryPort = props
				.getProperty("mail.smtp.socketFactory.port");
		Environment.SmtpAuth = props.getProperty("mail.smtp.auth");
		Environment.SmtpPort = props.getProperty("mail.smtp.port");
		Environment.UserName = props.getProperty("mail.username");
		Environment.PassWord = props.getProperty("mail.password");
		Environment.MongoHost = props.getProperty("mongo.host");
		//Environment.MongoPort = props.getProperty("mongo.port");
		Environment.DBName = props.getProperty("mongo.db");
	}

	public static Properties init() {

		return props;
	}
}
