package zeroUm;

import javax.swing.JOptionPane;

/*
 * Implemente uma classe que deverá, quando executada, solicitar pelo valor de um produto e pela 
quantia de meses (ou parcelas) que o usuário
irá pagar. Ao final, o programa deverá emitir uma 
mensagem informando qual será o valor total do produto, sabendo
se que o valor produto recebe
um 
acréscimo de 5% a cada mês.  
Solicitar as informações ao usuário utilizando um 
JoptionPane.showInputDialog
 */
public class ExercicioTres {

	public static void main (String[] args) {
		
		String valor;
		String meses;
		Double valorEmDouble;
		Double mesesEmDouble;
		
		valor = JOptionPane.showInputDialog("Digite o valor do produto:");
		valorEmDouble = Double.parseDouble(valor);
		
		meses = JOptionPane.showInputDialog("Digite quantos meses você deseja parcelar:");
		mesesEmDouble = Double.parseDouble(meses);
		
		Double acrescimo = valorEmDouble * 0.05;
		System.out.println("O valor DO PRODUTO É:");
		System.out.println(valorEmDouble);
		Double valorTotal = ( valorEmDouble + (acrescimo * mesesEmDouble));
		
		System.out.println("O valor do acrescimo é de :" +acrescimo);
		System.out.println("O valor total mesmo com acrescimo é de :" + valorTotal);
		JOptionPane.showMessageDialog(null,"O valor total do produto é" + valorTotal);
		
	}
	
	
}
