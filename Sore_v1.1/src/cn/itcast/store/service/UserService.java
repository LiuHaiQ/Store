package cn.itcast.store.service;

import java.sql.SQLException;

import cn.itcast.store.domain.User;

public interface UserService {
	public void userRegist(User user) throws SQLException;
	//注册
	public boolean activeUser(String code) throws SQLException;
	//激活
	public User userLogin(User user) throws SQLException;
	//登入
	
}
