import java.util.Locale;
import java.util.Scanner;




public class Main {

	public static void main(String[] args) {

		int y = 32;
		double x=10.3554;
		System.out.println(y);
		System.out.println(x);
		System.out.println("texto2");
		/*
		 * System.out.printf("%.2f%n",x); System.out.printf("%.4f%n",x);
		 * 
		 * Locale.setDefault(Locale.US); System.out.printf("%.4f%n", x);
		 * 
		 * System.out.println("Valor " + x);
		 * 
		 * System.out.printf("Valor: %.2f metros%n",x);
		 * 
		 * String nome="Maria"; int idade=33; double salario=2700.898;
		 * 
		 * System.out.printf("A %s tem %d anos e ganha %.2f reais%n",
		 * nome,idade,salario);
		 */
		
		/*
		 * double a = 5.9; int b;
		 * 
		 * b = (int) a;
		 * 
		 * System.out.println("a = "+a+" b = "+b);
		 * 
		 * 
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * String z; z = sc.next(); System.out.println("Valor :"+z);
		 * 
		 * 
		 * int w; w = sc.nextInt(); System.out.println("Valor :"+w);
		 * 
		 * double q; q = sc.nextDouble(); System.out.println("Valor :"+q);
		 * 
		 * char s; s = sc.next().charAt(0); System.out.println("Digitou :"+s);
		 * 
		 * 
		 * String str,str2,str3; str = sc.nextLine(); str2 = sc.nextLine(); str3 =
		 * sc.nextLine();
		 * 
		 * System.out.println(str); System.out.println(str2); System.out.println(str3);
		 * 
		 * sc.close();
		 */
		
		
		/*
		 * Scanner scan = new Scanner(System.in);
		 * 
		 * int valor;
		 * 
		 * System.out.println("Informe o valor:"); valor = scan.nextInt();
		 * 
		 * if(valor >5) { System.out.println("Valor maior que 5"); }else {
		 * System.out.println("Valor menor que 5"); }
		 * 
		 * String avaliacao = valor >5 ?
		 * "Valor maior que 5 (ternário)":"Valor menor que 5 (ternário)";
		 * 
		 * System.out.println(avaliacao);
		 * 
		 * scan.close();
		 */
		
		int n1=89;
		int n2=60;
		
		//bitwise (baixo nível -> redes, arduíno, etc)
		//e (compara bit a bit se ambos são 1 -> verdadeiro)
		System.out.println(n1 & n2);
		//ou (compara bit a bit se ao menos um dos dois é 1)
		System.out.println(n1 | n2);
		//ou exclusivo (compara se somente um é 1)
		System.out.println(n1^n2);
		
		Scanner scan2 = new Scanner(System.in);
		
		int mask = 0b00100000;
		int n = scan2.nextInt();
		
		if((n&mask)!=0) {
			System.out.println("sexto bit é verdadeiro");
		}else {
			System.out.println("sexto bit é falso");
		}
		
		scan2.close();
		
		
		String original = "abcde FGHIJ abc DEFG";
		
		String s01 = original.toLowerCase();
		String s02 = original.toUpperCase();
		String s03 = original.trim();
		String s04 = original.substring(2);
		String s05 = original.substring(2,9);
		String s06 = original.replace('a','x');
		String s07 = original.replace("abc","xy");
		int i08 = original.indexOf("bc");
		int i09 = original.lastIndexOf("bc");
				
		System.out.println(original);
		System.out.println(s01);
		System.out.println(s02);
		System.out.println(s03);
		System.out.println(s04);
		System.out.println(s05);
		System.out.println(s06);
		System.out.println(s07);
		System.out.println(i08);
		System.out.println(i09);
		
		String[] strings = original.split(" ");
		
		for(String words:strings) {
			System.out.println(words);
		}
		
	}

}
