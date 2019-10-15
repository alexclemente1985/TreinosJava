package entities;

public class Produto {
	private String name;
	private double price = 0;
	private int quantity = 0;

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

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/*
	 * public String getName() { return name; } public void setName(String name) {
	 * this.name = name; } public double getPrice() { return price; } public void
	 * setPrice(double price) { this.price = price; } public int getQuantity() {
	 * return quantity; } public void setQuantity(int quantity) { this.quantity =
	 * quantity; }
	 */

	public double totalValueInStock() {
		return price * quantity;
	}

	public void addProducts(int qtd) {
		// quantity = this.quantity + qtd;

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
}
