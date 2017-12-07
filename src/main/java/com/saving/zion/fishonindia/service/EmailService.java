package com.saving.zion.fishonindia.service;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.saving.zion.fishonindia.model.Mail;

import freemarker.template.Configuration;;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	@Qualifier("freeMarkerConfiguration")
	private Configuration fmConfiguration;

	private static final Logger logger = Logger.getLogger(EmailService.class);

	public void sendEmail(Mail mail, String emailTemplate) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(mail.getMailSubject());
			mimeMessageHelper.setFrom(mail.getMailFrom());
			mimeMessageHelper.setTo(mail.getMailTo());
			mail.setMailContent(getContentFromTemplate(mail.getModel(), emailTemplate));
			logger.debug(mail.getMailContent());
			mimeMessageHelper.setText(mail.getMailContent(), true);
			mailSender.send(mimeMessageHelper.getMimeMessage());
		} catch (MessagingException e) {
			logger.error(e);
		}
	}

	public String getContentFromTemplate(Map<String, Object> model, String emailTemplate) {
		StringBuffer content = new StringBuffer();

		try {
			content.append(FreeMarkerTemplateUtils.processTemplateIntoString(fmConfiguration.getTemplate(emailTemplate),
					model));
		} catch (Exception e) {
			logger.error(e);
		}
		return content.toString();
	}
}