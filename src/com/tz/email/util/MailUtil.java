package com.tz.email.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: MailUtil
 * @Description: �ʼ�Ⱥ��������
 * @author zijian
 * @date 2018-1-17 ����8:32:41
 */
@WebServlet(urlPatterns="/mail")
public class MailUtil extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String user = request.getParameter("m-name");
		String top = request.getParameter("m-topci");
		String content = request.getParameter("m-con");
		String username = "tanchang2020@163.com"; //����һ���ʼ��ķ����� 
		//��Ȩ�� ȥ�������ÿ���
		String password = "a6235745"; 
		//�����ʼ� �ʼ�����Э��smtp 
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.host", "smtp.163.com");
		properties.put("mail.smtp.auth", true);  //������֤
		Session session = Session.getInstance(properties);
		//��������
		MimeMessage ms = new MimeMessage(session);
		try {
			//�����ʼ�����Դ
			Address toAddress = new InternetAddress(username);
			ms.setFrom(toAddress);
			ms.setRecipients(Message.RecipientType.TO, user);
			ms.setSubject(top);
			ms.setText(content);
			ms.saveChanges();//����
			//����һ���ʼ����͹���
			Transport ts = session.getTransport();
			ts.connect(username,password);
			ts.sendMessage(ms, ms.getAllRecipients());
			ts.close();
			PrintWriter pw = response.getWriter();
			pw.print("111");
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public static void main(String[] args) {
		
	}
	
}
