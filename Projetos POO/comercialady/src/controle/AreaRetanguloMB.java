package controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import modelo.Retangulo;

@ManagedBean
public class AreaRetanguloMB {

	

	Retangulo retangulo = new Retangulo();
	
	public void calcular(){
		retangulo.setArea(retangulo.getBase() * retangulo.getAltura());
		   
	}

	public Retangulo getRetangulo() {
		return retangulo;
	}

	public void setRetangulo(Retangulo retangulo) {
		this.retangulo = retangulo;
	}


	
}
