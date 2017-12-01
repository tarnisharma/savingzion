package com.saving.zion.fishonindia.service;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.saving.zion.fishonindia.model.Mail;

import freemarker.template.Configuration;;

@Service
public class EMailService {
	@Autowired
	JavaMailSender mailSender;

	@Autowired @Qualifier("freeMarkerConfiguration")
	Configuration fmConfiguration;

	public void sendEmail(Mail mail,String emailTemplate) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		try {

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

			mimeMessageHelper.setSubject(mail.getMailSubject());
			mimeMessageHelper.setFrom(mail.getMailFrom());
			mimeMessageHelper.setTo(mail.getMailTo());
			mail.setMailContent(getContentFromTemplate(mail.getModel(), emailTemplate));
			System.out.println(mail.getMailContent());
			mimeMessageHelper.setText(mail.getMailContent(), true);
			mailSender.send(mimeMessageHelper.getMimeMessage());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public String getContentFromTemplate(Map < String, Object > model,  String emailTemplate) {
        StringBuffer content = new StringBuffer();
 
        try {
        	 content.append(FreeMarkerTemplateUtils
                     .processTemplateIntoString(fmConfiguration.getTemplate(emailTemplate), model));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
}
}