package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingAccount;

public class Program {
	public static void main(String[] args) {
		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

		// upcasting

		Account acc1 = bacc;
		acc1.getBalance();
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingAccount(1004, "Anna", 0.0, 0.01);

		// downcasting

		BusinessAccount acc4 = (BusinessAccount) acc2;
		acc4.loan(100.0);

		// BusinessAccount acc5 = (BusinessAccount) acc3; // vai gerar erro em tempo de
		// execução pois o compilador não
		// reconhece previamente que acc3 não é compatível com
		// BusinessAccount

		// Método para realizar downcasting de maneira segura
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount) acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}

		if (acc3 instanceof SavingAccount) {
			SavingAccount acc5 = (SavingAccount) acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}

		Account acc6 = new SavingAccount(1002, "Maria", 1000.0, 0.01);
		acc6.withdraw(200.0);
		System.out.println(acc6.getBalance());

		Account acc7 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
		acc7.withdraw(200.0);
		System.out.println(acc7.getBalance());
	}
}
