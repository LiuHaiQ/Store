package cn.itcast.store.service1;

import cn.itcast.store.domain.Category;

import java.sql.SQLException;
import java.util.List;
public interface CategoryServer {
	public List<Category> getAllCats() throws SQLException ;
}
