package exercicioMaster;

import java.util.ArrayList;
import java.util.Scanner;

public class ExercicioCarros {
	public static void main(String args[]) {
		int usuario = 0;
		
		do {
		Scanner digita = new Scanner (System.in);

		Carro carro = new Carro();
		System.out.println("Digite a cor do carro: ");
		carro.cor = digita.nextLine();
		
		System.out.println("Digite o ano do carro: ");
		carro.ano = digita.nextInt();
		
		System.out.println("Digite true se for novo: ");
		carro.novo = digita.nextBoolean();
		
		System.out.println("Digite o preço: ");
		carro.preco = digita.nextDouble();
		
		ArrayList <Carro> carrolista = new ArrayList();
		carrolista.add(carro);
		
		System.out.println("Cadastrar outro carro?1 para sim ");
		usuario = digita.nextInt();
		
		
		}while(usuario != 0);
			
		
		
	}

}
