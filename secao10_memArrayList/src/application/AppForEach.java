package application;

public class AppForEach {
	public static void main (String[] args) {
		String [] vect = new String[] {"maria","bob","alex"};
		
		for(String vector : vect) {
			System.out.println("Valor do vetor: "+vector);
		}
	}
}
