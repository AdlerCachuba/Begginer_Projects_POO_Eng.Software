package zeroUm;

import javax.swing.JOptionPane;

/*
 * O exercício é:
 * Crie uma classe no método principal solicite uma idade. Em seguida, apresente uma mensagem 

informando se é criança, adolescente, adulto ou idoso. Defina os intervalos de valores para classificar 

a idade entre essas categorias. O valor deverá ser solicitado ao usuário 

utilizando um 

JoptionPane.showInputDialog
 */

public class Exercicio {

	public static void main (String args[]) {
	String numero;
	int number;
	
	numero= JOptionPane.showInputDialog("Digite um número por favor:");
	number = Integer.parseInt(numero);
	
	if (number < 18){ 
		JOptionPane.showMessageDialog(null, "Menor de idade.");
		
	}
	else if (number>= 18 && number <=25) {
		JOptionPane.showMessageDialog(null, "É um jovem maior de idade, de 18 a 25.");
		
	}
	
	else if (number>25 && number <=40) {
		JOptionPane.showMessageDialog(null, "Já passou dos 25, mas cuidado,o max é 40 anos");
	}
	
	else if (number>40 && number<=70) {
		JOptionPane.showMessageDialog(null, "já passou dos 40, o max é 70");
	}
	else {
		JOptionPane.showMessageDialog(null, "Idoso ! É maior de 70 anos !!");
	}
	}

}
