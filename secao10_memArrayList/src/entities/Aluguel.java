package entities;

public class Aluguel {
	private Quarto quarto = new Quarto();
	private Estudante estudante = new Estudante();
	
	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(int num, boolean ocup) {
		this.quarto.setNumero(num);
		this.quarto.setOcupado(ocup);
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(String name, String email) {
		
		this.estudante.setName(name);
		this.estudante.setEmail(email);
	}
	
	public Aluguel(String estName, String estEmail, int quartNum) {
		/*
		 * this.estudante.setName(estName); this.estudante.setEmail(estEmail);
		 */
		
		setEstudante(estName,estEmail);
		
		this.quarto.setNumero(quartNum);
		this.quarto.setOcupado(true);
	}
	
	public Aluguel() {
		
	}
	
	
	
	public String toString() {
		return "Quarto "+this.quarto.getNumero()+" -> Estudante: "+this.estudante.getName()+" | Email: "+this.estudante.getEmail();
	}

}
