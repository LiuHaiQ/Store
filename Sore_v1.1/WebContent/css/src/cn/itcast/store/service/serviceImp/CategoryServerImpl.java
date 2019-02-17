package cn.itcast.store.service.serviceImp;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.dao.daoImp.CategoryDaoImpl;
import cn.itcast.store.domain.Category;
import cn.itcast.store.service1.CategoryServer;

public class CategoryServerImpl implements CategoryServer {

	public List<Category> getAllCats() throws SQLException {
		// TODO Auto-generated method stub
		CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
		
		return categoryDaoImpl.getAllCats();
	}

}
