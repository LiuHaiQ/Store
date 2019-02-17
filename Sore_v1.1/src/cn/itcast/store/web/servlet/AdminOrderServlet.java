package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.dao.daoImp.OrdersDaoImpl;
import cn.itcast.store.domain.Orders;
import cn.itcast.store.service.OrdersService;
import cn.itcast.store.service.serviceImp.OrdersServiceImpl;
import cn.itcast.store.web.base.BaseServlet;

/**
 * Servlet implementation class AdminOrderServlet
 */
public class AdminOrderServlet extends BaseServlet {
	public String findOrders(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// 后台查询所有订单
		String state = request.getParameter("state");
		OrdersService ordersService = ordersService = new OrdersServiceImpl();
		;
		List<Orders> list = null;
		if (null == state || "".equals(state)) {

			list = ordersService.findOrders();
		} else {
			list = ordersService.findOrders(state);
		}

		request.setAttribute("orders", list);

		return "/admin/order/list.jsp";

	}
}
