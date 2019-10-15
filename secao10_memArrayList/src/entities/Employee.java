package entities;

public class Employee {
	Integer Id;
	String name;
	Double salary;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return this.Id+", "+this.name+", "+String.format("%.2f", this.salary);
	}
	
	public void increaseSal(double perc) {
		this.salary += this.salary*(perc/100);
	}
	
	public Employee(int id, String name, double sal) {
		this.Id=id;
		this.name=name;
		this.salary=sal;
	}
}
