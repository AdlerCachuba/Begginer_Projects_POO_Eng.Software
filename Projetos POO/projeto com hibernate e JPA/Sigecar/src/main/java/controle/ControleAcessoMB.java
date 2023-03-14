package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import DAO.DAOGenerico;
import modelo.Area;
import modelo.AreaServidor;
import modelo.Cidade;
import modelo.Destino;
import modelo.Motorista;
import modelo.Pessoa;
import modelo.Reserva;
import modelo.Servidor;
import modelo.Veiculo;
import util.ExibirMensagem;
import util.Mensagem;
import util.UsuarioSessaoMB;

@SessionScoped
@ManagedBean
public class ControleAcessoMB {

	private Pessoa pessoaLogada;
	private Motorista motoristaLogado;
	private UsuarioSessaoMB retornaUsuarios;
	private boolean comum = false;
	private boolean administrador = false; 
	private boolean motorista = false;
	private boolean controleChefe = false;
	private DAOGenerico<Area> daoArea;
 

	public ControleAcessoMB() {
		pessoaLogada = new Pessoa();
		motoristaLogado = new Motorista();
		retornaUsuarios = new UsuarioSessaoMB();
		retornaLogado();
		daoArea = new DAOGenerico<Area>(Area.class);
	 
	}

	public void retornaLogado(){
		pessoaLogada = retornaUsuarios.recuperarPessoa();
	}
	
	 

	
	public void inicializar(){
		
		System.out.println("cara logado "+pessoaLogada.getPerfil());
		
		if(pessoaLogada.getPerfil().equals("administrador")){
			administrador = true;
			comum = false;
			motorista = false;
		}else if(pessoaLogada.getPerfil().equals("motorista")){
			administrador = false;
			comum = false;
			motorista = true;
		}else{
			administrador = false;
			comum = true;
			motorista = false;
		}
		
		List<Area> listArea = daoArea.listaComCondicao(Area.class, " status is true and servidorResponsavel = '"+pessoaLogada.getId()+"'");
		if(listArea.size() > 0){
			controleChefe = true;
		}

	}

 

	public Pessoa getPessoaLogada() {
		return pessoaLogada;
	}

	public void setPessoaLogada(Pessoa pessoaLogada) {
		this.pessoaLogada = pessoaLogada;
	}

	public boolean isComum() {
		return comum;
	}

	public void setComum(boolean comum) {
		this.comum = comum;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public boolean isMotorista() {
		return motorista;
	}

	public void setMotorista(boolean motorista) {
		this.motorista = motorista;
	}

	public boolean isControleChefe() {
		return controleChefe;
	}

	public void setControleChefe(boolean controleChefe) {
		this.controleChefe = controleChefe;
	}
	



	
	
	
	
}