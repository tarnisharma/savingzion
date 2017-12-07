package com.saving.zion.fishonindia.config;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

@Configuration
public class MailConfig {

	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setJavaMailProperties(getProperties());
		return mailSender;
	}

	@Bean
	public Session getSession() {
		return Session.getInstance(getProperties(), new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("fishonondia@gmail.com", "wpdzpzxrvjmaolbz");
			}
		});
	}

	private Properties getProperties() {
		final String smtpServer = "smtp.gmail.com";
		final String userAccount = "fishonondia@gmail.com"; // Sender Account.
		final String password = "wpdzpzxrvjmaolbz"; // Password -> Application Specific Password.
		final String SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";
		final String smtpPort = "587";
		final String PORT = "465";

		final Properties props = new Properties();
		props.put("mail.smtp.host", smtpServer);
		props.put("mail.smtp.user", userAccount);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", smtpPort);
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.debug", "false");
		props.put("mail.smtp.socketFactory.port", PORT);
		props.put("mail.smtp.socketFactory.class", SOCKET_FACTORY);
		props.put("mail.smtp.socketFactory.fallback", "false");
		return props;
	}

	@Bean
	public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration() {
		FreeMarkerConfigurationFactoryBean fmConfigFactoryBean = new FreeMarkerConfigurationFactoryBean();
		fmConfigFactoryBean.setTemplateLoaderPath("/templates/");
		return fmConfigFactoryBean;
	}
}