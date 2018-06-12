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
 * @Description: 邮件群发核心类
 * @author zijian
 * @date 2018-1-17 下午8:32:41
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
		String username = "tanchang2020@163.com"; //设置一个邮件的发送者 
		//授权码 去邮箱设置看看
		String password = "a6235745"; 
		//发送邮件 邮件传输协议smtp 
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.host", "smtp.163.com");
		properties.put("mail.smtp.auth", true);  //密码验证
		Session session = Session.getInstance(properties);
		//创建邮箱
		MimeMessage ms = new MimeMessage(session);
		try {
			//设置邮件的来源
			Address toAddress = new InternetAddress(username);
			ms.setFrom(toAddress);
			ms.setRecipients(Message.RecipientType.TO, user);
			ms.setSubject(top);
			ms.setText(content);
			ms.saveChanges();//保存
			//创建一个邮件发送工具
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
