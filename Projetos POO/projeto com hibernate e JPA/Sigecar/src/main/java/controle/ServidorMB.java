package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import DAO.DAOGenerico;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Area;
import modelo.AreaServidor;
import modelo.Cidade;
import modelo.Servidor;
import util.CriptografiaSenha;
import util.ExibirMensagem;
import util.FechaDialog;
import util.Mensagem;

@ViewScoped
@ManagedBean
public class ServidorMB {

	private Servidor servidor;
	private DAOGenerico<Servidor> daoServidor;
	private AreaServidor areaServidorAdiciona;
	private Area areaServidor;
	private DAOGenerico<Cidade> daoCidade;
	private DAOGenerico<Area> daoArea;
	private DAOGenerico<AreaServidor> daoAreaServidor;
	private List<Servidor> listServidor = new ArrayList<>();
	private List<Servidor> listServidorCadastroMomento;
	private List<Servidor> listServidorSelecionado;
	private List<Cidade> listCidade;
	private List<Area> listArea;
	private List<Area> listAreaAdicionada;
	private Long idServidor;
	private boolean botaoSenha = true;

	public ServidorMB() {
		servidor = new Servidor();
		areaServidorAdiciona = new AreaServidor();
		areaServidor = new Area();
		daoServidor = new DAOGenerico<Servidor>(Servidor.class);
		daoAreaServidor = new DAOGenerico<AreaServidor>(AreaServidor.class);
		daoCidade = new DAOGenerico<Cidade>(Cidade.class);
		daoArea = new DAOGenerico<Area>(Area.class);
		listServidorCadastroMomento = new ArrayList<>();
		listServidorSelecionado = new ArrayList<>();
		listArea = new ArrayList<>();
		listAreaAdicionada = new ArrayList<>();
		listCidade = new ArrayList<>();
		atualiza();
		listCidade = daoCidade.listaComStatus(Cidade.class);
	}

	public void inicializar() {
		if (idServidor != null) {
			servidor = daoServidor.buscarPorId(idServidor);
			botaoSenha = false;

			listAreaAdicionada.clear();
			for (AreaServidor p : daoAreaServidor.listaComCondicao(AreaServidor.class,
					" status is true and servidor = '" + servidor.getId() + "'")) {
				listAreaAdicionada.add(p.getAreaServidor());
			}

		}
	}

	public void adicionar() {
		if (servidor.getId() == null) {
			if (listAreaAdicionada.size() == 0) {
				listAreaAdicionada.add(areaServidor);
			} else {
				if (validaArea()) {
					listAreaAdicionada.add(areaServidor);
				} else {
					ExibirMensagem.exibirMensagem(Mensagem.AREASERVIDOR);
				}
			}
		} else {

			if (validaAreaAdicionada(areaServidor)) {
				ExibirMensagem.exibirMensagem(Mensagem.AREASERVIDOR);
			} else {

				areaServidorAdiciona.setAreaServidor(areaServidor);
				areaServidorAdiciona.setDataCadastro(new Date());
				areaServidorAdiciona.setServidor(servidor);
				areaServidorAdiciona.setStatus(true);

				daoAreaServidor.salvar(areaServidorAdiciona);

				areaServidorAdiciona = new AreaServidor();
				ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
				inicializar();
				atualiza();
			}
		}

	}

	public boolean validaAreaAdicionada(Area areaValida) {
		List<AreaServidor> listAreaAdiciona = new ArrayList<>();
		listAreaAdiciona = daoAreaServidor.listaComCondicao(AreaServidor.class,
				" status  is true and servidor = " + servidor.getId() + " and areaServidor = " + areaValida.getId());
		if (listAreaAdiciona.size() > 0)
			return true;

		return false;
	}

	public boolean validaArea() {

		for (Area a : listAreaAdicionada) {
			if (a.getDescricao().equals(areaServidor.getDescricao())) {
				return false;
			}
		}
		return true;
	}

	public void removeArea(Area area) {
		if (servidor.getId() == null) {
			listAreaAdicionada.remove(area);
		} else {
			AreaServidor areaExcluir = new AreaServidor();
			areaExcluir = daoAreaServidor.buscarCondicao(AreaServidor.class,
					" status is true and areaServidor = " + area.getId() + " and servidor = " + servidor.getId());
			areaExcluir.setStatus(false);
			daoAreaServidor.alterar(areaExcluir);
			areaExcluir = new AreaServidor();
			inicializar();
			atualiza();

		}
	}

	public void atualiza() {

		listArea = daoArea.listaComStatus(Area.class);
		listServidor = daoServidor.listaComStatus(Servidor.class);
	}

	public void carregarDados(Servidor servidor) {
		this.servidor = servidor;

	}

	public void limparLista() {
		listServidorCadastroMomento.clear();

	}

	public void excluirSelecionados() {

		for (Servidor v : listServidorSelecionado) {
			System.out.println("servidor alterar " + v.getNome());
			v.setStatus(false);
			daoServidor.alterar(v);
		}
		atualiza();
		ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
	}

	public void excluir() {

		try {
			servidor.setStatus(false);
			daoServidor.alterar(servidor);
			ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
			atualiza();
			FacesContext.getCurrentInstance().getExternalContext().redirect("servidor-lista.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void inserir() {

		try {
			if (listAreaAdicionada.size() == 0) {
				ExibirMensagem.exibirMensagem(Mensagem.SELECIONAPERMISSAO);
			} else {

				if (servidor.getId() == null) {
					servidor.setDataCadastro(new Date());
					servidor.setStatus(true);
					servidor.setSenha(CriptografiaSenha.criptografar(servidor.getSenha()));
					daoServidor.salvar(servidor);

					for (Area a : listAreaAdicionada) {
						areaServidorAdiciona.setAreaServidor(a);
						areaServidorAdiciona.setDataCadastro(new Date());
						areaServidorAdiciona.setServidor(servidor);
						areaServidorAdiciona.setStatus(true);

						daoAreaServidor.salvar(areaServidorAdiciona);

						areaServidorAdiciona = new AreaServidor();
					}

					ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
					atualiza();
				} else {
					servidor.setSenha(CriptografiaSenha.criptografar(servidor.getSenha()));
					daoServidor.alterar(servidor);

					ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
					atualiza();
					if (idServidor == null) {
						FechaDialog.fecharDialogEditarSenha();
					}
				}

				listServidorCadastroMomento.add(servidor);
				criarNovoObjeto();

				FacesContext.getCurrentInstance().getExternalContext().redirect("servidor-lista.xhtml");

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// public boolean validaAreaAltera(Area a){
	// List<AreaServidor> listArea = new ArrayList<>();
	// listArea = daoAreaServidor.listaComCondicao(AreaServidor.class, " status
	// is true and servidor = "+servidor.getId());
	//
	// for(AreaServidor ar : listArea){
	// if(ar.get){
	//
	// }
	// }
	//
	// return true;
	// }

	public void criarNovoObjeto() {
		servidor = new Servidor();
		areaServidorAdiciona = new AreaServidor();
		listAreaAdicionada = new ArrayList<>();
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public DAOGenerico<Servidor> getDaoServidor() {
		return daoServidor;
	}

	public void setDaoServidor(DAOGenerico<Servidor> daoServidor) {
		this.daoServidor = daoServidor;
	}

	public List<Servidor> getListServidor() {
		return listServidor;
	}

	public void setListServidor(List<Servidor> listServidor) {
		this.listServidor = listServidor;
	}

	public List<Servidor> getListServidorCadastroMomento() {
		return listServidorCadastroMomento;
	}

	public void setListServidorCadastroMomento(List<Servidor> listServidorCadastroMomento) {
		this.listServidorCadastroMomento = listServidorCadastroMomento;
	}

	public List<Servidor> getListServidorSelecionado() {
		return listServidorSelecionado;
	}

	public void setListServidorSelecionado(List<Servidor> listServidorSelecionado) {
		this.listServidorSelecionado = listServidorSelecionado;
	}

	public Long getIdServidor() {
		return idServidor;
	}

	public void setIdServidor(Long idServidor) {
		this.idServidor = idServidor;
	}

	public boolean isBotaoSenha() {
		return botaoSenha;
	}

	public void setBotaoSenha(boolean botaoSenha) {
		this.botaoSenha = botaoSenha;
	}

	public List<Cidade> getListCidade() {
		return listCidade;
	}

	public void setListCidade(List<Cidade> listCidade) {
		this.listCidade = listCidade;
	}

	public List<Area> getListAreaAdicionada() {
		return listAreaAdicionada;
	}

	public void setListAreaAdicionada(List<Area> listAreaAdicionada) {
		this.listAreaAdicionada = listAreaAdicionada;
	}

	public Area getAreaServidor() {
		return areaServidor;
	}

	public void setAreaServidor(Area areaServidor) {
		this.areaServidor = areaServidor;
	}

	public List<Area> getListArea() {
		return listArea;
	}

	public void setListArea(List<Area> listArea) {
		this.listArea = listArea;
	}

}
