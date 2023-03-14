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

import modelo.Cidade;
import modelo.Motorista;
import modelo.Servidor;
import modelo.Veiculo;
import util.CriptografiaSenha;
import util.ExibirMensagem;
import util.FechaDialog;
import util.Mensagem;

@ViewScoped
@ManagedBean
public class MotoristaMB {

	private Motorista motorista;
	private DAOGenerico<Motorista> daoMotorista;
	private DAOGenerico<Cidade> daoCidade;
	private List<Motorista> listMotorista;
	private List<Motorista> listMotoristaCadastroMomento;
	private List<Motorista> listMotoristaSelecionado;
	private List<Cidade> listCidade;
	private Long idMotorista;
	private boolean botaoSenha = true;

	public MotoristaMB() {
		listMotorista = new ArrayList<>();
		motorista = new Motorista();
		daoMotorista = new DAOGenerico<Motorista>(Motorista.class);
		daoCidade = new DAOGenerico<Cidade>(Cidade.class);
		listMotoristaCadastroMomento = new ArrayList<>();
		listMotoristaSelecionado = new ArrayList<>();
		listCidade = new ArrayList<>();
		atualiza();
		listCidade = daoCidade.listaComStatus(Cidade.class);
	}

	public void inicializar() {
		if (idMotorista != null) {
			motorista = daoMotorista.buscarPorId(idMotorista);
			botaoSenha = false;
		}
	}

	public void atualiza() {
		listMotorista = daoMotorista.listaComStatus(Motorista.class);
	}

	public void carregarDados(Motorista motorista) {
		this.motorista = motorista;

	}

	public void limparLista() {
		listMotoristaCadastroMomento.clear();

	}

	public void excluirSelecionados() {

		for (Motorista m : listMotoristaSelecionado) {
			System.out.println("motorista alterar " + m.getNome());
			m.setStatus(false);
			daoMotorista.alterar(m);
		}
		atualiza();
		ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
	}

	public void excluir() {

		try {
			motorista.setStatus(false);
			daoMotorista.alterar(motorista);
			ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
			atualiza();
			FacesContext.getCurrentInstance().getExternalContext().redirect("servidor-lista.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void inserir() {
		try {
			if (motorista.getId() == null) {
				motorista.setDataCadastro(new Date());
				motorista.setPerfil("motorista");
				motorista.setStatus(true);
				motorista.setSenha(CriptografiaSenha.criptografar(motorista.getSenha()));
				daoMotorista.salvar(motorista);
				ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
				atualiza();
			} else {
				daoMotorista.alterar(motorista);
				ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
				atualiza();
				if (idMotorista == null) {
					FechaDialog.fecharDialogEditarSenha();
				}
			}

			listMotoristaCadastroMomento.add(motorista);
			criarNovoObjeto();

			FacesContext.getCurrentInstance().getExternalContext().redirect("motorista-lista.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void criarNovoObjeto() {
		motorista = new Motorista();
	}

	public DAOGenerico<Cidade> getDaoCidade() {
		return daoCidade;
	}

	public void setDaoCidade(DAOGenerico<Cidade> daoCidade) {
		this.daoCidade = daoCidade;
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

	public List<Motorista> getListMotorista() {
		return listMotorista;
	}

	public void setListMotorista(List<Motorista> listMotorista) {
		this.listMotorista = listMotorista;
	}

	public List<Motorista> getListMotoristaSelecionado() {
		return listMotoristaSelecionado;
	}

	public void setListMotoristaSelecionado(List<Motorista> listMotoristaSelecionado) {
		this.listMotoristaSelecionado = listMotoristaSelecionado;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Long getIdMotorista() {
		return idMotorista;
	}

	public void setIdMotorista(Long idMotorista) {
		this.idMotorista = idMotorista;
	}

	public List<Motorista> getListMotoristaCadastroMomento() {
		return listMotoristaCadastroMomento;
	}

	public void setListMotoristaCadastroMomento(List<Motorista> listMotoristaCadastroMomento) {
		this.listMotoristaCadastroMomento = listMotoristaCadastroMomento;
	}

}