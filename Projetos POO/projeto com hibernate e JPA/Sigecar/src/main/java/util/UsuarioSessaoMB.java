package util;
 
 

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import DAO.DAOGenerico;
import modelo.Motorista;
import modelo.Pessoa;
import modelo.Servidor;

@SessionScoped
@Named("usuarioSessaoMB")
public class UsuarioSessaoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Pessoa  pessoa;
	private Pessoa  pessoaLogada;
	private Servidor servidor;
	private Motorista motorista; 


    DAOGenerico<Pessoa> daoPessoa = new DAOGenerico<Pessoa>(Pessoa.class);
    DAOGenerico<Servidor> daoServidor = new DAOGenerico<Servidor>(Servidor.class);
    DAOGenerico<Motorista> daoMotorista = new DAOGenerico<Motorista>(Motorista.class);

	
	 public UsuarioSessaoMB() { 
		pessoa = new Pessoa();
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			Authentication authentication = context.getAuthentication(); 
			if (authentication instanceof Authentication) {
				String pessoaRtorn = ((User)authentication.getPrincipal()).getUsername(); 
				retornaPessoa(pessoaRtorn);
				
			}
		}
		 
		
	}
	 
	public Pessoa retornaPessoa(String email){ 
		try {
			pessoa = (Pessoa) daoPessoa.retornarLogado(Pessoa.class, email);
		} catch (Exception e) {
		e.printStackTrace();
		}
		return pessoa;
		
		
	}
 
	
	public Servidor recuperarServidor() {
	
		servidor = new Servidor();
	
		try {
			servidor = (Servidor) daoServidor.retornarLogado(Servidor.class, pessoa.getEmail());
		} catch (Exception e) {
		}
		return servidor;
	}
	
	public Motorista recuperarMotorista() {
		
		motorista = new Motorista();
	
		try {
			motorista = (Motorista) daoMotorista.retornarLogado(Motorista.class, pessoa.getEmail());
		} catch (Exception e) {
		}
		return motorista;
	}
	
	public Pessoa recuperarPessoa() {
		
		pessoaLogada = new Pessoa();
	
		try {
			pessoaLogada = daoPessoa.retornarLogado(Pessoa.class, pessoa.getEmail());
		} catch (Exception e) {
		}
		return pessoaLogada;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public Servidor getServidor() {
		return servidor;
	}


	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
	
	
	 
}
