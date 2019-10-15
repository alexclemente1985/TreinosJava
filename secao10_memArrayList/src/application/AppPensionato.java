package application;

import java.text.ParseException;
import java.util.Scanner;

import entities.Aluguel;

public class AppPensionato {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o número de estudantes que irão alugar quartos: ");

		int N = sc.nextInt();
		sc.nextLine();

		Aluguel[] alugueis = new Aluguel[N];
		Aluguel aluguel = new Aluguel();
		

		int num;
		int index;
		boolean ok = false;
		boolean vazio = true;
		boolean qtoOcup = true;

		for (int i = 0; i < N; i++) {

			index = i + 1;
			System.out.println("Informe o nome do estudante " + index + ":");
			String nome = sc.nextLine();

			System.out.println("Informe o email do estudante " + index + ":");
			String email = sc.nextLine();

			System.out.println("Informe o quarto a ser escolhido para o estudante " + index + ":");
			num = sc.nextInt();
			sc.nextLine();

			while (!(num >= 0 && num <= 9)) {
				System.out.println("Número de quarto inexistente!");
				System.out.println("Informe novamente quarto a ser escolhido para o estudante " + index + ":");
				num = sc.nextInt();
				sc.nextLine();
			}

			// String check;

			for (int k = 0; k < alugueis.length; k++) {
				if (alugueis[k] != null) {
					vazio = false;
					break;
				}
			}

			if (vazio == true) {
				aluguel = new Aluguel(nome, email, num);
				alugueis[i] = aluguel;
			} else {

				while (ok == false) {
					for (int j = 0; j < alugueis.length; j++) {
						if (alugueis[j] != null) {
							if (alugueis[j].getQuarto().getNumero() == num
									&& alugueis[j].getQuarto().isOcupado() == true) {
								System.out.println(
										"Quarto " + alugueis[j].getQuarto().getNumero() + " já se encontra ocupado!");

								System.out.println(
										"Informe novamente quarto a ser escolhido para o estudante " + index + ":");
								num = sc.nextInt();
								sc.nextLine();
								qtoOcup = true;
								break;
								// continue;
							} else {
								qtoOcup = false;
								continue;
							}
						}else {
							break;
						}

					}
					if (qtoOcup == false) {
						ok = true;
					}

				}
				aluguel = new Aluguel(nome, email, num);
				alugueis[i] = aluguel;

				ok = false;

			}

		}

		for (int i = 0; i < alugueis.length; i++) {
			System.out.println(alugueis[i]);
		}
		sc.close();

	}

}
