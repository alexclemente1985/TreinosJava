package application;

public class AppWrapperClasses {
	public static void main (String[] args) {
		int x = 10;
		
		Integer y = x;
		
		System.out.println("Valor do objeto Integer:" +y);
		
		int z = y;//wrapper classes são convertidas naturalmente, sem a necessidade de casting (int); se y fosse tipo int, isso não seria possível
		
		System.out.println("Valor do inteiro z:"+z);
		
		//Vantagem da Wrapper Class -> ideal para atributos que possam receber valores nulos, visto que tipos primitivos não são capazes disso;
		//--> Além disso, herdam todos os métodos da classe Object
	}
}
