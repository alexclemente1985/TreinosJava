package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class AppEmpresa {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.print("How many employees will be registered? ");
		int qtd = sc.nextInt();

		List<Employee> emps = new ArrayList<Employee>();

		int index;

		for (int i = 0; i < qtd; i++) {
			index = i + 1;
			System.out.println("Employee #" + index);

			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Salary: ");
			double sal = sc.nextDouble();
			sc.nextLine();

			emps.add(new Employee(id, name, sal));
		}

		System.out.print("Enter the employee id that will have salary increase: ");

		int id = sc.nextInt();
		sc.nextLine();

		Employee empInc = emps.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

		if (empInc == null) {
			System.out.println("This id does not exist!");

			printEmp(emps);
		} else {
			System.out.print("Enter the percentage: ");
			double perc = sc.nextDouble();
			sc.nextLine();

			empInc.increaseSal(perc);

			printEmp(emps);
		}

		sc.close();

	}

	private static void printEmp(List<Employee> list) {
		System.out.println("List of employees:");

		for (Employee emp : list) {
			System.out.println(emp.toString());
		}

	}

}
