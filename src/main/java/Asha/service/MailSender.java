package Asha.service;

import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailSender {

    private static Logger log = Logger.getLogger(MailSender.class.getCanonicalName());
	
	private static String FromAddress = "manish9818082706@gmail.com";

	public void send(String reciever_email_id, String subject_line, String message) {
		
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props,null);
		
		try {
			
			 Message msg = new MimeMessage(session);
		      msg.setFrom(new InternetAddress(FromAddress));
		      InternetAddress to = new InternetAddress(reciever_email_id);
		      msg.addRecipient(Message.RecipientType.TO, to);
		      msg.setSubject(subject_line);
		      msg.setText(message);
		      //Transport.send(msg);
		}
		catch(AddressException addressException) {}
		catch(MessagingException messageException) {}
    }
}
