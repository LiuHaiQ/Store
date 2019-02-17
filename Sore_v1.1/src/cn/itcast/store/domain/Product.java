package cn.itcast.store.domain;

import java.util.Date;

public class Product {
	private String pid;// 商品id
	private String pname;// 商品名字
	private String market_price;// 商品市场价格
	private String shop_price;// 商品商城价格
	private String pimage;// 商品图片路径
	private String pdate;// 商品上架时间
	private int is_host;// 商品是否热门
	private String pdesc;// 商品描述
	private int pflag;// 商品是否上架 0:在货架1:下架
	private String cid;// 商品所在分类的id
	

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getMarket_price() {
		return market_price;
	}

	public void setMarket_price(String market_price) {
		this.market_price = market_price;
	}

	public String getShop_price() {
		return shop_price;
	}

	public void setShop_price(String shop_price) {
		this.shop_price = shop_price;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public int getIs_host() {
		return is_host;
	}

	public void setIs_host(int is_host) {
		this.is_host = is_host;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public int getPflag() {
		return pflag;
	}

	public void setPflag(int pflag) {
		this.pflag = pflag;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String pid, String pname, String market_price, String shop_price, String pimage, String pdate,
			int is_host, String pdesc, int pflag, String cid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.market_price = market_price;
		this.shop_price = shop_price;
		this.pimage = pimage;
		this.pdate = pdate;
		this.is_host = is_host;
		this.pdesc = pdesc;
		this.pflag = pflag;
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", market_price=" + market_price + ", shop_price="
				+ shop_price + ", pimage=" + pimage + ", pdate=" + pdate + ", is_host=" + is_host + ", pdesc=" + pdesc
				+ ", pflag=" + pflag + ", cid=" + cid + "]";
	}

}
