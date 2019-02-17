package cn.itcast.store.dao.daoImp;

import java.sql.SQLException;
import java.util.List;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.store.dao.CategoryDao;
import cn.itcast.store.domain.Category;
import cn.itcast.store.utils.JDBCUtils;

public class CategoryDaoImpl implements CategoryDao {

	public List<Category> getAllcast() throws SQLException {
		// TODO Auto-generated method stub
		//查询所有分类
		String sql = "select *from category ";
		// sql语句
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		// 创建QueryRunner对象
		return runner.query(sql, new BeanListHandler<Category>(Category.class));

	}

	public void addCategory(Category category) throws SQLException {
		// TODO Auto-generated method stub
		//添加分类
		String sql="insert into category values(?,?)";
		System.out.println("添加分类");
		QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params= {category.getCid(),category.getCname()};
		queryRunner.update(sql,params);
	}

	public void deleteCategory(String cid) throws SQLException {
		// TODO Auto-generated method stub
		//删除商品
		QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params= {cid};
		queryRunner.update("delete from product where cid=?",params);
		queryRunner.update("delete from category where cid=?",params);
	}

}
