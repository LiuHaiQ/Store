package cn.itcast.store.dao.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.mail.handlers.multipart_mixed;

import cn.itcast.store.dao.ProductDao;
import cn.itcast.store.domain.Product;
import cn.itcast.store.utils.JDBCUtils;

public class ProductDaoImpl implements ProductDao {

	public List<Product> findHosts() throws SQLException {
		// 查询热门商品
		String sql = "select * from product where is_hot=1 and pflag = 0 order by pdate desc limit 0,9";
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

		return runner.query(sql, new BeanListHandler<Product>(Product.class));

	}

	public List<Product> findNews() throws SQLException {
		String sql = "SELECT *FROM product  ORDER BY pdate DESC LIMIT 0,15";
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

		return runner.query(sql, new BeanListHandler<Product>(Product.class));

	}

	public Product findByid(String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select *from product  where pid=?";
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		return runner.query(sql, new BeanHandler<Product>(Product.class), id);
	}

	public int selectCount(String cid) throws SQLException {
		// 查询商品总数据
		String sql = "select count(*) from product  where cid=?";
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

		Long l = (Long) runner.query(sql, new ScalarHandler(), cid);
		return l.intValue();
	}

	public List<Product> findByCid(int Sqlnum, String cid, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		// 前台商品的分类查询
		String sql = "SELECT * FROM product WHERE cid = ? LIMIT ? ,?";
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Product>(Product.class), cid, Sqlnum, pageSize);
	}

	public int selectCountProduct(int pflag) throws SQLException {
		// 后台商品数量查询
		String sql = "select count(*) from product where pflag=?";
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		Object object[]= {pflag};
		Long l = (Long) runner.query(sql, new ScalarHandler(),object);
		System.out.println(l+"总条数");
		return l.intValue();
	}

	public List<Product> findByCid(int Sqlnum, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		// 后台商品的分类查询
		String sql = "SELECT * FROM product  LIMIT ? ,?;";
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Product>(Product.class), Sqlnum, pageSize);
	}

	public void saveProduct(Product product) throws Exception {
	//后台添加商品
		String sql = "INSERT INTO product VALUES(?,?,?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params = { product.getPid(), product.getPname(), product.getMarket_price(), product.getShop_price(),
				product.getPimage(), product.getPdate(), product.getIs_host(), product.getPdesc(), product.getPflag(),
				product.getCid() };
		qr.update(sql, params);
	}

	public List<Product> findPflag(int Sqlnum, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		//查询以下架的商品
		String sql = "SELECT * FROM product WHERE pflag=0 LIMIT ? ,?;";
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Product>(Product.class), Sqlnum, pageSize);
	}

}
