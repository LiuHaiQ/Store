package cn.itcast.store.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

// 文件名 SendEmail.java

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {

	public static void sendMail(String email, String emailMsg) {
		try {
			// 创建Properties 类用于记录邮箱的一些属性
			final Properties props = new Properties();
			// 表示SMTP发送邮件，必须进行身份验证
			props.put("mail.smtp.auth", "true");
			// 此处填写SMTP服务器
			props.put("mail.smtp.host", "smtp.qq.com");
			// 端口号，QQ邮箱给出了两个端口，但是另一个我一直使用不了，所以就给出这一个587
			props.put("mail.smtp.port", "587");
			// 此处填写你的账号
			props.put("mail.user", "1066165692@qq.com");
			// 此处的密码就是前面说的16位STMP口令
			props.put("mail.password", "oheomezpepaqbdhe");
			// 构建授权信息，用于进行SMTP进行身份验证
			Authenticator authenticator = new Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					// 用户名、密码
					String userName = props.getProperty("1066165692@qq.com");
					String password = props.getProperty("oheomezpepaqbdhe");
					return new PasswordAuthentication(userName, password);
				}
			};
			// 使用环境属性和授权信息，创建邮件会话
			Session mailSession = Session.getInstance(props, authenticator);
			// 创建邮件消息
			MimeMessage message = new MimeMessage(mailSession);
			// 设置发件人
			InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
			message.setFrom(form);

			// 设置收件人的邮箱
			InternetAddress to = new InternetAddress(email);
			message.setRecipient(RecipientType.TO, to);

			// 设置邮件标题
			message.setSubject("购物激活");
			// html文件
		long currentTime= System.currentTimeMillis();
			SimpleDateFormat format=new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");
			Date date=new Date(currentTime);
			
			StringBuilder sb = new StringBuilder();
			sb.append("<html>");
			sb.append("<head>");
			sb.append("<title>xxx</title>");
			sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
			sb.append("<style type=\"text/css\">");
			sb.append(
					".post {margin-bottom: 20px;background: #5BCE9E;}.title {padding: 5px 20px;}.posted {padding: 0 0 0 20px;font-size: small;}.story {padding: 20px;}.meta {height: 60px;padding: 40px 0 0 0;}.meta p {margin: 0;padding: 0 20px 0 0;	text-align: right;}");
			sb.append("</style>");
			sb.append("</head>");
			sb.append("<body>");
			sb.append("<div>");
			sb.append("<div class=\"post\">");
			sb.append("<h2 class=\"title\">阿海</h2>");
			sb.append("<h3 class=\"posted\">这是一条来自阿海系统的测试邮件</h3>");
			sb.append("<div class=\"story\">" + "http://localhost:8080/Sore_v1.1/UserServlet?method=activeUser&code="+ emailMsg + "</div>");
			sb.append("<div class=\"meta\"><p>" + format.format(date) + "</p></div>");
			sb.append("</div>");
			sb.append("</div>");
			sb.append("</body>");
			sb.append("</html>");

			// 设置邮件的内容体
			message.setContent(sb.toString(), "text/html;charset=UTF-8");

			// 最后当然就是发送邮件啦
			Transport.send(message);
			System.out.println("okok");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}