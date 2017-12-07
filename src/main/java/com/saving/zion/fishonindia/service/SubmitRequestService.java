package com.saving.zion.fishonindia.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.saving.zion.fishonindia.dao.ListingRepository;
import com.saving.zion.fishonindia.dao.RequestSubmissionRepository;
import com.saving.zion.fishonindia.model.Mail;
import com.saving.zion.fishonindia.model.MailContent;
import com.saving.zion.fishonindia.model.RequestSubmission;
import com.saving.zion.fishonindia.model.Response;
import com.saving.zion.fishonindia.util.Timeit;

@Service
public class SubmitRequestService {

	@Autowired
	private RequestSubmissionRepository requestSubmissionRepository;
	@Autowired
	private EmailService mailService;
	@Autowired
	private ListingRepository listingRepository;
	@Autowired
	private Environment env;


	private static final Logger logger = Logger.getLogger(SubmitRequestService.class);
	public Response submitRequest(RequestSubmission requestSubmission) {
		Timeit.timeIt("submitRequest");
		try {
			requestSubmission.setSubmissionId(generateSubmissionId());
			requestSubmissionRepository.save(requestSubmission);
			notify(requestSubmission);
			return new Response(Timeit.timeTaken(), 200, Collections
					.singletonList(Collections.singletonMap("submissionId", requestSubmission.getSubmissionId())));
		} catch (Exception e) {
			return new Response(Timeit.timeTaken(), 500, null, true, Collections.singletonList(e.getMessage()));
		}
	}

	private void notify(RequestSubmission requestSubmission) {
		try {
			MailContent mailContent = new MailContent(requestSubmission,
					listingRepository.findByListingId(requestSubmission.getListingId()));
			notifySZ(mailContent);
			notifyCustomer(mailContent);
		} catch (Exception e) {

		}
	}

	private void notifyCustomer(MailContent mailContent) {
		try {
			Mail mail = new Mail();
			mail.setMailFrom(env.getProperty("customer.mail.from.emailId"));
			mail.setMailSubject(mailContent.getListing().getName() +env.getProperty("customer.mail.subject"));
			mail.setMailTo(mailContent.getRequestSubmission().getUserDetails().getEmailId());
			mail.setMailBcc("fishonindia@gmail.com");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("content", mailContent);
			mail.setModel(model);
			mailService.sendEmail(mail, env.getProperty("customer.mail.template"));
		} catch (Exception e) {
			logger.error(e);
		}
	}

	private void notifySZ(MailContent mailContent) {
		try {
			Mail mail = new Mail();
			mail.setMailFrom("donotreply@fishonindia.com");
			mail.setMailSubject(mailContent.getListing().getName() +env.getProperty("sz.mail.subject"));
			mail.setMailTo("fishonindia@gmail.com");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("content", mailContent);
			mail.setModel(model);
			mailService.sendEmail(mail, env.getProperty("sz.mail.template"));
		} catch (Exception e) {
			logger.error(e);
		}
	}


	private String generateSubmissionId() {
		Long sysTime = System.currentTimeMillis();
		String randomNumber = RandomStringUtils.randomNumeric(5);
		return "FH-" + sysTime + randomNumber;
	}
}
