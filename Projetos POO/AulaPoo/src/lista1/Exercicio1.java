package lista1;

import java.util.Scanner;

public class Exercicio1 {

	public static void main (String args[]) {
	 //Solicite dois n�meros ao usu�rio e mostre o menor valor.
	
	int numeroum;
	int numerodois;
	Scanner tecladodois;
	Scanner teclado;
	teclado = new Scanner(System.in);
	System.out.println("Digite um valor para primeiro numero:");
	numeroum = teclado.nextInt();
	
	
	tecladodois = new Scanner(System.in);
	System.out.println("Digite um valor para o segundo n�mero");
	numerodois=tecladodois.nextInt();
	
	if (numeroum>numerodois) {
		System.out.println("O primeiro numero � maoir que o segundo");
	}
	
	else if (numeroum ==numerodois) {
		System.out.println("Os dois n�meros s�o iguais");
	}
	
	else {
		System.out.println("O segundo n�mero � maior que o primeiro");
	}
		
	
	
}
}
