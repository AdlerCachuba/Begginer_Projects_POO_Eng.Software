package zeroUm;

import javax.swing.JOptionPane;

public class ExercicioCincoSegundoJeito {
	
	
	public static void main(String[] args) {
		
	    int maiornumero = 0;
	    int segundonumero =0;
	    int ultimonumero =0;
		
		String numerosStr = JOptionPane.showInputDialog("Digite valores separados por ,");

		
		// divisão do vetor por virgulas, e coloca nas casas do vetor, 
		// o primeiro na casa 0 do vetor
		String[] numerosSplit = numerosStr.split(",");
		
		// fala que o vetor int[]  tem o mesmo tamanho do vetor sprint.
		int[] numeros= new int[numerosSplit.length];
		
		
		//Como colocar a lista STR para INT, vc tem q definir a lista int ter o mesmo tamanho
		for (int i=0 ; i<numerosSplit.length ; i++  ) {
			numeros[i]= Integer.parseInt(numerosSplit[i]);
		}
			

		
		// os graus de comparação com as casas dos vetores
      	if ( numeros[0] >  numeros[1] && numeros[0] > numeros[2]) {
    		maiornumero = numeros[0];
    		
    		if (numeros[1]>numeros[2]) {
    			segundonumero = numeros[1];
    			ultimonumero=numeros[2];
    		}
    		
    		else {
    			segundonumero = numeros[2];
    			ultimonumero =numeros[1];		
    		}
    	}
    		
    	if (numeros[1] >  numeros[0] && numeros[1] > numeros[2]) {
    		maiornumero = numeros[1];
    		
    		if (numeros[0]>numeros[2]) {
    			segundonumero=numeros[0];
    			ultimonumero=numeros[2];
    			
    			}
    		else {
    			segundonumero = numeros[2];
    			ultimonumero = numeros[0];
    			
    		}
    	}
    	
    	if (numeros[2] >  numeros[0] && numeros[2] > numeros[1]) {
    		maiornumero = numeros[2];
    		
    		if (numeros[0] > numeros[1]) {
    			segundonumero = numeros[0];
    			ultimonumero = numeros[1];
    			       			
    		}
    		
    		else {
    			segundonumero = numeros[1];
    			ultimonumero = numeros[0];
    		}			
    			
    		}
    	System.out.println("O maior numero é "+maiornumero);
    	System.out.println("O segundo maior número é "+segundonumero);
    	System.out.println("O ultimo numero é " + ultimonumero);

    	}

	
    	
}


