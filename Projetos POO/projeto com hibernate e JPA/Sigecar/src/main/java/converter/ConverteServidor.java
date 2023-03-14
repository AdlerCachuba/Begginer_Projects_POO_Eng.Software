package converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import DAO.DAOGenerico;
import modelo.Servidor;
import util.Mensagem;

@FacesConverter("converterServidor")
public class ConverteServidor implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		
		System.out.println("valor "+value);
		if (value != null && value.trim().length() > 0) {
			System.out.println("ta aqui");
			try {
				DAOGenerico<Servidor>  dao = new DAOGenerico<Servidor>(Servidor.class);
				Servidor curso =  (Servidor) dao.buscarPorId(Long.parseLong(value));
				System.out.println("valodddr "+curso.getNome());
				
				return curso;
			} catch (Exception e) {
				e.printStackTrace();
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, Mensagem.ERROCONVERTER, ""));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			Servidor cur = (Servidor) object;
			return String.valueOf(cur.getId());
		} else {
			return null;
		}
	}
}
