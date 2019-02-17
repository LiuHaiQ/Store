package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Category;
import cn.itcast.store.service.CategoryService;
import cn.itcast.store.service.serviceImp.CategoryServiceImpl;
import cn.itcast.store.utils.UUIDUtils;
import cn.itcast.store.web.base.BaseServlet;

/**
 * Servlet implementation class AdminCategoryServlet
 */
public class AdminCategoryServlet extends BaseServlet {
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// 查询所有分类
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> list = categoryService.getAllcats();
		request.setAttribute("category", list);
		return "/admin/category/list.jsp";
	}

	public String addCategoryUI(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		return "/admin/category/add.jsp";
	}

	public String addCategory(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
//添加分类
		String cid = UUIDUtils.getId();
		// 程序赋值cid
		String cname = request.getParameter("cname");
		// 获得要添加的cname
		Category category = new Category();
		category.setCid(cid);
		category.setCname(cname);
		CategoryService categoryService = new CategoryServiceImpl();
		// 业务层
		categoryService.addCategory(category);
		System.out.println("准备重定向");
		response.sendRedirect("/Sore_v1.1/AdminServlet?method=findAll");
		return null;
	}

	public String findDelete(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// 准备分类删除
		String cid = request.getParameter("cid");
		System.out.println(cid);
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.deleteCategory(cid);
		response.sendRedirect("/Sore_v1.1/AdminServlet?method=findAll");
		return null;
	}
}
