package zeroUm;

import java.util.Scanner;

public class ExercicioCinco {

	
	  static int[] numeros = new int[3];
	    static int codigo;
	    static Scanner entrada = new Scanner(System.in);
	    static int maiornumero;
	    static int segundonumero;
	    static int ultimonumero;
	    public static void main(String[] args) {

	        System.out.println("Preencha o vetor com numeros reais");

	        // AQUI PREENCHO MEU VETOR, NOTE QUE USO A VARIAV�L numeros.length
	        // POIS ME PERMITE PEGAR O TAMANHO DO VETOR,INDEPENDENTE DO TAMANHO DELE
	        for (int i = 0; i < numeros.length; i++) {
	            System.out.print("Informe o " + i + "� n�mero : ");
	            numeros[i] = entrada.nextInt();
	        }
	        
	        
	        
	        // MOSTRO O MENU DE OP��ES
	        System.out.println("1 � Ordem indireta.");
	        System.out.println("2 � Ordem direta.");
	        System.out.println("0 � finalizar programa.");


	        // LEIO O C�DIGO =
	        //PELO USU�RIO
	        System.out.print("Informe um c�digo para ler vetor : ");
	        codigo = entrada.nextInt();

	        // E FA�O OS DEVIDOS TESTES
	        if(codigo == 0)
	            System.out.println("Voc� finalizou o pograma !!");

	        // NOTE QUE UTILIZO O if else if
	        else if(codigo == 1){

	            // NESTE TRECHO : (numeros.length - 1) EU PEGO O TAMANHO DO VETOR MENOS 1
	            // POIS OS INDICES DOS VETORES S�O CONTATOS APARTIR DE 0 .. 1 ..2 E
	            // NESTE TRECHO : i > -1 VERIFICO SE O i � MAIOR QUE -1, POIS N�O EXISTE O INDICE -1
	            // PARA VETORES COMO DESCRITO ACIMA
	            for (int i = (numeros.length - 1); i > -1; i--) {
	                  System.out.println("N�meros : " + numeros[i]);
	            }
	        }

	        else if(codigo == 2){
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
	        	}
	        	System.out.println("O maior numero � "+maiornumero);
	        	System.out.println("O segundo maior n�mero �"+segundonumero);
	        	System.out.println("O ultimo numero �" + ultimonumero);
	        		
	  //          for (int i = 0; i < numeros.length; i++) {
	    //            System.out.println("N�meros : " + numeros[i]);
	            }
	        

	        // AQUI N�O PRECISO TESTAR SE ELE � DIFERENTE DE 0 1 2 , POIS SE N�O � NENHUM DELES
	        // COMO FOI TESTADO ACIMA ELE SER� REALMENTE DIFERENTE
	    //    else {
	     //       System.out.println("C�digo invalido !!");
	//
	    

	}
	

