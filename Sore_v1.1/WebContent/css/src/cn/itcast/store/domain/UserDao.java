package cn.itcast.store.domain;

import java.sql.SQLException;

public interface UserDao {
	public void userRegist(User user) throws SQLException;
	public User userActive(String code) throws SQLException ;
	public void updateUser(User user) throws SQLException;
	public User userLogin(User user) throws SQLException;
}
