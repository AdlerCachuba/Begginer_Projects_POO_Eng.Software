package zeroUm;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class ExercicioDois {
	public static void main (String args[]) {

		//variavel para o nome
	String nome;	
	
		//pe�o para ele digitar
	nome = JOptionPane.showInputDialog("Digite o seu nome completo, por favor:");
	
		//fa�o uma contagem de qual o tamanho do nome
	Integer contagemdoNome = nome.length();	
	
		//e crio um index conforme os espa�os.
	int i = nome.indexOf(" ");
		
	JOptionPane.showMessageDialog(null, "O seu primeiro nome �:" + nome.substring(0,i));

	JOptionPane.showMessageDialog(null, "O seu nome inteiro tem "+ contagemdoNome +" letras");

	JOptionPane.showMessageDialog(null, "O seu primeiro nome �:" + nome.substring(0,i));
	
	String[] textoSeparado = nome.split(" ");
	for (int x=0; x<textoSeparado.length;x++) {
		System.out.println(textoSeparado[x]);
	}
	

	JOptionPane.showMessageDialog(null, textoSeparado);
	
	}
}
