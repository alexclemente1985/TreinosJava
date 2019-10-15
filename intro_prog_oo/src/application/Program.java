package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		/*
		 * double xA, xB, xC, yA, yB, yC;
		 */
		Triangle x,y;
		x = new Triangle();
		y = new Triangle();
		
		System.out.println("Informe as medidas do triângulo X: ");

		/*
		 * xA = sc.nextDouble(); xB = sc.nextDouble(); xC = sc.nextDouble();
		 */
		
		x.a = sc.nextDouble();
		x.b = sc.nextDouble();
		x.c = sc.nextDouble();

		System.out.println("Informe as medidas do triângulo Y: ");

		/*
		 * yA = sc.nextDouble(); yB = sc.nextDouble(); yC = sc.nextDouble();
		 */
		
		y.a = sc.nextDouble();
		y.b = sc.nextDouble();
		y.c = sc.nextDouble();
		
		/*
		 * double perimetro = (xA + xB + xC)/2; double areaX = Math.sqrt(perimetro
		 * *(perimetro - xA)*(perimetro - xB)*(perimetro - xC));
		 */
		
		/*
		 * double px = (x.a+x.b+x.c)/2; double py = (y.a+y.b+y.c)/2;
		 */
		
		/* perimetro = (yA + yB + yC)/2; */
		
		/*
		 * double areaY = Math.sqrt(perimetro *(perimetro - yA)*(perimetro -
		 * yB)*(perimetro - yC));
		 */
		
		/*
		 * double areax = Math.sqrt(px*(px-x.a)*(px-x.b)*(px-x.c)); double areay =
		 * Math.sqrt(py*(py-y.a)*(py-y.b)*(py-y.c));
		 */
		
		double areax = x.area();
		double areay = y.area();
		
		/*
		 * System.out.printf("Área do triângulo X: %.4f%n",areaX);
		 * System.out.printf("Área do triângulo Y: %.4f%n",areaY);
		 */
		
		System.out.printf("Área do triângulo X: %.4f%n",areax);
		System.out.printf("Área do triângulo Y: %.4f%n",areay);
		
		/*
		 * if(areaX>areaY) { System.out.println("Maior área: X ->"+areaX); }else {
		 * System.out.println("Maior área: Y ->"+areaY); }
		 */
		
		if(areax>areay) {
			System.out.println("Maior área: X ->"+areax);
		}else {
			System.out.println("Maior área: Y ->"+areay);
		}
		
		sc.close();
		
		
	}

}
