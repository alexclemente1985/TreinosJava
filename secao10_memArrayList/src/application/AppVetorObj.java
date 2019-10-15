package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class AppVetorObj {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o tamanho do vetor: ");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("Informe os produtos a serem adicionados: ");
		
		Product[] vetor = new Product[n];
		
		String name;
		double price;
		
		for(int i=0;i<vetor.length;i++) {
			int index = i+1;
			
			System.out.println("Informe o nome do produto "+index+":");
			name = sc.nextLine();
						
			System.out.println("Informe o preço do produto "+index+":");
			price = sc.nextDouble();
			
			vetor[i] = new Product(name,price);
			
			sc.nextLine();
		}
		
		double soma = 0;
				
		for(int i=0;i<vetor.length;i++) {
			int index = i+1;
			System.out.println("Produto "+index+": "+ vetor[i].getName()+" Preço: "+vetor[i].getPrice());
			
			soma+=vetor[i].getPrice();
						
		}
		
		double media = soma/vetor.length;
		
		String mediaStr = String.format("%.2f",media);
		//String mediaStr;
		//mediaStr = String.format("%.2f",media);
		//String mediaF = String.format("%.2f", mediaStr);
		
		System.out.println("Média dos preços dos produtos: "+mediaStr);
	
		sc.close();

	}

}
