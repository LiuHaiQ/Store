package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.User;
import cn.itcast.store.service.serviceImp.UserServiceImpl;
import cn.itcast.store.service1.UserService;
import cn.itcast.store.utils.MailUtils;
import cn.itcast.store.utils.MyBeanUtils;
import cn.itcast.store.utils.UUIDUtils;
import cn.itcast.store.web.base.BaseServlet;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {

	public String registUI(HttpServletRequest request, HttpServletResponse response) {
		return "/jsp/register";
		// 返回要跳转的页面
	}

	public String userRegisUI(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		MyBeanUtils.populate(user, map);
		// 把数据装到User里面去
		user.setUid(UUIDUtils.getId());
		// 分配id
		user.setCode(UUIDUtils.getCode());
		// 生成激活码
		user.setState(0);
		System.out.println(user.toString());
		// 获得所有from传过来的参数
		UserService userService = new UserServiceImpl();
		// 业务层
		try {
			userService.userRegist(user);
			// 注册成功就要发邮件给用户
			MailUtils.sendMail(user.getEmail(), user.getCode());
			request.setAttribute("mg", "注册成功，请激活!");

			return "/jsp/info";
			// 注册成功跳转页面
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("mg", "注册成功，请激活!");
			return "/jsp/info";
			// 注册失败跳转页面
		}

	}

	public String useractive(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// http://localho:8080/Sore_v1.0/UserServlet?method=active&code=
		String code = request.getParameter("code");
		// 获得用户传过来的激活码
		System.out.println("来了");
		User user = new User();
		// 用户信息对象
		user.setCode(code);
		// 把激活码存到User对象
		UserService userService = new UserServiceImpl();
		// 业务层
		boolean flag = userService.userActive(code);
		// 业务层调用userActive,返回boolean值
		if (flag) {
			request.setAttribute("mg", "激活成功请登入");
			return "jsp/login";
			// 返回登入页面
		} else {
			request.setAttribute("mg", "激活失败,请重新激活");
			return "/jsp/info";
			// 返回失败页面
		}

	}

	public String userLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// 登入功能
		User user = new User();
		// 用户信息对象
		Map<String, String[]> map = request.getParameterMap();
		// 获得账号密码
		MyBeanUtils.populate(user, map);
		// 写入user对象
		UserService userService = new UserServiceImpl();
		// 业务实现
		User user02 = null;
		try {
			user02 = userService.userLogin(user);
			request.getSession().setAttribute("loginUser", user02);
			return "/jsp/index";
		} catch (Exception e) {
			// TODO Auto-generated catch block

			request.setAttribute("mg", e.getMessage());
			return "/jsp/info";
		}

	}
	public String  loginOut(HttpServletRequest request, HttpServletResponse response) {
		//退出功能
		request.getSession().invalidate();
		//清除session
		return "/jsp/index";
		
	}
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		
		return super.execute(req, resp);
	}
}
