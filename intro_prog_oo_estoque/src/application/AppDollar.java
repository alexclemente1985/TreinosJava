package application;

import java.util.Locale;
import java.util.Scanner;

import utils.CurrencyConverter;

public class AppDollar {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("What is the dollar price? ");
		double cot = sc.nextDouble(); 
		
		System.out.print("How many dollars will be bought? ");
		double qtddollar = sc.nextDouble();
		
		System.out.println(CurrencyConverter.showConversion(cot, qtddollar));
		
		sc.close();
	}

}
