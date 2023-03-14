package aula02bibliotecas;

import java.util.Scanner;

// public é modificador de acesso
public class TesteImprimir {

	public static void main(String[] args) {
		
		Subtracao subtracaodenumeros = new Subtracao();
		
		Somar somaImportada = new Somar();
		//somaImportada é um objeto e é uma variavel
		// do tipo Somar 
		// por ser um objeto precisa instanciar um novo.
		
		//toda classe possui caracteristicas e metodos.
		
		
	//	System é classe
	//	out é variavel
	//	println é um método que pertende a classe system
	//	o parametro dele é o ""
		System.out.println("Digite o num1:");
		Scanner scan = new Scanner(System.in);
		//Scan também é uma variavel
		
		//somaImportada é um objeto
		somaImportada.num1= scan.nextInt();		
		//objeto: somaImportada
		subtracaodenumeros.num1Sub=somaImportada.num1;
		
		System.out.println("Digite o num2:");
		somaImportada.num2= scan.nextInt();
		subtracaodenumeros.num2Sub=somaImportada.num2;
		
		int total = somaImportada.somarNumero();
		System.out.println("O total da soma é:"+total);
		
		//total é uma variável porque foi definida 
		int totalSubtracao = subtracaodenumeros.Subtracao1e2();
		System.out.println("A subtracao de num1 por num2 é:"+totalSubtracao);
	}
	
}
