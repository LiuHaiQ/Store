package cn.itcast.store.dao.daoImp;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.store.dao.UserDao;
import cn.itcast.store.domain.User;
import cn.itcast.store.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	public void userRegist(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		// sql语句
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		// queryrunner对象
		Object object[] = { user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(),
				user.getTelephone(), user.getBirthday(), user.getSex(), user.getState(), user.getCode() };
		runner.update(sql, object);
	}

	public User activeUser(String user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from user where code=?";
		// sql语句
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		// queryrunner对象

		return runner.query(sql, new BeanHandler<User>(User.class), user);
	}

	public void updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update user set uid=?, username=?, password=?, name=?, email=?, telephone=?, birthday=?, sex=? , state=?, code=? where uid=?";
		// sql语句，把state改为1,把code改为null
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		// queryrunner对象
		Object object[] = { user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(),
				user.getTelephone(), user.getBirthday(), user.getBirthday(), user.getSex(), user.getState(),
				user.getCode() };
		runner.update(sql, object);

	}

	public User userLogin(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from user where username =? and password= ?";
		// queryrunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		// queryrunner对象
		return runner.query(sql, new BeanHandler<User>(User.class), user.getUsername(), user.getPassword());
	}

}
