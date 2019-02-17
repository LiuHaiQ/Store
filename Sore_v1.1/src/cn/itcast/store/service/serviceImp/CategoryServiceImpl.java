package cn.itcast.store.service.serviceImp;

import java.util.List;
import java.sql.SQLException;

import cn.itcast.store.dao.CategoryDao;
import cn.itcast.store.dao.daoImp.CategoryDaoImpl;
import cn.itcast.store.domain.Category;
import cn.itcast.store.service.CategoryService;
import redis.clients.jedis.Jedis;

public class CategoryServiceImpl implements CategoryService {

	public List<Category> getAllcats() throws SQLException{
		// TODO Auto-generated method stub
		CategoryDao categoryDao=new CategoryDaoImpl();
		
		return categoryDao.getAllcast();
	}

	public void addCategory(Category category) throws SQLException {
		// TODO Auto-generated method stub
		CategoryDao categoryDao=new CategoryDaoImpl();
		categoryDao.addCategory(category);
		Jedis jedis=new Jedis();
		jedis.del("allCats");
		jedis.close();
	}

	public void deleteCategory(String cid) throws SQLException {
		// TODO Auto-generated method stub
		CategoryDao categoryDao=new CategoryDaoImpl();
		categoryDao.deleteCategory(cid);
	}

}
