package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;

	// 1 depto por trabalhador | n trabalhadores por depto
	private Department department;

	// n contratos por trabalhador | 1 trabalhador por contrato de trabalho
	private List<HourContract> contracts = new ArrayList<HourContract>();

	public Worker() {

	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {

		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
		// lista de contratos não é inserida aqui pois não se deve fazer isso para
		// composição "tem-muitos"
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public String toString() {
		return null;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	public Double income(Integer month, Integer year) {
		double sum = baseSalary;
		int c_year;
		int c_month;

		Calendar cal = Calendar.getInstance();

		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			c_year = cal.get(Calendar.YEAR);
			c_month = 1 + cal.get(Calendar.MONTH);

			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
}
