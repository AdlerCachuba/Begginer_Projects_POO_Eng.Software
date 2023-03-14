
package DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.internal.SessionFactoryImpl;
//import org.hibernate.jpa.internal.EntityManagerImpl;

 
public class Fabrica {
    
   //classe responsavel em criar o gerenciador de entidades "entity manager", ele é muito pesado por isso só cria um, para
    //criar um utilizamos o static. 
    
    private static EntityManagerFactory fabrica;
    
    
    static{
        fabrica = Persistence.createEntityManagerFactory("sigecarPU");
    }
    
    //o atributo é private então temos que criar o metodo para retornar a fabrica 
    
    public static  EntityManagerFactory get(){
        return fabrica;
    }
    
    
    public static Connection getConnection() {
    	
    	 
    	
//		EntityManagerImpl factory = (EntityManagerImpl) fabrica;
//		SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) factory.getSession().getSessionFactory();
//		try {
//			return sessionFactoryImpl.getConnectionProvider().getConnection();
//		} catch (SQLException ex) {
//			Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
//		}
		return null;
	}


}


