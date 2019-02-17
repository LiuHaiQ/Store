package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Cart;
import cn.itcast.store.domain.CartItem;
import cn.itcast.store.domain.Orders;
import cn.itcast.store.domain.OrdersItem;
import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.User;
import cn.itcast.store.service.OrdersService;
import cn.itcast.store.service.serviceImp.OrdersServiceImpl;
import cn.itcast.store.utils.UUIDUtils;
import cn.itcast.store.web.base.BaseServlet;

/**
 * Servlet implementation class OrdersServlet
 */
public class OrdersServlet extends BaseServlet {
//	
	public String savaOrders(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		User user = (User) request.getSession().getAttribute("userLogin");
		// 获得用户
		if (user == null) {
			request.setAttribute("msg", "请登入后再下订单");
			return "/jsp/info.jsp";
			// 跳转到提示页面
		}
		// 获取购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		// 创建订单对象为对象赋值
		Orders orders = new Orders();
		// 创建订单项
		orders.setOid(UUIDUtils.getId());
		// 设置订单ID
		orders.setOrderTime(new Date());
		// 设置下单时间
		orders.setTotal(cart.getTotal());
		// 设置订单的总计
		orders.setUser(user);
		// 存入user对象
		for (CartItem cartItem : cart.getCarItems()) {
			OrdersItem ordersItem = new OrdersItem();
			ordersItem.setItemid(UUIDUtils.getId());
			// 生成id
			ordersItem.setQuantity(cartItem.getCount());
			// 商品数量
			ordersItem.setTotal(cartItem.getSubtotal());
			// 小计
			ordersItem.setProduct(cartItem.getProduct());
			ordersItem.setOrders(orders);
			orders.getList().add(ordersItem);
		}
		// 调用业务层功能保存订单
		OrdersService ordersService = new OrdersServiceImpl();
		ordersService.sava(orders);
		// 清空购物车
		cart.clearCartItem();
		request.setAttribute("orders", orders);
		// 将订单放入request
		// 转发到/jsp/order_info.jsp
		System.out.println(orders.getOid());
		return "/jsp/order_info.jsp";
	}

	public String findMyOrdersWithPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, IllegalAccessException, InvocationTargetException {
		User user = (User) request.getSession().getAttribute("userLogin");
		int num = Integer.parseInt(request.getParameter("num"));
		// 当前页
		OrdersService ordersService = new OrdersServiceImpl();
		PageModel page = ordersService.findMyOrdersWithPage(user, num);
		request.setAttribute("page", page);
		return "/jsp/order_list.jsp";
	}

	public String findOrderByOid(HttpServletRequest request, HttpServletResponse response)
			throws IllegalAccessException, InvocationTargetException, SQLException {

		String oid = request.getParameter("oid");
		// 获取订单id
		OrdersService ordersService = new OrdersServiceImpl();
		// 业务层
		Orders orders = ordersService.findOrderByOid(oid);
		request.setAttribute("orders", orders);
		return "/jsp/order_info.jsp";
	}

	public String payOrder(HttpServletRequest request, HttpServletResponse response)
			throws IllegalAccessException, InvocationTargetException, SQLException, IOException {
		System.out.println("测试1");
		String oid = request.getParameter("oid");
		// oid
		String address = request.getParameter("address");
		// 地址
		String name = request.getParameter("name");
		// 收件人
		String telephone = request.getParameter("telephone");
		// 手机
		String pd_FrpId = request.getParameter("pd_FrpId");
		// 选择的银行
		OrdersService ordersService = new OrdersServiceImpl();
		Orders orders = ordersService.findOrderByOid(oid);
		// 获得这个oid的所有数据
		orders.setAddress(address);
		orders.setName(name);
		orders.setTelephone(telephone);

		ordersService.updateOrders(orders);
		// 更新数据
		// 获取到订单号
		// 获取到金额
		String money = request.getParameter("money");
		// 获取到选中的银行信息

		// 把付款所需要的参数准备好:
		String p0_Cmd = "Buy";
		// 商户编号
		String p1_MerId = "10001126856";
		// 订单编号
		String p2_Order = oid;
		// 金额
		String p3_Amt = "0.01";
		String p4_Cur = "CNY";
		String p5_Pid = "";
		String p6_Pcat = "";
		String p7_Pdesc = "";
		// 接受响应参数的Servlet
		String p8_Url = "http://localhost:8080/Sore_v1.1/OrdersServlet?method=callBack";
		String p9_SAF = "";
		String pa_MP = "";
		String pr_NeedResponse = "1";
		// 公司的秘钥
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";

		// 调用易宝的加密算法,对所有数据进行加密,返回电子签名
		String hmac = cn.itcast.store.utils.PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid,
				p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);

		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);

		System.out.println(sb.toString());
		//
		// 使用重定向：
		response.sendRedirect(sb.toString());

		return null;
	}
//	

	public String callBack(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, IllegalAccessException, InvocationTargetException {
		// 验证请求来源和数据有效性
		// 阅读支付结果参数说明
		// System.out.println("==============================================");
		String p1_MerId = request.getParameter("p1_MerId");
		String r0_Cmd = request.getParameter("r0_Cmd");
		String r1_Code = request.getParameter("r1_Code");
		String r2_TrxId = request.getParameter("r2_TrxId");
		String r3_Amt = request.getParameter("r3_Amt");
		String r4_Cur = request.getParameter("r4_Cur");
		String r5_Pid = request.getParameter("r5_Pid");
		String r6_Order = request.getParameter("r6_Order");
		String r7_Uid = request.getParameter("r7_Uid");
		String r8_MP = request.getParameter("r8_MP");
		String r9_BType = request.getParameter("r9_BType");
		String rb_BankId = request.getParameter("rb_BankId");
		String ro_BankOrderId = request.getParameter("ro_BankOrderId");
		String rp_PayDate = request.getParameter("rp_PayDate");
		String rq_CardNo = request.getParameter("rq_CardNo");
		String ru_Trxtime = request.getParameter("ru_Trxtime");

		// hmac
		String hmac = request.getParameter("hmac");
		// 利用本地密钥和加密算法 加密数据
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
		boolean isValid = cn.itcast.store.utils.PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId,
				r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType, keyValue);
		if (isValid) {
			// 有效
			if (r9_BType.equals("1")) {
				// 浏览器重定向
				OrdersService ordersService = new OrdersServiceImpl();
				// 业务层
				Orders orders = ordersService.findOrderByOid(r6_Order);
				orders.setState(2);
				ordersService.updateOrders(orders);
				request.setAttribute("msg", "订单交易成功"+"\n"+"订单编号:"+r6_Order+"金额:"+r3_Amt);
				return "info.jsp";
			} else if (r9_BType.equals("2")) {
				// 修改订单状态:
				// 服务器点对点，来自于易宝的通知
				System.out.println("收到易宝通知，修改订单状态！");//
				// 回复给易宝success，如果不回复，易宝会一直通知
				response.getWriter().print("success");
			}

		} else {
			throw new RuntimeException("数据被篡改！");
		}
		return "";
	}
}