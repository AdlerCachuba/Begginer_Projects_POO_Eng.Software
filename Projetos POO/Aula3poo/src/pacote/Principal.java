package pacote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Principal {
	public static void main(String[] args) {
		Positivo p= new Positivo();
		p.setNumero(5);
		if (p.verificar()) {
			System.out.println("Positivo");
		}
		else {
			System.out.println("Negativo");
		}
		
		
		
		//url
		String url = "jdbc:mysql://localhost:3306/banco?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,"");
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO ESTADO" 
					+  "(NOME,SIGLA) VALUES ('p','p')");
			
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
