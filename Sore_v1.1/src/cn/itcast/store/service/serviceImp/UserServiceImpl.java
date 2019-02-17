package cn.itcast.store.service.serviceImp;

import java.sql.SQLException;

import cn.itcast.store.dao.UserDao;
import cn.itcast.store.dao.daoImp.UserDaoImpl;
import cn.itcast.store.domain.User;
import cn.itcast.store.service.UserService;

public class UserServiceImpl implements UserService {

	public void userRegist(User user) throws SQLException {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		// dao层
		userDao.userRegist(user);
		// 调用dao层的userRegister
	}

	public boolean activeUser(String code) throws SQLException {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		User user = userDao.activeUser(code);
		if (null != user) {
			user.setState(1);
			user.setCode(null);
			userDao.updateUser(user);
			return true;
		} else {
			return false;
		}
	}

	public User userLogin(User user) throws SQLException {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		// dao层
		User uu = userDao.userLogin(user);
		// dao层的userLogin
		if (null==uu) {
			System.out.println("密码错误");
			throw new RuntimeException("密码错误");
		}else  if (uu.getState()==0) {
			throw new RuntimeException("用户未激活");
		}else {
			return uu;
		}
	}

}
