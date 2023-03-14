package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class DAOGenerico<T> {

	private EntityManager manager;
	private EntityTransaction t;
	private Class<T> classe;

	public DAOGenerico(Class<T> classe) {
		this.classe = classe;
	}

	public T salvar(T entidade) {
		// criar gerenciador de entidade
		manager = Fabrica.get().createEntityManager();//
		// criar gerenciador de transações
		EntityTransaction t = manager.getTransaction();
		try { // tente
			t.begin(); // inicia a transação
			manager.persist(entidade); // salve o estado
			t.commit(); // confirma o estado
		} catch (Exception e) { // se der erro, captura e coloca no e
			e.printStackTrace(); // imprima o erro
			t.rollback(); // descarta tudo
		} finally {
			manager.close();
		}
		return entidade;
	}

	public T alterar(T entidade) {
		manager = Fabrica.get().createEntityManager();
		EntityTransaction t = manager.getTransaction();
		try {
			t.begin();
			manager.merge(entidade);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			manager.close();
		}
		return entidade;
	}

	public T buscarPorId(Long id) {
		// criar gerenciador de entidade
		manager = Fabrica.get().createEntityManager();//
		return manager.find(classe, id);
	}

	public List<T> listaComStatus(Class classe) {
		manager = Fabrica.get().createEntityManager();//
		try {
			Query query = manager.createQuery("from " + classe.getSimpleName() + " where status = true");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			manager.close();
		}

	}

	public T buscarCondicao(Class classeEntidade, String condicao) {

		manager = Fabrica.get().createEntityManager();

		try {
			Query query = manager.createQuery("from " + classeEntidade.getSimpleName() + " where " + condicao);
			return (T) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			manager.close();
		}
	}

	public List<T> listaComCondicao(Class classe, String condicao) {
		manager = Fabrica.get().createEntityManager();
		try {
			Query query = manager.createQuery("from " + classe.getSimpleName() + " where " + condicao);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			manager.close();
		}

	}

	public T retornarLogado(Class classe, String usuario) {
		manager = Fabrica.get().createEntityManager();
		Query q = null;
		try {
			q = manager.createQuery(
					"from " + classe.getSimpleName() + " where status = true and email = '" + usuario + "'");

			return (T) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			manager.close();
		}
	}

	public void updateSenha(String senha, String email) {
		manager = Fabrica.get().createEntityManager();
		EntityTransaction t = manager.getTransaction();
		String sql = "";
		try {
			t.begin();
			sql = ("update Pessoa set senha = '" + senha + "' where email like '" + email + "'");
			int update = manager.createQuery(sql).executeUpdate();
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		}

	}

}
