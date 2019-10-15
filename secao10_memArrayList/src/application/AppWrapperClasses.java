package application;

public class AppWrapperClasses {
	public static void main (String[] args) {
		int x = 10;
		
		Integer y = x;
		
		System.out.println("Valor do objeto Integer:" +y);
		
		int z = y;//wrapper classes s�o convertidas naturalmente, sem a necessidade de casting (int); se y fosse tipo int, isso n�o seria poss�vel
		
		System.out.println("Valor do inteiro z:"+z);
		
		//Vantagem da Wrapper Class -> ideal para atributos que possam receber valores nulos, visto que tipos primitivos n�o s�o capazes disso;
		//--> Al�m disso, herdam todos os m�todos da classe Object
	}
}
