package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Produto;

public class AppEstoque {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Produto prod = new Produto();

		int qtd;
		
		System.out.println("Informe o produto a ser inserido no estoque");
		prod.setName(sc.nextLine()); 

		System.out.println("Informe o valor do produto " + prod.getName() + ":");
		prod.setPrice(sc.nextDouble());

		System.out.println("Informe a quantidade do produto:");
		prod.setQuantity(sc.nextInt());

		/*
		 * System.out.println("Dados do produto: " + prod.getName() + ", $" +
		 * prod.getPrice() + ", " + prod.getQuantity() + " unidades -> TOTAL: $ " +
		 * prod.totalValueInStock());
		 */
		
		//chama o toString mesmo não informando, pois ocorre uma sobrescrita do método
		System.out.println("Dados do produto: " + prod);
		
		System.out.println("Informe a quantidade de "+prod.getName()+" a ser adicionada no estoque:");
		qtd = sc.nextInt();
		prod.addProducts(qtd);
		
		/*
		 * System.out.println("Dados atualizados do produto: " + prod.getName() + ", $"
		 * + prod.getPrice() + ", " + prod.getQuantity() + " unidades -> TOTAL: $ " +
		 * prod.totalValueInStock());
		 */
		
		System.out.println("Dados atualizados do produto: " + prod);
		
		System.out.println("Informe a quantidade de "+prod.getName()+" a serem removida");
		qtd = sc.nextInt();
		prod.removeProducts(qtd);
		
		/*
		 * System.out.println("Dados atualizados do produto: " + prod.getName() + ", $"
		 * + prod.getPrice() + ", " + prod.getQuantity() + " unidades -> TOTAL: $ " +
		 * prod.totalValueInStock());
		 */
		
		System.out.println("Dados atualizados do produto: " + prod);
		
		sc.close();
	}

}
