package zeroUm;


import java.util.Scanner;

import javax.swing.JOptionPane;

public class ExercicioQuatro{
	public static void main(String[] args) {
		String valores = JOptionPane.showInputDialog("Digite valores separados por ,");
		
		String[] listaNumeros = valores.split(",");
		// lista n�meros � uma lista, a qual possui todas as posi��es confromes os n�meros.
		// come�ando pela posi��o zero da lista, com o primeiro n�mero que ele colocou
		
		for(int x= (listaNumeros.length-1); x>=0 ; x--) {
			System.out.println(listaNumeros[x]);
		}
		
				
				
				
	}
	
}
