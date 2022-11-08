package bean;
/*
 * 商品情報を表すBeanのクラス
 */
public class Product implements java.io.Serializable {
	
	private int id;		// 商品番号
	private String name;// 商品名
	private int price;	// 価格
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
