package cn.itcast.store.service.serviceImp;

import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import cn.itcast.store.dao.daoImp.UserDaoImpl;
import cn.itcast.store.domain.User;
import cn.itcast.store.domain.UserDao;
import cn.itcast.store.service1.UserService;

public class UserServiceImpl implements UserService {

	public void userRegist(User user) throws SQLException {
		// 注册功能模块
		UserDao userDao = new UserDaoImpl();
		userDao.userRegist(user);

	}

	public boolean userActive(String code) throws SQLException {
		// 激活模块
		UserDao userDao = new UserDaoImpl();
		User user = null;
		try {
			user = userDao.userActive(code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null != user) {
			user.setState(1);
			// 设置状态码
			user.setCode(null);
			// 把激活码清除
			userDao.updateUser(user);
			return true;
			// 查找到了返回true
		} else {

			return false;
			// 查找中不到返回false
		}

	}

	public User userLogin(User user) throws SQLException {
		// 登入模块
		UserDao userDao = new UserDaoImpl();
		User user2 = userDao.userLogin(user);
		if (null == user2) {
			throw new RuntimeException("账号密码有误!");
		} else if (user2.getState() == 0) {
			throw new RuntimeException("账号未激活!");
		} else {
			return user2;
		}
	}

}
