package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Category;
import cn.itcast.store.service.CategoryService;
import cn.itcast.store.service.serviceImp.CategoryServiceImpl;
import cn.itcast.store.utils.JedisUtils;
import cn.itcast.store.web.base.BaseServlet;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

/**
 * Servlet implementation class CategoryServlet
 */
public class CategoryServlet extends BaseServlet {
	public String findAllCats(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		Jedis jedis = JedisUtils.getJedis();
		// 获取redis实例
		String json = jedis.get("allCats");
		if (null == json || "".equals(json)) {
			System.out.println("redis没有缓存");
			CategoryService categoryService = new CategoryServiceImpl();
			// 业务层
			List<Category> list = categoryService.getAllcats();
			// 把数据库的分类信息查出来，返回一个Category对象集合
			jedis.set("allCats", JSONArray.fromObject(list).toString());
			
		}else {
			System.out.println("redis有缓存");
		}

		// 转换json
		resp.setContentType("application/json;charset=utf-8");
		// 设置响应数据类型json
		resp.getWriter().print(json);

		return null;
	}
}
