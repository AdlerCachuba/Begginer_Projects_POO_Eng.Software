package modelo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_historico")
public class Historico{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dataAutorizacaoChefe;
    private boolean confirmaAutorizacaoChefe;
  
    private Date dataAutorizacaoAdm;
    private boolean confirmaAutorizacaoADM;
    
    private BigDecimal valorHorasExtras;
    
    @OneToOne
    private Reserva reserva;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAutorizacaoChefe() {
		return dataAutorizacaoChefe;
	}

	public void setDataAutorizacaoChefe(Date dataAutorizacaoChefe) {
		this.dataAutorizacaoChefe = dataAutorizacaoChefe;
	}

	public boolean isConfirmaAutorizacaoChefe() {
		return confirmaAutorizacaoChefe;
	}

	public void setConfirmaAutorizacaoChefe(boolean confirmaAutorizacaoChefe) {
		this.confirmaAutorizacaoChefe = confirmaAutorizacaoChefe;
	}

	public Date getDataAutorizacaoAdm() {
		return dataAutorizacaoAdm;
	}

	public void setDataAutorizacaoAdm(Date dataAutorizacaoAdm) {
		this.dataAutorizacaoAdm = dataAutorizacaoAdm;
	}

	public boolean isConfirmaAutorizacaoADM() {
		return confirmaAutorizacaoADM;
	}

	public void setConfirmaAutorizacaoADM(boolean confirmaAutorizacaoADM) {
		this.confirmaAutorizacaoADM = confirmaAutorizacaoADM;
	}

	public BigDecimal getValorHorasExtras() {
		return valorHorasExtras;
	}

	public void setValorHorasExtras(BigDecimal valorHorasExtras) {
		this.valorHorasExtras = valorHorasExtras;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

    
    
    
    

}
