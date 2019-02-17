package cn.itcast.store.dao.daoImp;

import java.sql.SQLException;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.store.domain.User;
import cn.itcast.store.domain.UserDao;
import cn.itcast.store.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	public void userRegist(User user) throws SQLException {
		String sql = "INSERT INTO  user VALUES(?,?,?,?,?,?,?,?,?,?)";
		// sql语句
		QueryRunner query = new QueryRunner(JDBCUtils.getDataSource());
		// 创建QueryRunner对象
		Object[] params = { user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(),
				user.getTelephone(), user.getBirthday(), user.getSex(), user.getState(), user.getCode() };
		query.update(sql, params);
	}

	public User userActive(String code) throws SQLException {
		String sql = "select *from user where code=?";
		// 查询数据库有没有这个激活码
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

		return runner.query(sql, new BeanHandler<User>(User.class), code);
		// 如果有那么返回User对象，如果没有返回null
		// TODO Auto-generated method stub

	}

	public void updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		// 把数据库的数据改一下
		String sql = "update user  set username=?,password=?,name=?,email=?,telephone=?,birthday=?,sex=?,state=?,code=? where uid"
				+ "=?";
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params = { user.getUsername(), user.getPassword(), user.getName(), user.getEmail(),
				user.getTelephone(), user.getBirthday(), user.getSex(), user.getState(), user.getCode(), user.getUid() };
		runner.update(sql, params);
		// 执行sql语句
	}

	public User userLogin(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select *from user where username=? and password=?";
		// 查询数据库有没有账号密码
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
System.out.println(user.getUsername()+".........."+user);
		User uuUser= runner.query(sql, new BeanHandler<User>(User.class), user.getUsername(), user.getPassword());
		System.out.println(uuUser+"这是用户对象");
		return uuUser;
	}

}
