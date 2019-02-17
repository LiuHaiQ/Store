package cn.itcast.store.domain;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

public class Cart {
	private Map<String, CartItem> map = new HashedMap();// key商品id value商品信息
	private double total;// 商品总计
	private Collection<CartItem> cartItems;
	/**
	 * @return the map
	 */
	public Map<String, CartItem> getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		total = 0;
		// 初始值为0
		for (Map.Entry<String, CartItem> map : map.entrySet()) {
			// 遍历map里面所有的商品
			CartItem cartItem = map.getValue();
			// 商品对象

			total += cartItem.getSubtotal();
			// 获得小计后算出总计
		}
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	public void addCart(Product product, int count) {
		if (product == null) {
			// 判断是不是传过来的商品为null，如果是就return
			return;
			// 结束
		} else {
			// 来到这里说明有商品是有的,则需要看是哪个商品了使用ID找
			CartItem cartItem = map.get(product.getPid());
			// 获得购物对象，如果map没有说明是null,是第一次买
			if (cartItem == null) {
				// 第一次买
				System.out.println("第一次买");
				cartItem = new CartItem();
				cartItem.setProduct(product);
				// 把商品存到这个购物项
				cartItem.setCount(count);
				// 购买商品数量
				map.put(product.getPid(), cartItem);
				// 放入购物车
			} else {
				// 不是第一次买
				System.out.println("不是第一次买");
				cartItem.setCount(cartItem.getCount()+count);
				// 重新设置商品数量
				cartItem.getSubtotal();
				// 设置小计
			}
		}
	}

	public Collection<CartItem> getCarItems() {
		return map.values();
	}

	public void removeCartItem(String cid) {

		map.remove(cid);
		// 删除商品

	}

	public void clearCartItem() {
		map.clear();
		// 清空购物车

	}

}
