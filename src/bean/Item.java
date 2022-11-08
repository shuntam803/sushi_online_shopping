package bean;
/*
 *カート内の項目を格納するBeanのクラス
 */
public class Item implements java.io.Serializable {
	
	/** 商品情報 */
	private Product product;
	/** 個数 */
	private int count;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}