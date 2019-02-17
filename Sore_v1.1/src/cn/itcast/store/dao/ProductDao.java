package cn.itcast.store.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.store.domain.Product;
import cn.itcast.store.utils.JDBCUtils;

public interface ProductDao {
public List<Product> findHosts() throws SQLException;
//查询热门商品
public List<Product> findNews() throws SQLException;
//查询非热门商品
public Product findByid(String id) throws SQLException;
//根据pid查询商品
public List<Product> findByCid(int num, String cid, int pageSize) throws SQLException;
//前台商品的分类查询
public List<Product> findByCid(int num, int pageSize) throws SQLException;
public int selectCount(String cid) throws SQLException;
//前台的商品查询总数量
public int selectCountProduct(int pflag) throws SQLException;
//查询指定状态的商品的总数量
public void saveProduct(Product product) throws Exception;
//添加商品
public List<Product> findPflag(int Sqlnum, int pageSize) throws Exception;
//查询下架的商品
}