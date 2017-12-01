package com.saving.zion.fishonindia.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
	RequestSubmissionRepository requestSubmissionRepository;
	@Autowired
	EMailService mailService;
	@Autowired
	ListingRepository listingRepository;

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
			mail.setMailFrom("fishonindia@gmail.com");
			mail.setMailSubject(mailContent.getListing().getName() +" | FishOnIndia Request Submission Confirmation");
			mail.setMailTo(mailContent.getRequestSubmission().getUserDetails().getEmailId());
			mail.setMailBcc("fishonindia@gmail.com");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("content", mailContent);
			mail.setModel(model);
			mailService.sendEmail(mail, "CustomerNotificationMail.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void notifySZ(MailContent mailContent) {
		try {
			Mail mail = new Mail();
			mail.setMailFrom("donotreply@fishonindia.com");
			mail.setMailSubject(mailContent.getListing().getName() +"| Request Submission Lead");
			mail.setMailTo("fishonindia@gmail.com");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("content", mailContent);
			mail.setModel(model);
			mailService.sendEmail(mail, "SZNotificationMail.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private String generateSubmissionId() {
		Long sysTime = System.currentTimeMillis();
		String randomNumber = RandomStringUtils.randomNumeric(5);
		return "FH-" + sysTime + randomNumber;
	}
}
