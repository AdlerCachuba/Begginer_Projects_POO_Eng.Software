package zeroUm;

import javax.swing.JOptionPane;

/*
 * O exerc�cio �:
 * Crie uma classe no m�todo principal solicite uma idade. Em seguida, apresente uma mensagem 

informando se � crian�a, adolescente, adulto ou idoso. Defina os intervalos de valores para classificar 

a idade entre essas categorias. O valor dever� ser solicitado ao usu�rio 

utilizando um 

JoptionPane.showInputDialog
 */

public class Exercicio {

	public static void main (String args[]) {
	String numero;
	int number;
	
	numero= JOptionPane.showInputDialog("Digite um n�mero por favor:");
	number = Integer.parseInt(numero);
	
	if (number < 18){ 
		JOptionPane.showMessageDialog(null, "Menor de idade.");
		
	}
	else if (number>= 18 && number <=25) {
		JOptionPane.showMessageDialog(null, "� um jovem maior de idade, de 18 a 25.");
		
	}
	
	else if (number>25 && number <=40) {
		JOptionPane.showMessageDialog(null, "J� passou dos 25, mas cuidado,o max � 40 anos");
	}
	
	else if (number>40 && number<=70) {
		JOptionPane.showMessageDialog(null, "j� passou dos 40, o max � 70");
	}
	else {
		JOptionPane.showMessageDialog(null, "Idoso ! � maior de 70 anos !!");
	}
	}

}
