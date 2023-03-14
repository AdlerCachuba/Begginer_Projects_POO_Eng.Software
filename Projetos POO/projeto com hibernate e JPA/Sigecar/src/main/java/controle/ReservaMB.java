package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import DAO.DAOGenerico;
import modelo.AreaServidor;
import modelo.Cidade;
import modelo.Destino;
import modelo.Reserva;
import modelo.Servidor;
import modelo.Veiculo;
import util.ExibirMensagem;
import util.Mensagem;
import util.UsuarioSessaoMB;

@ViewScoped
@ManagedBean
public class ReservaMB {

	private DAOGenerico<Reserva> daoReserva = new DAOGenerico<Reserva>(Reserva.class);
	private DAOGenerico<Cidade> daoCidade = new DAOGenerico<Cidade>(Cidade.class);
	private DAOGenerico<Destino> daoDestino = new DAOGenerico<Destino>(Destino.class);
	private DAOGenerico<Veiculo> daoVeiculo = new DAOGenerico<Veiculo>(Veiculo.class);
	private DAOGenerico<AreaServidor> daoAreaServidor = new DAOGenerico<AreaServidor>(AreaServidor.class);

	private Reserva reserva;
	private Servidor servidor;
	private Veiculo veiculo;
	private Destino destino;
	private List<Cidade> listCidade;
	private List<Veiculo> listVeiculo;
	private List<Reserva> listreserva;
	private List<Reserva> listreservaServidor;
	private List<Reserva> listreservaServidorPendente;
	private List<Destino> listDestino;
	private List<AreaServidor> listAreaServidor;
	private UsuarioSessaoMB retornaUsuarios = new UsuarioSessaoMB();

	public ReservaMB() {

		listreserva = new ArrayList<>();
		listDestino = new ArrayList<>();
		listCidade = new ArrayList<>();
		listAreaServidor = new ArrayList<>();
		listVeiculo = new ArrayList<>();
		listreservaServidor = new ArrayList<>();
		listreservaServidorPendente = new ArrayList<>();
		reserva = new Reserva();
		veiculo = new Veiculo();
		servidor = new Servidor();
		destino = new Destino();
		listCidade = daoCidade.listaComStatus(Cidade.class);
		retornaServidor();
		buscarReservaPendente();
		listAreaServidor = daoAreaServidor.listaComCondicao(AreaServidor.class,
				"status = true and servidor = " + servidor.getId());

	}

	public void retornaServidor() {
		servidor = retornaUsuarios.recuperarServidor();
	}

	public void atualiza() {
		listreserva = daoReserva.listaComStatus(Reserva.class);
	}

	public void carregarReserva(Reserva reserv) {
		reserva = reserv;
	}

	public void adiciona() {
		listDestino.add(destino);
		destino = new Destino();

	}

	public void excluir() {
		reserva.setStatus(false);
		daoReserva.alterar(reserva);
		atualiza();
		ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
	}

	public void inserir() {
		boolean validaChefe = false;
		listVeiculo = daoVeiculo.listaComStatus(Veiculo.class);
		for (Veiculo v : listVeiculo) {
			veiculo = v;
		}

		try {

			if (listDestino.size() > 0) {
				if (reserva.getId() == null) {

					for (Destino destino : listDestino) {

						if (!destino.getCidade().getNome().equalsIgnoreCase("paranavaí")) {
							validaChefe = true;
						}
					}

					if (validaChefe) {
						reserva.setAutenticadoAdministrador(3);
						reserva.setAutenticadoResponsavelServidor(3);
					} else {
						reserva.setAutenticadoAdministrador(0);
						reserva.setAutenticadoResponsavelServidor(0);
					}

					reserva.setStatus(true);
					reserva.setSituacaoReserva(0);
					reserva.setData(new Date());
					reserva.setVeiculo(veiculo);

					daoReserva.salvar(reserva);
					for (Destino d : listDestino) {
						d.setReserva(reserva);
						daoDestino.salvar(d);
						d = new Destino();
					}

					ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
					atualiza();
					criarNovoObjeto();
					FacesContext.getCurrentInstance().getExternalContext().redirect("reserva-lista.xhtml");
					buscarReservaPendente();
				}
				
				

			} else {
				ExibirMensagem.exibirMensagem(Mensagem.DESTINO);
			}

		} catch (Exception e) {
			ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
			e.printStackTrace();
		}

	}

	public void buscarDestinos() {
		listDestino = daoDestino.listaComCondicao(Destino.class, "  reserva = '" + reserva.getId() + "'");

		for (Destino d : listDestino) {
			System.out.println("destino " + d.getId());
		}
	}

	public void buscarReservaPendente() {
		System.out.println("id do servidor logado ");
		listreservaServidorPendente = daoReserva.listaComCondicao(Reserva.class,
				" status is true and areaServidor.servidor = '" + servidor.getId() + "'");
	}

	public void criarNovoObjeto() {

		reserva = new Reserva();
		destino = new Destino();
		listDestino = new ArrayList<>();
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<Reserva> getListreserva() {
		return listreserva;
	}

	public void setListreserva(List<Reserva> listreserva) {
		this.listreserva = listreserva;
	}

	public List<Destino> getListDestino() {
		return listDestino;
	}

	public void setListDestino(List<Destino> listDestino) {
		this.listDestino = listDestino;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public List<Cidade> getListCidade() {
		return listCidade;
	}

	public void setListCidade(List<Cidade> listCidade) {
		this.listCidade = listCidade;
	}

	public List<Reserva> getListreservaServidor() {
		return listreservaServidor;
	}

	public void setListreservaServidor(List<Reserva> listreservaServidor) {
		this.listreservaServidor = listreservaServidor;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public List<Reserva> getListreservaServidorPendente() {
		return listreservaServidorPendente;
	}

	public void setListreservaServidorPendente(List<Reserva> listreservaServidorPendente) {
		this.listreservaServidorPendente = listreservaServidorPendente;
	}

	public List<AreaServidor> getListAreaServidor() {
		return listAreaServidor;
	}

	public void setListAreaServidor(List<AreaServidor> listAreaServidor) {
		this.listAreaServidor = listAreaServidor;
	}

}