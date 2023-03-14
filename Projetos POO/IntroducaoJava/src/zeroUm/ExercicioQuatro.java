package zeroUm;


import java.util.Scanner;

import javax.swing.JOptionPane;

public class ExercicioQuatro{
	public static void main(String[] args) {
		String valores = JOptionPane.showInputDialog("Digite valores separados por ,");
		
		String[] listaNumeros = valores.split(",");
		// lista números é uma lista, a qual possui todas as posições confromes os números.
		// começando pela posição zero da lista, com o primeiro número que ele colocou
		
		for(int x= (listaNumeros.length-1); x>=0 ; x--) {
			System.out.println(listaNumeros[x]);
		}
		
				
				
				
	}
	
}
