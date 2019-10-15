package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class AppWorker {
	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/YYYY");

		System.out.print("Enter department's name: ");
		String depto = sc.nextLine();

		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base salary: ");
		double salary = sc.nextDouble();

		Worker worker = new Worker(name, WorkerLevel.valueOf(level), salary, new Department(depto));

		System.out.print("How many contracts to this worker? ");
		int numContracts = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= numContracts; i++) {

			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date date = dateFormat.parse(sc.next());
			System.out.print("Value per hour: ");
			Double v_hour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();

			HourContract contract = new HourContract(date, v_hour, hours);

			worker.addContract(contract);
		}

		System.out.print("Enter month and year to calculate income (MM/YYYY):");
		String dateInc = sc.next();
		
		int month = Integer.parseInt(dateInc.substring(0,2));
		int year = Integer.parseInt(dateInc.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		
		System.out.println("Income for " + dateInc + ": "
				+ String.format("%.2f", worker.income(month, year)));


		sc.close();
	}
}
