package cn.itcast.store.dao.daoImp;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.store.dao.OrdersDao;
import cn.itcast.store.domain.Orders;
import cn.itcast.store.domain.OrdersItem;
import cn.itcast.store.domain.Product;
import cn.itcast.store.domain.User;
import cn.itcast.store.utils.JDBCUtils;
import cn.itcast.store.utils.MyBeanUtils;

public class OrdersDaoImpl implements OrdersDao {

	public void sava(Connection connection, Orders orders) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO orders VALUES(?,?,?,?,?,?,?,?)";
		QueryRunner queryRunner = new QueryRunner();
		Object[] params = { orders.getOid(), orders.getOrderTime(), orders.getTotal(), orders.getState(),
				orders.getAddress(), orders.getName(), orders.getTelephone(), orders.getUser().getUid() };
		queryRunner.update(connection, sql, params);

	}

	public void savaOrdersItem(Connection connection, OrdersItem ordersItem) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO orderitem VALUES(?,?,?,?,?)";
		QueryRunner queryRunner = new QueryRunner();
		Object[] params = { ordersItem.getItemid(), ordersItem.getQuantity(), ordersItem.getTotal(),
				ordersItem.getProduct().getPid(), ordersItem.getOrders().getOid() };
		queryRunner.update(connection, sql, params);
	}

	public int selectCount(User user) throws SQLException {
		// 查找总订单
		String sql = "select count(*) from orders  where uid=?";
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

		Long l = (Long) runner.query(sql, new ScalarHandler(), user.getUid());
		return l.intValue();
	}

	public List findMyOrdersWithPage(User user, int startIndex, int pageSize)
			throws SQLException, IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		String sql = "select*from orders where uid=? limit ?,?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		List<Orders> list = queryRunner.query(sql, new BeanListHandler<Orders>(Orders.class), user.getUid(), startIndex,
				pageSize);
		// 查询出当前用户下的所以的订单

		String sq2 = "select * from orderItem o ,product p where o.pid=p.pid and oid=?";
		for (Orders orders : list) {
			String oid = orders.getOid();
			// 获取订单id
			List<Map<String, Object>> list2 = queryRunner.query(sq2, new MapListHandler(), oid);
			// 获得所有订单项和商品的map
			for (Map<String, Object> map : list2) {
				OrdersItem ordersItem = new OrdersItem();
				// 创建订单项
				Product product = new Product();
				// 创建商品
				// 由于BeanUtils将字符串"1992-3-3"向user对象的setBithday();方法传递参数有问题,手动向BeanUtils注册一个时间类型转换器
				// 1_创建时间类型的转换器
				DateConverter dt = new DateConverter();
				// 2_设置转换的格式.
				dt.setPattern("yyyy-MM-dd");
				// 3_注册转换器
				ConvertUtils.register(dt, java.util.Date.class);
				// 将map中属于ordersItem的数据自动填充到ordersItem
				BeanUtils.populate(ordersItem, map);
				// 将map中属于product的数据自动填充到product对象上
				BeanUtils.populate(product, map);
				ordersItem.setProduct(product);
				// 把商品绑定到订单项
				orders.getList().add(ordersItem);
			}
		}

		return list;
	}

	public Orders findOrderByOid(String oid) throws SQLException, IllegalAccessException, InvocationTargetException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from orders where oid=?";
		Orders orders = queryRunner.query(sql, new BeanHandler<Orders>(Orders.class), oid);
		String sql2 = "select * from orderItem o ,product p where o.pid=p.pid and oid=?";

		List<Map<String, Object>> list = queryRunner.query(sql2, new MapListHandler(), oid);
		for (Map<String, Object> map : list) {
			OrdersItem ordersItem = new OrdersItem();
			// 创建订单项
			Product product = new Product();
			// 创建商品
			// 由于BeanUtils将字符串"1992-3-3"向user对象的setBithday();方法传递参数有问题,手动向BeanUtils注册一个时间类型转换器
			// 1_创建时间类型的转换器
			DateConverter dt = new DateConverter();
			// 2_设置转换的格式.
			dt.setPattern("yyyy-MM-dd");
			// 3_注册转换器
			ConvertUtils.register(dt, java.util.Date.class);
			// 将map中属于ordersItem的数据自动填充到ordersItem
			BeanUtils.populate(ordersItem, map);
			// 将map中属于product的数据自动填充到product对象上
			BeanUtils.populate(product, map);
			ordersItem.setProduct(product);
			// 把商品绑定到订单项
			orders.getList().add(ordersItem);
		}

		return orders;
	}

	public void updateOrders(Orders orders) throws SQLException {
		String sql = "update orders set ordertime=?,total=?,state=?,address=?,name=?,telephone=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params = { orders.getOrderTime(), orders.getTotal(), orders.getState(), orders.getAddress(),
				orders.getName(), orders.getTelephone() };
		queryRunner.update(sql, params);
	}

	public List<Orders> findOrders() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM orders ;";
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Orders>(Orders.class));
	}

	public List<Orders> findOrders(String state) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM orders where state=?;";
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Orders>(Orders.class), state);
	}

}