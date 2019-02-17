package cn.itcast.store.web.servlet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Category;
import cn.itcast.store.service.serviceImp.CategoryServerImpl;
import cn.itcast.store.service1.CategoryServer;
import cn.itcast.store.web.base.BaseServlet;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends BaseServlet {
	
	public String execute(HttpServletRequest  request, HttpServletResponse response) throws Exception {
		//调用业务层把分类信息放在request
		
		System.out.println("来了");
		
		CategoryServer categoryServer= new CategoryServerImpl();
		List<Category> list=categoryServer.getAllCats();
		for (Category category : list) {
			System.out.println(category.getCname());
		}
		request.setAttribute("category", list);
		return "/jsp/index";
	}
}
