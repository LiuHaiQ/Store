package cn.itcast.store.dao.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.store.domain.Category;
import cn.itcast.store.domain.CategoryDao;
import cn.itcast.store.utils.JDBCUtils;

public class CategoryDaoImpl implements CategoryDao {

	public List<Category> getAllCats() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from category";
		QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());
		
		return runner.query(sql,new BeanListHandler<Category>(Category.class));
	}

}
