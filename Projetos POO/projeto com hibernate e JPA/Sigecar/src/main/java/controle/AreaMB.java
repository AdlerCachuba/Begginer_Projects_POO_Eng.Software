package controle;

import DAO.DAOGenerico;
import modelo.Area;
import modelo.Servidor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import util.ExibirMensagem;
import util.FechaDialog;
import util.Mensagem;

@ViewScoped
@ManagedBean
public class AreaMB {
	// agora aqui iremos ter q renomear tudo para area
	private Area area; // tudo q ta area vai mudar para area // vou mudar apenas
						// o basico para te mostrar o selectOnMenu
	private DAOGenerico<Area> daoArea;
	private DAOGenerico<Servidor> daoServidor;
	private List<Area> listArea = new ArrayList<>();
	private List<Servidor> listServidor;
	private List<Area> listSelecionados;
	private Long idArea;

	public AreaMB() {
		area = new Area();
		listSelecionados = new ArrayList<>();
		daoArea = new DAOGenerico<Area>(Area.class);
		daoServidor = new DAOGenerico<Servidor>(Servidor.class);
		listArea = daoArea.listaComStatus(Area.class);
		listServidor = new ArrayList<>();
		listServidor = daoServidor.listaComStatus(Servidor.class);
		atualiza();
	}

	public void inicializar() {
		if (idArea != null) {
			area = daoArea.buscarPorId(idArea);
		}
	}

	public void atualiza() {
		listArea = daoArea.listaComStatus(Area.class);
	}

	public void excluirSelecionados() {
		for (Area v : listSelecionados) {
			v.setStatus(false);
			daoArea.alterar(v);
		}
		atualiza();
		ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
	}

	public void excluir() {
		try {

			area.setStatus(false);
			daoArea.alterar(area);
			atualiza();
			ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
			FacesContext.getCurrentInstance().getExternalContext().redirect("area-lista.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// public void carregarDados(Estado estado) {
	// this.estado = estado;
	//
	// }

	// public void excluir(Estado estado) {
	// estado.setStatus(false);
	// daoEstado.alterar(estado);
	// ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
	// atualiza();
	// }

	public void inserir() {
		try {

			area.setStatus(true);
			area.setDataCadastro(new Date());
			daoArea.alterar(area);
			ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
			atualiza();
			criarNovoObjeto();
			FacesContext.getCurrentInstance().getExternalContext().redirect("area-lista.xhtml");
		} catch (Exception e) {
			ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
			e.printStackTrace();

		}
	}

	public void criarNovoObjeto() {
		area = new Area();
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Area> getListArea() {
		return listArea;
	}

	public void setListArea(List<Area> listArea) {
		this.listArea = listArea;
	}

	public List<Area> getListSelecionados() {
		return listSelecionados;
	}

	public void setListSelecionados(List<Area> listSelecionados) {
		this.listSelecionados = listSelecionados;
	}

	public Long getIdArea() {
		return idArea;
	}

	public void setIdArea(Long idArea) {
		this.idArea = idArea;
	}

	public List<Servidor> getListServidor() {
		return listServidor;
	}

	public void setListServidor(List<Servidor> listServidor) {
		this.listServidor = listServidor;
	}

}