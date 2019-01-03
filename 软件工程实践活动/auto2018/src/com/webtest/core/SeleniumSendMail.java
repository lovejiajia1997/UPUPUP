package com.webtest.core;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * author:shisujia
 * 发送邮件类
 */
public class SeleniumSendMail {
//	public WebDriver driver;
//	 
//    public SeleniumSendMail(WebDriver driver) {
//        this.driver = driver;
//    }
	@Test
	public void sendmail() {
		//创建一个Property文件对象
		Properties props = new Properties();
 
		// 设置邮件服务器的信息，这里设置smtp主机名称
		props.put("mail.smtp.host", "smtp.126.com");
 
		// 设置socket factory 的端口
		props.put("mail.smtp.socketFactory.port", "465");
 
		// 设置socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
 
		// 设置需要身份验证
		props.put("mail.smtp.auth", "true");
 
		// 设置SMTP的端口，QQ的smtp端口是25
		props.put("mail.smtp.port", "25");
 
		// 身份验证实现
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
 
			protected PasswordAuthentication getPasswordAuthentication() {
                        // 第二个参数，就是我发送邮件的邮箱开启smtp的授权码
			return new PasswordAuthentication("lovelysujia@126.com", "ssj159357");
 
			}
		});
 
		try {
 
			// 创建一个MimeMessage类的实例对象
			Message message = new MimeMessage(session);
			
			// 设置发件人邮箱地址
			message.setFrom(new InternetAddress("lovelysujia@126.com"));
 
			// 设置收件人邮箱地址
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("1303901763@qq.com"));
            
            // 设置邮件主题
			message.setSubject("WordPress测试报告");
 
			// 创建一个MimeBodyPart的对象，以便添加内容
			BodyPart messageBodyPart1 = new MimeBodyPart();
 
			// 设置邮件正文内容
			messageBodyPart1.setText("您好，这是WordPress最新测试报告，请注意查收");
 
			// 创建另外一个MimeBodyPart对象，以便添加其他内容
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
 
			// 设置邮件中附件文件的路径
			String filename = "D:\\WordPress_UPUP\\WordPress\\wordpress\\test-output\\htmlzip.zip";
 
			// 创建一个datasource对象，并传递文件
			DataSource source = new FileDataSource(filename);
 
			// 设置handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
 
			// 加载文件
			messageBodyPart2.setFileName(filename);
 
			// 创建一个MimeMultipart类的实例对象
			Multipart multipart = new MimeMultipart();
 
			// 添加正文1内容
			multipart.addBodyPart(messageBodyPart1);
 
			// 添加正文2内容
			multipart.addBodyPart(messageBodyPart2);
 
			// 设置内容
			message.setContent(multipart);
 
			// 最终发送邮件
			Transport.send(message);
 
			System.out.println("=====邮件已经发送=====");
 
		} catch (MessagingException e) {
			   throw new RuntimeException(e);
		}
 
	}
	
}
