package converter;
 
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import DAO.DAOGenerico;
import modelo.AreaServidor;
import util.Mensagem;

@FacesConverter("converteAreaServidorReserva")
public class ConverteAreaServidorReserva implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) { 
			try {
				DAOGenerico<AreaServidor>  dao = new DAOGenerico<AreaServidor>(AreaServidor.class);
				AreaServidor areaServidor =  (AreaServidor) dao.buscarPorId(Long.parseLong(value));
				return areaServidor;
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
			AreaServidor cur = (AreaServidor) object;
			return String.valueOf(cur.getId());
		} else {
			return null;
		}
	}
}
