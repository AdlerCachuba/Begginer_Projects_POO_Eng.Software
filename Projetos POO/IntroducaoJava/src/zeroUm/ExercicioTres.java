package zeroUm;

import javax.swing.JOptionPane;

/*
 * Implemente uma classe que dever�, quando executada, solicitar pelo valor de um produto e pela 
quantia de meses (ou parcelas) que o usu�rio
ir� pagar. Ao final, o programa dever� emitir uma 
mensagem informando qual ser� o valor total do produto, sabendo
se que o valor produto recebe
um 
acr�scimo de 5% a cada m�s.  
Solicitar as informa��es ao usu�rio utilizando um 
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
		
		meses = JOptionPane.showInputDialog("Digite quantos meses voc� deseja parcelar:");
		mesesEmDouble = Double.parseDouble(meses);
		
		Double acrescimo = valorEmDouble * 0.05;
		System.out.println("O valor DO PRODUTO �:");
		System.out.println(valorEmDouble);
		Double valorTotal = ( valorEmDouble + (acrescimo * mesesEmDouble));
		
		System.out.println("O valor do acrescimo � de :" +acrescimo);
		System.out.println("O valor total mesmo com acrescimo � de :" + valorTotal);
		JOptionPane.showMessageDialog(null,"O valor total do produto �" + valorTotal);
		
	}
	
	
}
