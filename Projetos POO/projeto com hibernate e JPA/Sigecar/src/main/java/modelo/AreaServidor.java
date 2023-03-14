package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_areaServidor")
public class AreaServidor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private boolean status;
	private Date dataCadastro;
  
	@ManyToOne
	private Servidor servidor;
	
	@ManyToOne
	private Area areaServidor;
	
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
 
	public Servidor getServidor() {
		return servidor ;
	}

	public void setServidor(Servidor servidorResponsavel) {
		this.servidor  = servidorResponsavel;
	}

	public Area getAreaServidor() {
		return areaServidor;
	}

	public void setAreaServidor(Area areaServidor) {
		this.areaServidor = areaServidor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaServidor == null) ? 0 : areaServidor.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((servidor == null) ? 0 : servidor.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AreaServidor other = (AreaServidor) obj;
		if (areaServidor == null) {
			if (other.areaServidor != null)
				return false;
		} else if (!areaServidor.equals(other.areaServidor))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (servidor == null) {
			if (other.servidor != null)
				return false;
		} else if (!servidor.equals(other.servidor))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	
	
	
	
}
