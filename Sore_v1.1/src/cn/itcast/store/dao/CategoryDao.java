package cn.itcast.store.dao;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.domain.Category;

public interface CategoryDao {
public List<Category> getAllcast() throws SQLException;
public void addCategory(Category category) throws SQLException;
public void deleteCategory(String cid) throws SQLException;
}
