package cn.itcast.store.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.domain.Orders;
import cn.itcast.store.domain.OrdersItem;
import cn.itcast.store.domain.User;

public interface OrdersDao {
	public void sava(Connection connection, Orders orders) throws SQLException;

	public void savaOrdersItem(Connection connection, OrdersItem ordersItem) throws SQLException;

	public int selectCount(User user) throws SQLException;
	public List findMyOrdersWithPage(User user,int startIndex,int pageSize) throws SQLException, IllegalAccessException, InvocationTargetException ;
	public Orders findOrderByOid(String oid) throws SQLException, IllegalAccessException, InvocationTargetException ;
	public void updateOrders(Orders orders) throws SQLException;
	public List<Orders> findOrders() throws SQLException;
	public List<Orders> findOrders(String state) throws SQLException;
}
