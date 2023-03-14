
package teste;

import DAO.DAOGenerico;
import DAO.Fabrica;

import javax.persistence.EntityManager;
import modelo.Cidade;
import modelo.Servidor;


public class Teste {
    
    public static void main(String args[]){
        Fabrica.get();
  // Fabrica.get().createEntityManager();//
          /*para criar as tabelas mude para criar no persistence e se não criar em alguma classe MB
         no construtor coloque para chamar o arquivo entityManager*/
         // Fabrica.get();
        
//       Estado estado = new Estado();
//        estado.setNome("teste");
//        estado.setSigla("es");
//        
//        DAOGenerico<Estado> dao = new DAOGenerico<Estado>();
//        dao.salvar(estado);
//        
        
    }
}
