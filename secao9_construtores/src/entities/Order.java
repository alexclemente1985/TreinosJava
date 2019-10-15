package entities;

import java.util.Date;

public class Order {
	String name;
	private Date date;
	private Product product;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order(Date date, Product product) {
		super();
		this.date = date;
		this.product = product;
		this.product.setName(name);
	}
}
