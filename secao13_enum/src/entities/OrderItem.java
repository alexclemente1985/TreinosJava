package entities;

public class OrderItem {
	private Integer quantity;
	private Double price;
	private Product product = new Product();

	public OrderItem() {

	}

	public OrderItem(Product product, Integer qtd) {
		this.product = product;
		this.quantity = qtd;
		this.price = product.getPrice();
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}

	public Double getPrice() {
		return price;
	}

	public Double subTotal() {
		Double subtotal = this.price * this.quantity;

		return subtotal;
	}

}
