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

	String protocol = "smtp"; // ������
	String from = "admin@dc-hint.cn";// �����ˣ�������Ը�Ϊ��������ַ
	String to = "wangx@dc-hint.cn";// �����ˣ���Ϊ��Ҫ�ĸ����˵������ַ ����������Լ���QQ��������
	String subject = "Java�����ʼ�����!";// �ʼ�����
	String body = "<a href=http://www.qq.com>qq.com" + "</a><br><img src=\"cid:8.jpg\">";// �ʼ����� ����һ��HTTP��ҳ����ʼ�����

	public static void main (String args []) throws Exception{
		String server = "smtp.exmail.qq.com";// QQ����ķ�������������������������������������Լ�ȥ�飬������QQ����Ϊ��
		String user = "admin@dc-hint.cn";// ��¼������û�������˵����QQ���䣬�Ǿ�д���¼QQ������ʺ�
		String pass = "Passw0rd";// ��¼����
		EmailSender sender = new EmailSender();
		Session session = sender.createSession();
		MimeMessage message = sender.createMessage(session);
		System.out.println("���ڷ����ʼ�...");
		Transport transport = session.getTransport();
		transport.connect(server, user, pass);
		transport.sendMessage(message,message.getRecipients(Message.RecipientType.TO));
		transport.close();
		System.out.println("���ͳɹ�!!!");
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
		// ������
		//MimeBodyPart gifBodyPart = new MimeBodyPart();
		//FileDataSource fds = new FileDataSource("f:\\����.MP3");// F���µ� ����.MP3
																// �ļ������￴�������
		//gifBodyPart.setDataHandler(new DataHandler(fds));
		//gifBodyPart.setContentID("����.MP3");
		//multipart.addBodyPart(gifBodyPart);
		message.setContent(multipart);
		message.saveChanges();
		return message;
	}
}

// PS����java�����ʼ��ĵ����JAR���ϴ��ˣ���ѹ���������Ŀ��Ϳ�