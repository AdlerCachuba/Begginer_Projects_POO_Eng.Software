package converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import DAO.DAOGenerico;
import modelo.Cidade;
import util.Mensagem;

@FacesConverter("converterCidade")
public class ConverteCidade implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			System.out.println("ta aqui");
			try {
				DAOGenerico<Cidade>  dao = new DAOGenerico<Cidade>(Cidade.class);
				Cidade curso =  (Cidade) dao.buscarPorId(Long.parseLong(value));
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
			Cidade cur = (Cidade) object;
			return String.valueOf(cur.getId());
		} else {
			return null;
		}
	}
}
