package entities;

public class Conta {
	private int numero;
	private String nomeTitular;
	private double saldo;

	public int getNumero() {
		return numero;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public double getSaldo() {
		return saldo;
	}

	public Conta(String nomeTitular, int numero, double depInit) {
		this.nomeTitular = nomeTitular;
		this.numero = numero;
		deposito(depInit);
	}

	public Conta(String nomeTitular, int numero) {
		this.nomeTitular = nomeTitular;
		this.numero = numero;
	}

	public Conta() {

	}

	public void deposito(double dep) {
		this.saldo += dep;
	}

	public void saque(double saq) {
		this.saldo -= (saq + 5);

	}

	public String toString() {
		return "Account " + this.numero + ", Holder: " + this.nomeTitular + ", Balance: $ "
				+ String.format("%.2f", this.saldo);
	}

}
