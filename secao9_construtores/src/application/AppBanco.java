package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Conta;

public class AppBanco {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		Conta account = new Conta();

		System.out.print("Enter account number: ");
		int number = scan.nextInt();
		
		//Recurso para consumir o \n que fica implícito no final do comando acima, permitindo passar para o próximo comando 
		scan.nextLine();
		
		System.out.print("Enter accont holder: ");
		String holder = scan.nextLine();

		System.out.print("Is there an initial deposit (y/n)? ");
		char op = scan.next().toLowerCase().charAt(0);
		System.out.println(op);

		if (op == 'y') {
			System.out.print("Enter initial deposit value: ");
			double value = scan.nextDouble();

			account = new Conta(holder, number, value);
		} else {
			account = new Conta(holder, number);
		}
		System.out.println("");
		System.out.println("Account data:");
		System.out.println(account);
		
		System.out.println("");
		System.out.print("Enter a deposit value: ");
		account.deposito(scan.nextDouble());
		
		System.out.println("");
		System.out.println("Updated account data:");
		System.out.println(account);
		
		System.out.println("");
		System.out.print("Enter a withdraw value: ");
		account.saque(scan.nextDouble());
		
		System.out.println("");
		System.out.println("Updated account data:");
		System.out.println(account);
		
		scan.close();

	}

}
