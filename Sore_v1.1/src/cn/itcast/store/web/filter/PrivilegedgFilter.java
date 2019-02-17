package cn.itcast.store.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.User;

/**
 * Servlet Filter implementation class PrivilegedgFilter
 */
public class PrivilegedgFilter implements Filter {

	public PrivilegedgFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse response2 = (HttpServletResponse) response;
		User user=(User) request2.getSession().getAttribute("userLogin");
		//获得用户对象
		if (null==user) {
			//如果null==user那么就是没有登入
			request2.setAttribute("msg", "请登入后再访问");
			request2.getRequestDispatcher("/jsp/info.jsp").forward(request2, response2);
		}
		
		 chain.doFilter(request, response);
		 //执行到这里就是放行
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
