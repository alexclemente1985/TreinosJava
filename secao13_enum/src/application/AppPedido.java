package application;

import java.text.ParseException;
import java.util.Scanner;

import entities.Client;
import entities.ClientOrder;
import entities.OrderItem;
import entities.Product;
import entities.enums.ClientOrderStatus;

public class AppPedido {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter client data:");

		System.out.print("Name: ");
		String name = sc.nextLine();

		System.out.print("Email: ");
		String email = sc.nextLine();

		System.out.print("Birth date (DD/MM/YYYY): ");
		String bdate = sc.nextLine();

		Client client = new Client(name, email, bdate);

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.nextLine();

		ClientOrder order = new ClientOrder(client, ClientOrderStatus.valueOf(status.toUpperCase()));

		System.out.print("How many items to this order? ");
		int qtd = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= qtd; i++) {
			System.out.println("Enter #" + i + " item data:");

			System.out.print("Product name: ");
			String pname = sc.nextLine();

			System.out.print("Product price: ");
			Double pprice = sc.nextDouble();
			sc.nextLine();

			System.out.print("Quantity: ");
			int pqtd = sc.nextInt();
			sc.nextLine();

			Product prod = new Product(pname, pprice);

			OrderItem oit = new OrderItem(prod, pqtd);

			order.addItem(oit);
		}

		System.out.println(order.invoice());

		sc.close();
	}
}
