package lista1;

import java.util.Scanner;

public class Exercicio1 {

	public static void main (String args[]) {
	 //Solicite dois números ao usuário e mostre o menor valor.
	
	int numeroum;
	int numerodois;
	Scanner tecladodois;
	Scanner teclado;
	teclado = new Scanner(System.in);
	System.out.println("Digite um valor para primeiro numero:");
	numeroum = teclado.nextInt();
	
	
	tecladodois = new Scanner(System.in);
	System.out.println("Digite um valor para o segundo número");
	numerodois=tecladodois.nextInt();
	
	if (numeroum>numerodois) {
		System.out.println("O primeiro numero é maoir que o segundo");
	}
	
	else if (numeroum ==numerodois) {
		System.out.println("Os dois números são iguais");
	}
	
	else {
		System.out.println("O segundo número é maior que o primeiro");
	}
		
	
	
}
}
