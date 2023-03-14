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
import util.FechaDialog;
import util.Mensagem;
import util.UsuarioSessaoMB;

@ViewScoped
@ManagedBean
public class FluxoReservaMB {

	private DAOGenerico<Reserva> daoReserva = new DAOGenerico<Reserva>(Reserva.class);
	private DAOGenerico<Destino> daoDestino = new DAOGenerico<Destino>(Destino.class);

	private Reserva reserva;
	private Servidor servidor;
	private List<Reserva> listreserva;
	private List<Reserva> listReservaPendente;
	private List<Reserva> listReservaChefe;
	private List<Reserva> listReservaPendenteMotorista;
	private List<Reserva> listReservaConfirma;
	private List<Reserva> listReservaFinalizada;
	private List<Destino> listDestino;
	private UsuarioSessaoMB retornaUsuarios = new UsuarioSessaoMB();

	public FluxoReservaMB() {

		listreserva = new ArrayList<>();
		listReservaPendente = new ArrayList<>();
		listReservaChefe = new ArrayList<>();
		listReservaPendenteMotorista = new ArrayList<>();
		listReservaFinalizada = new ArrayList<>();
		listReservaConfirma = new ArrayList<>();
		reserva = new Reserva();
		servidor = new Servidor();
		listDestino = new ArrayList<>();

		// buscarReservaADM();
		// buscarReservaPendenteMotorista();

	}

	public void buscarReservaADM() {
		System.out.println("chamo o metodo carregar");

		listReservaPendente = daoReserva.listaComCondicao(Reserva.class,
				" status is true and autenticadoAdministrador  = 0");

	}

	public void buscarReservaChefe() {
		System.out.println("chamo o metodo carregar");

		listReservaChefe = daoReserva.listaComCondicao(Reserva.class,
				" status is true and autenticadoResponsavelServidor  = 3");

	}

	public List<Destino> getListDestino() {
		return listDestino;
	}

	public void setListDestino(List<Destino> listDestino) {
		this.listDestino = listDestino;
	}

	public void retornaServidor() {
		servidor = retornaUsuarios.recuperarServidor();
	}

	public void buscarReservaPendenteMotorista() {
		listReservaPendenteMotorista = daoReserva.listaComCondicao(Reserva.class,
				" status is true and situacaoReserva = 0 and autenticadoAdministrador  = 1");
	}

	public void buscarReservaConfirma() {

		retornaServidor();
		listReservaConfirma = daoReserva.listaComCondicao(Reserva.class,
				" status is true and situacaoReserva = 1 and autenticadoAdministrador  = 1 and areaServidor.servidor ='"
						+ servidor.getId() + "'");
	}

	public void buscarReservaFinalizada() {

		retornaServidor();

		if (servidor.getPerfil().equals("administrador")) {    

			listReservaFinalizada = daoReserva.listaComCondicao(Reserva.class,
					" status is true and situacaoReserva = 2 and autenticadoAdministrador  = 1 ");

		} else {
			listReservaFinalizada = daoReserva.listaComCondicao(Reserva.class,
					" status is true and situacaoReserva = 2 and autenticadoAdministrador  = 1 and areaServidor.servidor ='"
							+ servidor.getId() + "'");
		}
	}

	public void buscarDestinos() {
		listDestino = daoDestino.listaComCondicao(Destino.class, "  reserva = '" + reserva.getId() + "'");

		for (Destino d : listDestino) {
			System.out.println("destino " + d.getId());
		}
	}

	public void carregarReserva(Reserva reserv) {
		reserva = reserv;
	}

	public void validaReserva(Reserva reserv) {
		reserv.setDataValidadoRequerente(new Date());
		reserv.setSituacaoReserva(2);

		daoReserva.alterar(reserv);
		buscarReservaConfirma();
		ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
	}

	public void autorizar() {
		reserva.setAutenticadoAdministrador(1);
		reserva.setDataAutenticacaoAdm(new Date());
		daoReserva.alterar(reserva);

		FechaDialog.fecharDialogAutoriza();
		buscarReservaChefe();
		ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
	}

	public void autorizarChefe() {
		reserva.setAutenticadoAdministrador(0);
		reserva.setAutenticadoResponsavelServidor(1);
		reserva.setDataAutenticacaoChefe(new Date());
		daoReserva.alterar(reserva);

		FechaDialog.fecharDialogAutoriza();
		buscarReservaChefe();
		ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
	}

	public void finalizarReserva() {
		reserva.setSituacaoReserva(1);
		reserva.setDataFinalizacaoMotorista(new Date());
		daoReserva.alterar(reserva);

		FechaDialog.fecharDialogAutoriza();
		buscarReservaPendenteMotorista();
		ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
	}

	public void criarNovoObjeto() {

		reserva = new Reserva();
		listReservaPendente = new ArrayList<>();
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public List<Reserva> getListreserva() {
		return listreserva;
	}

	public void setListreserva(List<Reserva> listreserva) {
		this.listreserva = listreserva;
	}

	public List<Reserva> getListReservaPendente() {
		return listReservaPendente;
	}

	public void setListReservaPendente(List<Reserva> listReservaPendente) {
		this.listReservaPendente = listReservaPendente;
	}

	public List<Reserva> getListReservaPendenteMotorista() {
		return listReservaPendenteMotorista;
	}

	public void setListReservaPendenteMotorista(List<Reserva> listReservaPendenteMotorista) {
		this.listReservaPendenteMotorista = listReservaPendenteMotorista;
	}

	public List<Reserva> getListReservaConfirma() {
		return listReservaConfirma;
	}

	public void setListReservaConfirma(List<Reserva> listReservaConfirma) {
		this.listReservaConfirma = listReservaConfirma;
	}

	public List<Reserva> getListReservaFinalizada() {
		return listReservaFinalizada;
	}

	public void setListReservaFinalizada(List<Reserva> listReservaFinalizada) {
		this.listReservaFinalizada = listReservaFinalizada;
	}

	public List<Reserva> getListReservaChefe() {
		return listReservaChefe;
	}

	public void setListReservaChefe(List<Reserva> listReservaChefe) {
		this.listReservaChefe = listReservaChefe;
	}

}