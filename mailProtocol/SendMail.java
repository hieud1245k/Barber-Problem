package mailProtocol;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static String send(String to, String sub, String msg, final String user, final String pass) {
		// create an instance of Properties Class
		Properties props = new Properties();

		/*
		 * Specifies the IP address of your default mail server for e.g if you are using
		 * gmail server as an email sever you will pass smtp.gmail.com as value of
		 * mail.smtp host. As shown here in the code. Change accordingly, if your email
		 * id is not a gmail id
		 */
		// below mentioned mail.smtp.port is optional
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		/*
		 * Pass Properties object(props) and Authenticator object for authentication to
		 * Session instance
		 */

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});

		try {

			/*
			 * Create an instance of MimeMessage, it accept MIME types and headers
			 */

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setContent("<h1>THIS IS FIRST MAIL PROTOCOL</h1><br/>","text/html");
			message.setText(msg);
//			message.setContent("", "");
			/* Transport class is used to deliver the message to the recipients */

			Transport.send(message);
			return "Mail send successfully";
		} catch (Exception e) {
			return e.toString();
		}
	}
}