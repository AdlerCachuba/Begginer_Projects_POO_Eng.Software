package lista1;

import java.util.Scanner;

public class Exercicio2 {
//Solicite uma letra ao usuário e verifique se é vogal ou consoante.
	
	public static void main(String args[]) {
		String letra;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite uma letra:");
		
		letra= teclado.nextLine();
		
		if (letra.equals("a")|| letra.equals("o") || letra.equals("u") ||letra.equals("i")|| letra.equals("e")) {
		System.out.println("É uma vogal");	
		}
		else {
			System.out.println("È uma consoantes");
		}		
		
	}
}
