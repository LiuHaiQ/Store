package cn.itcast.store.service.serviceImp;

import java.sql.SQLException;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

import cn.itcast.store.dao.OrdersDao;
import cn.itcast.store.dao.daoImp.OrdersDaoImpl;
import cn.itcast.store.domain.Orders;
import cn.itcast.store.domain.OrdersItem;
import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.User;
import cn.itcast.store.service.OrdersService;
import cn.itcast.store.utils.JDBCUtils;

public class OrdersServiceImpl implements OrdersService {
	OrdersDao ordersDao = new OrdersDaoImpl();
	// dao层

	public void sava(Orders orders) throws SQLException {
		// 保存订单需要同时成功和同时失败，要用事务
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			connection.setAutoCommit(false);
			// 开启事务
			ordersDao.sava(connection, orders);
			// 保存订单
			for (OrdersItem item : orders.getList()) {
				ordersDao.savaOrdersItem(connection, item);
			}
			connection.commit();
			// 提交事务
		} catch (Exception e) {
			// TODO: handle exception
			connection.rollback();
			// 回滚事务
		}
	}

	public PageModel findMyOrdersWithPage(User user, int num)
			throws SQLException, IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		int totalRecords = ordersDao.selectCount(user);
		// 查找总数据
		PageModel page = new PageModel(num, totalRecords, 3);
		// 初始化所有参数
		List list = ordersDao.findMyOrdersWithPage(user, page.getStartIndex(), page.getPageSize());
		page.setList(list);
		page.setUrl("OrdersServlet?method=findMyOrdersWithPage");
		return page;
	}

	public Orders findOrderByOid(String oid) throws SQLException, IllegalAccessException, InvocationTargetException {
		// 获得这个oid下的订单和订单项和商品
		return ordersDao.findOrderByOid(oid);

	}

	public void updateOrders(Orders orders) throws SQLException {
		// TODO Auto-generated method stub
		ordersDao.updateOrders(orders);
	}

	public List<Orders> findOrders() throws SQLException {
		// TODO Auto-generated method stub
		return ordersDao.findOrders();
		//查询全部订单
	}

	public List<Orders> findOrders(String state) throws SQLException {
		// TODO Auto-generated method stub
		return ordersDao.findOrders(state);
		//查询指定状态的订单
	}

}
