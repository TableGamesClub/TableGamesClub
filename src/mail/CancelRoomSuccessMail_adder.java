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

public class CancelRoomSuccessMail_adder extends Thread{
	
	String mail = "";
	String header = "";
	String text = "";
	
	public CancelRoomSuccessMail_adder(String mail,String header,String text){
		this.mail = mail;
		this.header = header;
		this.text = text;
	}
	
	@Override
	public void run() {
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
	        html.append("<hr>");
	        html.append("<img src='cid:image'>");
	        html.append("</body></html>");
//	            html.append("<h2>這是第一行</h2><br>");
//	            html.append("<h3>這是第二行</h3><br>");
//	            html.append("<img src='cid:image'><br>");
            textPart.setContent(html.toString(), "text/html; charset=UTF-8");
            
            MimeBodyPart picturePart = new MimeBodyPart();
            FileDataSource fds = new FileDataSource("src/mail/bo.jpg");
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
	        
	        System.out.println("寄發信件成功！");
	        
	    } catch (MessagingException mex) {
	        System.out.println("send failed, exception: " + mex);
	    }
	}

	public void sendmail(String mail,String header,String text) throws NoSuchProviderException{
//		 	String host = "smtp.gmail.com";
//			Properties props = new Properties();
//			props.put("mail.smtp.host", host);
//			props.put("mail.smtp.auth", "true");
//			props.put("mail.smtp.socketFactory.port", 465);
//			props.put("mail.smtp.starttls.enable","true");    
//		    
//		    Session session = Session.getInstance(props, null);
//		    MimeBodyPart textPart = new MimeBodyPart();
//		    try {
//		        MimeMessage msg = new MimeMessage(session);
//		        msg.setSubject(header);
//		        StringBuffer html = new StringBuffer();
//		        html.append("<!DOCTYPE html");
//		        html.append("<html>");
//		        html.append("<head>");
//		        html.append("</head>");
//		        html.append("<body>");
//		        html.append(text);
//		        html.append("<hr>");
//		        html.append("<img src='cid:image'>");
//		        html.append("</body></html>");
//	//	            html.append("<h2>這是第一行</h2><br>");
//	//	            html.append("<h3>這是第二行</h3><br>");
//	//	            html.append("<img src='cid:image'><br>");
//	            textPart.setContent(html.toString(), "text/html; charset=UTF-8");
//	            
//	            MimeBodyPart picturePart = new MimeBodyPart();
//	            FileDataSource fds = new FileDataSource("C:/BoardGameClub/workspace/TableGamesClub/WebContent/res/bo.jpg");
//	            picturePart.setDataHandler(new DataHandler(fds));
//	            picturePart.setFileName(fds.getName());
//	            picturePart.setHeader("Content-ID", "<image>");
//	            
//	            
//	            
//	            Multipart email = new MimeMultipart();
//	            email.addBodyPart(textPart);
//	            email.addBodyPart(picturePart);
//	            msg.setContent(email);
//		        
//		        
//	//		        msg.setFrom("English");
//		        msg.setRecipients(Message.RecipientType.TO,mail);
//		        msg.setSentDate(new Date());
//		        Transport.send(msg, "eeit76@gmail.com", "changeMe");
//		        
//		        System.out.println("寄發信件成功！");
//		        
//		    } catch (MessagingException mex) {
//		        System.out.println("send failed, exception: " + mex);
//		    }
	
	}
		
	public static void main(String[] args) {
		CancelRoomSuccessMail_adder t1 = new CancelRoomSuccessMail_adder("spadem45420@gmail.com","系統通知信件","親愛的用戶你好，使用者[小智]已退團。");
		t1.start();
		System.out.println(456);
	}
}

