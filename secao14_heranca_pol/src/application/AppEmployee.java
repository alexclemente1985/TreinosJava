package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class AppEmployee {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of employees: ");
		int number = sc.nextInt();
		sc.nextLine();

		List<Employee> emps = new ArrayList<Employee>();

		for (int i = 1; i <= number; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced (y/n)? ");
			//char op = sc.nextLine().charAt(0);
			String op = sc.next();
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Hours: ");
			Integer hours = sc.nextInt();
			sc.nextLine();
			System.out.print("Value per hour: ");
			Double vhour = sc.nextDouble();
			sc.nextLine();

			Employee emp;

			//if (op == 'y') {
			if (op.toUpperCase().trim().equals("Y")) {
				System.out.print("Additional charge: ");
				Double additionalCharge = sc.nextDouble();
				sc.nextLine();
				emp = new OutsourcedEmployee(name, hours, vhour, additionalCharge);
			} else {
				emp = new Employee(name, hours, vhour);
			}

			emps.add(emp);

		}

		System.out.println("PAYMENTS:");

		for (Employee e : emps) {
			System.out.println(e);
		}

		sc.close();
	}
}
