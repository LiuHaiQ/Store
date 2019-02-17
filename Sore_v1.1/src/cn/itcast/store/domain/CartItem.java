package cn.itcast.store.domain;

public class CartItem {
private Product product;//商品
private double subtotal;//小计
private int Count;//商品数量
/**
 * @return the product
 */
public Product getProduct() {
	return product;
}
/**
 * @param product the product to set
 */
public void setProduct(Product product) {
	this.product = product;
}
/**
 * @return the subtotal
 */
public double getSubtotal() {
	this.subtotal=Count*Integer.valueOf((product.getShop_price()));
	return subtotal;
}
/**
 * @param subtotal the subtotal to set
 */
public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}
/**
 * @return the count
 */
public int getCount() {
	return Count;
}
/**
 * @param count the count to set
 */
public void setCount(int count) {
	Count = count;
}

}
