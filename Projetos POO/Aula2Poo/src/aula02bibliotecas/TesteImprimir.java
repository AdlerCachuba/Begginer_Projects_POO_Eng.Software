package aula02bibliotecas;

import java.util.Scanner;

// public � modificador de acesso
public class TesteImprimir {

	public static void main(String[] args) {
		
		Subtracao subtracaodenumeros = new Subtracao();
		
		Somar somaImportada = new Somar();
		//somaImportada � um objeto e � uma variavel
		// do tipo Somar 
		// por ser um objeto precisa instanciar um novo.
		
		//toda classe possui caracteristicas e metodos.
		
		
	//	System � classe
	//	out � variavel
	//	println � um m�todo que pertende a classe system
	//	o parametro dele � o ""
		System.out.println("Digite o num1:");
		Scanner scan = new Scanner(System.in);
		//Scan tamb�m � uma variavel
		
		//somaImportada � um objeto
		somaImportada.num1= scan.nextInt();		
		//objeto: somaImportada
		subtracaodenumeros.num1Sub=somaImportada.num1;
		
		System.out.println("Digite o num2:");
		somaImportada.num2= scan.nextInt();
		subtracaodenumeros.num2Sub=somaImportada.num2;
		
		int total = somaImportada.somarNumero();
		System.out.println("O total da soma �:"+total);
		
		//total � uma vari�vel porque foi definida 
		int totalSubtracao = subtracaodenumeros.Subtracao1e2();
		System.out.println("A subtracao de num1 por num2 �:"+totalSubtracao);
	}
	
}
