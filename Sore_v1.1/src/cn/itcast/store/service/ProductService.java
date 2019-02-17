package cn.itcast.store.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.Product;
import cn.itcast.store.utils.JDBCUtils;

public interface ProductService {
public List<Product> findHosts() throws SQLException;
//查询热门商品
public List<Product> findNews() throws SQLException;
//查询非热门商品
public Product findByid(String id) throws SQLException;
//查询指定的商品
public PageModel findByCid(int num,String cid) throws SQLException;
//查询所有的分类
public PageModel findProductsByCidWithPage(int num,int pflag) throws SQLException;
//查询所有的商品
public void saveProduct(Product product) throws Exception;
//添加商品
}
