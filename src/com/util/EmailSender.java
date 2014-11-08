package com.util;

import java.util.Properties;

import javax.activation.DataHandler;

import javax.activation.FileDataSource;

import javax.mail.Message;

import javax.mail.Session;

import javax.mail.Transport;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeBodyPart;

import javax.mail.internet.MimeMessage;

import javax.mail.internet.MimeMultipart;

public class EmailSender {

	String protocol = "smtp"; // 服务器
	String from = "admin@dc-hint.cn";// 寄信人，这里可以改为你的邮箱地址
	String to = "wangx@dc-hint.cn";// 收信人，改为你要寄给那人的邮箱地址 建议可以用自己的QQ邮箱试试
	String subject = "Java发送邮件测试!";// 邮件主题
	String body = "<a href=http://www.qq.com>qq.com" + "</a><br><img src=\"cid:8.jpg\">";// 邮件内容 这是一个HTTP网页类的邮件内容

	public static void main (String args []) throws Exception{
		String server = "smtp.exmail.qq.com";// QQ邮箱的服务器，例如新浪邮箱或者其他服务器可以自己去查，这里用QQ邮箱为例
		String user = "admin@dc-hint.cn";// 登录邮箱的用户，不如说你用QQ邮箱，那就写你登录QQ邮箱的帐号
		String pass = "Passw0rd";// 登录密码
		EmailSender sender = new EmailSender();
		Session session = sender.createSession();
		MimeMessage message = sender.createMessage(session);
		System.out.println("正在发送邮件...");
		Transport transport = session.getTransport();
		transport.connect(server, user, pass);
		transport.sendMessage(message,message.getRecipients(Message.RecipientType.TO));
		transport.close();
		System.out.println("发送成功!!!");
	}

	public Session createSession() {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", protocol);
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props);
		// session.setDebug(true);
		return session;
	}

	public MimeMessage createMessage(Session session) throws Exception {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
		message.setSubject(subject);
		MimeMultipart multipart = new MimeMultipart("related");
		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.setContent(body, "text/html;charset=gb2312");
		multipart.addBodyPart(bodyPart);
		// 发附件
		//MimeBodyPart gifBodyPart = new MimeBodyPart();
		//FileDataSource fds = new FileDataSource("f:\\音乐.MP3");// F盘下的 音乐.MP3
																// 文件。这里看个人情况
		//gifBodyPart.setDataHandler(new DataHandler(fds));
		//gifBodyPart.setContentID("音乐.MP3");
		//multipart.addBodyPart(gifBodyPart);
		message.setContent(multipart);
		message.saveChanges();
		return message;
	}
}

// PS：把java发送邮件的导入的JAR包上传了，解压后导入你的项目里就可