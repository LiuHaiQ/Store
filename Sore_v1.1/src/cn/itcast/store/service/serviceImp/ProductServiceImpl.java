package cn.itcast.store.service.serviceImp;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.dao.ProductDao;
import cn.itcast.store.dao.daoImp.ProductDaoImpl;
import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.Product;
import cn.itcast.store.service.ProductService;

public class ProductServiceImpl implements ProductService {

	ProductDao productDao = new ProductDaoImpl();

	public List<Product> findHosts() throws SQLException {
		// TODO Auto-generated method stub
		return productDao.findHosts();

	}

	public List<Product> findNews() throws SQLException {
		// TODO Auto-generated method stub
		return productDao.findNews();
	}

	public Product findByid(String id) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("业务层" + productDao.findByid(id));
		return productDao.findByid(id);
	}

	public PageModel findByCid(int num, String cid) throws SQLException {
		// TODO Auto-generated method stub
		int selectCount = productDao.selectCount(cid);
		// 获得总数据个数
		PageModel pm = new PageModel(num, selectCount, 12);
		List<Product> list = productDao.findByCid(pm.getStartIndex(), cid, pm.getPageSize());
		pm.setList(list);
		pm.setUrl("ProductServlet?method=findProductsByCidWithPage&cid="+cid);
		return pm;
	}

	public PageModel findProductsByCidWithPage(int num,int pflag) throws SQLException {
		// TODO Auto-generated method stub
		int totalRecords=productDao.selectCountProduct(pflag);
		//查询指定状态商品的总数量
		PageModel pm=new PageModel(num,totalRecords , 5);
		//初始化数据
		List<Product> list=productDao.findByCid(pm.getStartIndex(), pm.getPageSize());
		pm.setList(list);
		pm.setUrl("AdminProductServlet?method=findProductsByCidWithPage&");
		return pm;
	}

	public void saveProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		productDao.saveProduct(product);
		
	}


}
