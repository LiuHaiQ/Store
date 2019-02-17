package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Cart;
import cn.itcast.store.domain.CartItem;
import cn.itcast.store.domain.Product;
import cn.itcast.store.service.ProductService;
import cn.itcast.store.service.serviceImp.ProductServiceImpl;
import cn.itcast.store.web.base.BaseServlet;

public class CartServlet extends BaseServlet {
	public String addCartgItemToCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		// 获得商品对象
		if (cart == null) {
			// 如果为null说明是第一次买
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
			// 把商品放到session
		}
		String pid = request.getParameter("pid");
		// 获得商品id
		System.out.println("商品id" + pid);
		int count = Integer.parseInt(request.getParameter("count"));
		// 获得购物数量
		ProductService productService = new ProductServiceImpl();
		Product product = productService.findByid(pid);
		// 查到这个商品
		System.out.println("查到这个商品" + product.getPname());
		cart.addCart(product, count);
		Collection<CartItem> cartItems = cart.getCarItems();
		System.out.println("测试session里面的商品");
		for (CartItem cartItem : cartItems) {
			System.out.println(cartItem.getProduct().getPname());
		}
		response.sendRedirect("/Sore_v1.1/jsp/cart.jsp");
		return null;

	}

	public String removeCartgItemToCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pid = request.getParameter("pid");
		// 获得id
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.removeCartItem(pid);
		// 删除商品
		response.sendRedirect("/Sore_v1.1/jsp/cart.jsp");
		return null;

	}

	public String clearCartgItemToCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//获得cart对象
		cart.clearCartItem();
		//清空购物车
		response.sendRedirect("/Sore_v1.1/jsp/cart.jsp");
		return null;
	}
}
