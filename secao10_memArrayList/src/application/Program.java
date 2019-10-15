package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o tamanho do vetor:");
		int n = sc.nextInt();
		
		double[] vet = new double[n];
		
		System.out.println("Informe os valores do vetor:");
		for(int i=0; i<n;i++) {
			vet[i]=sc.nextDouble();
		}
		
		double soma=0;
			
		for(int i=0;i<n;i++) {
			int index = i+1;
			System.out.println("Posição "+index+": "+vet[i]);
			
			soma+=vet[i];
		}
		
		double media = soma/(vet.length);
		
		System.out.println("Média dos valores: "+String.format("%.2f", media));
		
		sc.close();

	}

}
