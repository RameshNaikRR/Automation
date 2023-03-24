package CommonEmail;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {

	public static void main(String[] args) throws IOException {

		System.out.println("Test Started");
		senddEmail("messAGE", "to", "subject", "body");
	}

	public static void senddEmail(String message, String to, String subject, String body) throws IOException {
		final String username = "tarakaramudumareddy@gmail.com";
		final String password = "qoboimlevethdhyu";
		String fromEmail = "tarakaramudumareddy@gmail.com";
		String toEmail = "tarakam@ideyalabs.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// create email message
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress());
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("Sample Extent Report");
			//Sending Email Messages - MimeMultiPart
			MimeMultipart multipart = new MimeMultipart();
			MimeBodyPart msgBodypart = new MimeBodyPart();
			msgBodypart.setText(
					"Hi Team, \nHere is the Test execution results attached in extent report \n\nThanks and Regards \nTaraka M");
			MimeBodyPart attachBodypart = new MimeBodyPart();
			String path = "./ExtentReports/ExtentReport.html";
			File file = new File(path);
			attachBodypart.attachFile(file);
			multipart.addBodyPart(attachBodypart);
			multipart.addBodyPart(msgBodypart);
			msg.setContent(multipart);

			Transport.send(msg);
			System.out.println("Test ended");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}