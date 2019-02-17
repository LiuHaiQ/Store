package cn.itcast.store.dao;

import java.sql.SQLException;

import cn.itcast.store.domain.User;

public interface UserDao {
	public void userRegist(User user) throws SQLException;

	public User activeUser(String code) throws SQLException;

	public void updateUser(User user) throws SQLException;

	public User userLogin(User user) throws SQLException;
}
