package zeroUm;

import javax.swing.JOptionPane;

public class ExercicioTresSegundoJeito {

	public static void main (String[] args) {
		// diga o valor
		Double valorProduto = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto:"));
	
		int parcelas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de parcelas:"));
		
		//Juros compostos
		for(int x=0; x<parcelas; x++) {
			valorProduto=valorProduto*1.05;
		}
		System.out.println("valor final do produto"+valorProduto);
		
		// Double resultado = valorPoduto*Math.pow(1.05, parcelas);
		// System.out.println("Valor final"+resultado);
	
	}
	
}
