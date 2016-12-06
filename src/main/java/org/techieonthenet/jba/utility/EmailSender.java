package org.techieonthenet.jba.utility;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class EmailSender{

	@Autowired
	private static JavaMailSender mailSender;
	

	public static void sendEmail(String recipientAddress,String subject,String message) {
		// takes input from e-mail form
		
		
		// prints debug info
		System.out.println("To: " + recipientAddress);
		System.out.println("Subject: " + subject);
		System.out.println("Message: " + message);
		
		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		System.out.println(email.toString());
		// sends the e-mail
		try
		{
			mailSender.send(email);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		// forwards to the view named "Result"
		
	}
	
	public static void main(String args[])
	{
		sendEmail("shwetabh.gaurav@gmail.com","test email","This is a test email");
		
	}
}
