package entities;

public class Product {
	private String name;
	private double price;
	private int quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public double totalValueInStock() {
		return price * quantity;
	}

	public void addProducts(int qtd) {

		this.quantity += qtd;

	}

	public void removeProducts(int qtd) {
		this.quantity -= qtd;
		if (this.quantity < 0) {
			this.quantity = 0;
		}
	}

	public String toString() {

		return name + ", $ " + String.format("%.2f", price) + ", " + quantity + " unidades -> TOTAL: $ "
				+ String.format("%.2f", totalValueInStock());

	}
	
	public Product(String name, double price, int quantitity) {
		this.name = name;
		this.price = price;
		this.quantity = quantitity;
	}
	
	public Product (String name, double price) {
		this.quantity = 0;
		this.name = name;
		this.price = price;
	}
	
	public Product() {
		
	}
}
