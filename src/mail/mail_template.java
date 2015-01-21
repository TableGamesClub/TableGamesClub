package mail;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class mail_template {	
	 void sendmail(String mail,String header,String text) throws NoSuchProviderException{
		 	String host = "smtp.gmail.com";
			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.socketFactory.port", 465);
			props.put("mail.smtp.starttls.enable","true");    
		    
		    Session session = Session.getInstance(props, null);
		    MimeBodyPart textPart = new MimeBodyPart();
		    try {
		        MimeMessage msg = new MimeMessage(session);
		        msg.setSubject(header);
		        StringBuffer html = new StringBuffer();
		        html.append("<!DOCTYPE html");
		        html.append("<html>");
		        html.append("<head>");
		        html.append("</head>");
		        html.append("<body>");
		        html.append(text);
		        html.append("<br>");
		        html.append("<img src='C:/BoardGameClub/workspace/TableGamesClub/WebContent/res/bo.jpg'>");
		        html.append("</body></html>");
//	            html.append("<h2>這是第一行</h2><br>");
//	            html.append("<h3>這是第二行</h3><br>");
//	            html.append("<img src='cid:image'><br>");
	            textPart.setContent(html.toString(), "text/html; charset=UTF-8");
	            
	            MimeBodyPart picturePart = new MimeBodyPart();
	            FileDataSource fds = new FileDataSource("C:/BoardGameClub/workspace/TableGamesClub/WebContent/res/test.txt");
	            picturePart.setDataHandler(new DataHandler(fds));
	            picturePart.setFileName(fds.getName());
	            picturePart.setHeader("Content-ID", "<image>");
	            
	            
	            
	            Multipart email = new MimeMultipart();
	            email.addBodyPart(textPart);
	            email.addBodyPart(picturePart);
	            msg.setContent(email);
		        
		        
//		        msg.setFrom("English");
		        msg.setRecipients(Message.RecipientType.TO,mail);
		        msg.setSentDate(new Date());
		        Transport.send(msg, "eeit76@gmail.com", "changeMe");
		        
		    } catch (MessagingException mex) {
		        System.out.println("send failed, exception: " + mex);
		    }

	}
		
	public static void main(String[] args) {
		mail_template t1 = new mail_template();
		try {
			t1.sendmail("spadem45420@gmail.com","系統通知信件","親愛的用戶你好，使用者[小智]已退團。");
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
		}
	}
}

