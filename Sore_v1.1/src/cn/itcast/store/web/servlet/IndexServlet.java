package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Category;
import cn.itcast.store.domain.Product;
import cn.itcast.store.service.CategoryService;
import cn.itcast.store.service.ProductService;
import cn.itcast.store.service.serviceImp.CategoryServiceImpl;
import cn.itcast.store.service.serviceImp.ProductServiceImpl;
import cn.itcast.store.web.base.BaseServlet;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends BaseServlet {
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		ProductService productService = new ProductServiceImpl();
		List<Product> list01 = productService.findHosts();
		System.out.println("okok333");
		List<Product> list = productService.findNews();
		for (Product product : list01) {
			System.out.println(product.getPname()+"000"+product.getPimage());
		}
		System.out.println("1111111111111111111111111111111111111");
		for (Product product : list) {
			System.out.println(product.getPname()+"000"+product.getPimage());
		}
		req.setAttribute("hosts", list01);
		req.setAttribute("news", list);
		System.out.println("okok");
		return "/jsp/index.jsp";
		// TODO Auto-generated method stub
	}
}
