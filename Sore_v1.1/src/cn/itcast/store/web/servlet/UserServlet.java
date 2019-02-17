package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import cn.itcast.store.domain.User;
import cn.itcast.store.service.UserService;
import cn.itcast.store.service.serviceImp.UserServiceImpl;
import cn.itcast.store.utils.MailUtils;
import cn.itcast.store.utils.MyBeanUtils;
import cn.itcast.store.utils.UUIDUtils;
import cn.itcast.store.web.base.BaseServlet;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {

	public String registUI(HttpServletRequest req, HttpServletResponse resp) {
		Map<String, String[]> map = req.getParameterMap();
		// 获得所有注册信息
		User user = new User();
		// 用户信息对象
		MyBeanUtils.populate(user, map);
		// 把注册信息存放到User对象
		user.setUid(UUIDUtils.getId());
		// 设置id
		user.setState(0);
		// 设置默认状态
		user.setCode(UUIDUtils.getCode());
		// 设置激活码
		UserService userService = new UserServiceImpl();
		// 调用业务层
		try {
			userService.userRegist(user);
			req.setAttribute("msg", "注册成功");
			MailUtils.sendMail(user.getEmail(), user.getCode());
			// 发邮件

		} catch (Exception e) {
			req.setAttribute("msg", "注册失败");
			// TODO: handle exception
		}

		return "/jsp/info.jsp";

	}

	public String activeUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
		String code = req.getParameter("code");
		// 获取激活码
		UserService userService = new UserServiceImpl();
		// 业务层
		boolean fig = userService.activeUser(code);
		if (fig == true) {
			req.setAttribute("msg", "用户激活成功");
			return "/jsp/login.jsp";
		} else {
			req.setAttribute("msg", "用户激活失败");
			return "/jsp/info.jsp";
		}

	}

	public String userLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 获取用户账号密码
		User user = new User();
		// 把数据封装在user
		MyBeanUtils.populate(user, req.getParameterMap());
		UserService userService = new UserServiceImpl();
		User user2 = null;
		try {
			// 调用业务层
			user2 = userService.userLogin(user);
			// user的数据是从数据库里获取的，非常丰富
			System.out.println("来到了这里");
			req.getSession().setAttribute("userLogin", user2);
			resp.sendRedirect("/Sore_v1.1/index.jsp");
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			// 用户登入失败
			System.out.println("来到了错误");
			String msg = e.getMessage();
			// 获取错误信息
			System.out.println(msg+"okokoko");
			req.setAttribute("msg", msg);
			// 把错误信息放到request
			return "/jsp/info.jsp";
		}
	}

	public String userLogOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("退出");
		req.getSession().invalidate();
		//清除session
		resp.sendRedirect("/Sore_v1.1/index.jsp");
		// 登入成功
		return null;
	}
}
