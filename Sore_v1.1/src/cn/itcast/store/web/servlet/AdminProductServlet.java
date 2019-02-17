package cn.itcast.store.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import cn.itcast.store.domain.Category;
import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.Product;
import cn.itcast.store.service.CategoryService;
import cn.itcast.store.service.ProductService;
import cn.itcast.store.service.serviceImp.CategoryServiceImpl;
import cn.itcast.store.service.serviceImp.ProductServiceImpl;
import cn.itcast.store.utils.UUIDUtils;
import cn.itcast.store.utils.UploadUtils;
import cn.itcast.store.web.base.BaseServlet;

/**
 * Servlet implementation class AdminProductServlet
 */
public class AdminProductServlet extends BaseServlet {
	public String findProductsByCidWithPage(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int num = Integer.valueOf(request.getParameter("num"));
		// 当前页
		ProductService productService = new ProductServiceImpl();
		PageModel pm = productService.findProductsByCidWithPage(num,1);
		//1是上架
		// 后台的查询所有上架了的商品
		request.setAttribute("page", pm);
		return "/admin/product/list.jsp";
	}

	public String addProductUI(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 查询分类在list.jsp中要使用
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> list = categoryService.getAllcats();
		req.setAttribute("allCates", list);
		return "/admin/product/add.jsp";
	}

	public String addProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 存储表单中数据
		Map<String, String> map = new HashMap<String, String>();
		// 携带表单中的数据向servcie,dao
		Product product = new Product();
		try {
			// 利用req.getInputStream();获取到请求体中全部数据,进行拆分和封装
			DiskFileItemFactory fac = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fac);
			List<FileItem> list = upload.parseRequest(req);
			// 4_遍历集合
			for (FileItem item : list) {
				if (item.isFormField()) {
					// 5_如果当前的FileItem对象是普通项
					// 将普通项上name属性的值作为键,将获取到的内容作为值,放入MAP中
					map.put(item.getFieldName(), item.getString("utf-8"));
				} else {
					// 6_如果当前的FileItem对象是上传项

					// 获取到原始的文件名称
					String oldFileName = item.getName();
					// 获取到要保存文件的名称 1222.doc 123421342143214.doc
					String newFileName = UploadUtils.getUUIDName(oldFileName);

					// 通过FileItem获取到输入流对象,通过输入流可以获取到图片二进制数据
					InputStream is = item.getInputStream();
					String realPath = getServletContext().getRealPath("/products/1/");
					String path = realPath; // D:\tomcat\tomcat71_sz07\webapps\store_v5\products\3/f/e/d/c/4/9/8/4
					// 内存中声明一个目录
					File newDir = new File(path);
					if (!newDir.exists()) {
						newDir.mkdirs();
					}
					// 在服务端创建一个空文件(后缀必须和上传到服务端的文件名后缀一致)
					File finalFile = new File(newDir, newFileName);
					if (!finalFile.exists()) {
						finalFile.createNewFile();
					}
					// 建立和空文件对应的输出流
					OutputStream os = new FileOutputStream(finalFile);
					// 将输入流中的数据刷到输出流中
					System.out.println(finalFile.getAbsolutePath());
					IOUtils.copy(is, os);
					// 释放资源
					IOUtils.closeQuietly(is);
					IOUtils.closeQuietly(os);
					map.put("pimage", "products/1/" + newFileName);
				}
			}

			// 7_利用BeanUtils将MAP中的数据填充到Product对象上
			BeanUtils.populate(product, map);
			product.setPid(UUIDUtils.getId());
			String format2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			product.setPdate(format2);
			product.setPflag(0);
			ProductService ProductService = new ProductServiceImpl();
			ProductService.saveProduct(product);
			resp.sendRedirect("AdminServlet?method=findProductsByCidWithPage&num=1");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public String findPflag(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		//查询下架商品
		int num = Integer.valueOf(request.getParameter("num"));
		// 当前页
		ProductService productService = new ProductServiceImpl();
		PageModel pm = productService.findProductsByCidWithPage(num,1);
		//0是下架
		// 后台的查询所有下架了的商品
		request.setAttribute("page", pm);
		return "/admin/product/pushDown_list.jsp";
		
	}
}
