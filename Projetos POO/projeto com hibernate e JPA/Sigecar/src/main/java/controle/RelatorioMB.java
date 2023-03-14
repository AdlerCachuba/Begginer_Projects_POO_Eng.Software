package controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.hibernate.Session;

import DAO.DAOGenerico;
import modelo.Destino;
import modelo.Reserva;
import util.ChamarRelatorio;
import util.ExibirMensagem;
import util.Mensagem;

@ViewScoped
@ManagedBean
public class RelatorioMB  {


	private DAOGenerico<Reserva> daoRreserva = new DAOGenerico<Reserva>(Reserva.class); 
	
	
	public RelatorioMB() {
		
		
		
	}

	public void imprimirRelatorioReserva(Reserva reserva) {

		try {

			List<Reserva> listreservaServidorPendente = new ArrayList<>();

			listreservaServidorPendente = daoRreserva.listaComCondicao(Reserva.class,
					" status is true and areaServidor.servidor = '" + reserva.getAreaServidor().getServidor().getId()
							+ "'");

			if (listreservaServidorPendente.size() > 0) {
				
				
				ChamarRelatorio ch = new ChamarRelatorio();
				HashMap parametro = new HashMap<>();
				parametro.put("IDRESERV", reserva.getId());

				ch.imprimeRelatorio("ReservaSolicitada.jasper", parametro,
						"Relatório de Reserva Pendente " + reserva.getAreaServidor().getServidor().getNome());
 

			} else {
				ExibirMensagem.exibirMensagem("Nada Encontrado");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ExibirMensagem.exibirMensagem(Mensagem.ERRO);
		}
	}

}
