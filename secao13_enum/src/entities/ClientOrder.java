package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.ClientOrderStatus;

public class ClientOrder {
	private Date moment;
	private ClientOrderStatus status;
	private Client client;
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

	public ClientOrder() {

	}

	public ClientOrder(Client client, ClientOrderStatus status) {
		this.client = client;
		this.status = status;
		this.moment = new Date();
	}

	public Date getMoment() {
		return moment;
	}

	public ClientOrderStatus getStatus() {
		return status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem orderItem) {
		this.orderItems.add(orderItem);
	}

	public void removeItem(OrderItem orderItem) {
		this.orderItems.remove(orderItem);
	}

	public Double total() {
		Double sum = 0.00;
		for (OrderItem oit : this.orderItems) {
			sum += oit.subTotal();
		}
		return sum;
	}

	public StringBuilder invoice() {
		StringBuilder string = new StringBuilder();

		string.append("ORDER SUMMARY: \n");
		string.append("Order moment: " + sdf.format(this.moment) + "\n");
		string.append("Order status: " + this.status + "\n");
		string.append("Client: " + this.client.getName() + " (" + sdf2.format(this.client.getBirthDate()) + ") - "
				+ this.client.getEmail() + "\n");

		string.append("Order items:\n");

		for (OrderItem oit : this.orderItems) {
			string.append(oit.getProduct().getName() + ", $" + String.format("%.2f",oit.getPrice()) + ", Quantity: " + oit.getQuantity()
					+ ", Subtotal: $" + String.format("%.2f", oit.subTotal()) + "\n");
		}
		string.append("Total price: $" + String.format("%.2f", total()) + "\n");

		return string;
	}

}
