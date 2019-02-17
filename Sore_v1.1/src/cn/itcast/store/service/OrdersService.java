package cn.itcast.store.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.domain.Orders;
import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.User;

public interface OrdersService {
	public void sava(Orders orders) throws SQLException;

	public PageModel findMyOrdersWithPage(User user, int num)
			throws SQLException, IllegalAccessException, InvocationTargetException;

	public Orders findOrderByOid(String oid) throws SQLException, IllegalAccessException, InvocationTargetException;

	public void updateOrders(Orders orders) throws SQLException;
	public List<Orders> findOrders() throws SQLException;
	public List<Orders> findOrders(String state) throws SQLException;
	//查询所有订单
}
