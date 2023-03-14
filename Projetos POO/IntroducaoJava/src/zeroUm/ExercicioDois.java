package zeroUm;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class ExercicioDois {
	public static void main (String args[]) {

		//variavel para o nome
	String nome;	
	
		//peço para ele digitar
	nome = JOptionPane.showInputDialog("Digite o seu nome completo, por favor:");
	
		//faço uma contagem de qual o tamanho do nome
	Integer contagemdoNome = nome.length();	
	
		//e crio um index conforme os espaços.
	int i = nome.indexOf(" ");
		
	JOptionPane.showMessageDialog(null, "O seu primeiro nome é:" + nome.substring(0,i));

	JOptionPane.showMessageDialog(null, "O seu nome inteiro tem "+ contagemdoNome +" letras");

	JOptionPane.showMessageDialog(null, "O seu primeiro nome é:" + nome.substring(0,i));
	
	String[] textoSeparado = nome.split(" ");
	for (int x=0; x<textoSeparado.length;x++) {
		System.out.println(textoSeparado[x]);
	}
	

	JOptionPane.showMessageDialog(null, textoSeparado);
	
	}
}
