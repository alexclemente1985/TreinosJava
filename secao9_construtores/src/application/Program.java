package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

			System.out.println("Informe o produto a ser inserido no estoque");
		String name = sc.next(); 

		System.out.println("Informe o valor do produto " + name + ":");
		double price = sc.nextDouble();

		/*
		 * System.out.println("Informe a quantidade do produto:"); int qtd =
		 * sc.nextInt();
		 * 
		 * Product prod = new Product(name,price,qtd);
		 * System.out.println("Dados do produto: " + prod);
		 */		
		
		Product prod = new Product(name, price);
		System.out.println("Dados do produto: " + prod);
		
		System.out.println("Informe a quantidade de "+name+" a ser adicionada no estoque:");
		//qtd = sc.nextInt();
		int qtd = sc.nextInt();
		prod.addProducts(qtd);
		
		
		
		System.out.println("Dados atualizados do produto: " + prod);
		
		System.out.println("Informe a quantidade de "+prod.getName()+" a serem removida");
		qtd = sc.nextInt();
		prod.removeProducts(qtd);
		
	
		System.out.println("Dados atualizados do produto: " + prod);
		
		sc.close();
	}

}
