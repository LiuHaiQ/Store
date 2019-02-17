package cn.itcast.store.service;

import java.util.List;

import cn.itcast.store.domain.Category;

import java.sql.SQLException;

public interface CategoryService {
public List<Category> getAllcats() throws SQLException;
public void addCategory(Category category) throws SQLException;
public void deleteCategory(String cid) throws SQLException;
}
