package lista1;

import java.util.Scanner;

/*
 * 
 * Uma empresa precisa realizar entrevistas dom v�rias pessoas.
 *  Os dados necess�rios s�o: nome, ano de nascimento, sexo,escolaridade e estado civil.
 *   Com o ano de nascimento � necess�rio que o programa calcule a idade da pessoa. 
 *   Fa�a umprograma que colete os dados das pessoas e 
 *   informe quantos entrevistados com menos de 20 anos s�o casados.
 */

public class Exercicio4 {
	public static void main (String args[]) {
		
		String nome;
		int anoNasc;
		String sexo;
		String escolaridade;
		String estadoCivil;
		
		Scanner teclado;
		teclado = new Scanner(System.in);
		System.out.println("Digte seu nome:");
		nome = teclado.nextLine();
		
		teclado=new Scanner(System.in);
		System.out.println("Digite o ano do seu nascimento");
		anoNasc= teclado.nextInt();
		
		teclado = new Scanner(System.in);
		System.out.println("Digite qual seu g�nero, 0 para masculino, 1 para feminino");
		sexo= teclado.nextLine();
		
		
		
	}
}
