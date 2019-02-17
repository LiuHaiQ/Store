package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.Product;
import cn.itcast.store.service.ProductService;
import cn.itcast.store.service.serviceImp.ProductServiceImpl;
import cn.itcast.store.web.base.BaseServlet;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends BaseServlet {
	// sql
	public String findProductByPid(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ProductService productService = new ProductServiceImpl();
		// 业务层
		String id = request.getParameter("pid");
		System.out.println("这是商品id" + id);
		Product product = productService.findByid(id);
//		System.out.println(product.toString());
		request.setAttribute("product", product);
		return "/jsp/product_info.jsp";
	}

	public String findProductsByCidWithPage(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		int num = Integer.valueOf(request.getParameter("num"));
		// 当前页
		System.out.println("servlet的当前页"+num);
		String cid = request.getParameter("cid");
		// 分类id
		ProductService productService = new ProductServiceImpl();
		PageModel page=productService.findByCid(num, cid);
		//pageSize是一页显示多少数据
	
		
		request.setAttribute("page", page);
		
		return "/jsp/product_list.jsp";
	}
}
