
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tab_reserva")
public class Reserva{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date data;
    private String quilometragemInicial;
    private String quilometragemChegada;
    private boolean horasExtras;
    
    @Column(nullable = true)
    private Integer autenticadoAdministrador;
    
    @Column(nullable = true)
    private Integer autenticadoResponsavelServidor;
    private boolean status;
    
    private String descricaoChefe;
    
    private String descricaoAdm;
    
    private Integer situacaoReserva;
    
    @Temporal(TemporalType.DATE)
    private Date dataValidadoRequerente;
    
    private String obsMotorista;
    
    @Temporal(TemporalType.DATE)
    private Date dataSaida;
    
    @Temporal(TemporalType.DATE)
    private Date dataAutenticacaoAdm;
    
    @Temporal(TemporalType.DATE)
    private Date dataAutenticacaoChefe;
    
    @Temporal(TemporalType.DATE)
    private Date dataChegada;
    
    @Temporal(TemporalType.TIME)
    private Date horaSaida;
    
    @Temporal(TemporalType.TIME)
    private Date horaChegada;
    
    @Temporal(TemporalType.DATE)
    private Date dataFinalizacaoMotorista;
   
    
    @ManyToOne
    private AreaServidor areaServidor;
    
     @ManyToOne
    private Veiculo veiculo;
     


    public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Date getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}

	public String getDescricaoChefe() {
		return descricaoChefe;
	}

	public void setDescricaoChefe(String descricaoChefe) {
		this.descricaoChefe = descricaoChefe;
	}

	public String getDescricaoAdm() {
		return descricaoAdm;
	}

	public void setDescricaoAdm(String descricaoAdm) {
		this.descricaoAdm = descricaoAdm;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getQuilometragemInicial() {
        return quilometragemInicial;
    }

    public void setQuilometragemInicial(String quilometragemInicial) {
        this.quilometragemInicial = quilometragemInicial;
    }

    public String getQuilometragemChegada() {
        return quilometragemChegada;
    }
    
    
 
	public void setQuilometragemChegada(String quilometragemChegada) {
        this.quilometragemChegada = quilometragemChegada;
    }

    public boolean isHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(boolean horasExtras) {
        this.horasExtras = horasExtras;
    }
  
 
	public Integer getAutenticadoAdministrador() {
		return autenticadoAdministrador;
	}

	public void setAutenticadoAdministrador(Integer autenticadoAdministrador) {
		this.autenticadoAdministrador = autenticadoAdministrador;
	}

	public Integer getAutenticadoResponsavelServidor() {
		return autenticadoResponsavelServidor;
	}

	public void setAutenticadoResponsavelServidor(Integer autenticadoResponsavelServidor) {
		this.autenticadoResponsavelServidor = autenticadoResponsavelServidor;
	}

	public Date getDataFinalizacaoMotorista() {
		return dataFinalizacaoMotorista;
	}

	public void setDataFinalizacaoMotorista(Date dataFinalizacaoMotorista) {
		this.dataFinalizacaoMotorista = dataFinalizacaoMotorista;
	}

	public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    

 

 

	public Date getDataAutenticacaoAdm() {
		return dataAutenticacaoAdm;
	}

	public void setDataAutenticacaoAdm(Date dataAutenticacaoAdm) {
		this.dataAutenticacaoAdm = dataAutenticacaoAdm;
	}

	public Date getDataAutenticacaoChefe() {
		return dataAutenticacaoChefe;
	}

	public void setDataAutenticacaoChefe(Date dataAutenticacaoChefe) {
		this.dataAutenticacaoChefe = dataAutenticacaoChefe;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Date getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(Date horaChegada) {
		this.horaChegada = horaChegada;
	}

	public AreaServidor getAreaServidor() {
		return areaServidor;
	}

	public void setAreaServidor(AreaServidor areaServidor) {
		this.areaServidor = areaServidor;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getObsMotorista() {
		return obsMotorista;
	}

	public void setObsMotorista(String obsMotorista) {
		this.obsMotorista = obsMotorista;
	}

	public Integer getSituacaoReserva() {
		return situacaoReserva;
	}

	public void setSituacaoReserva(Integer situacaoReserva) {
		this.situacaoReserva = situacaoReserva;
	}

	public Date getDataValidadoRequerente() {
		return dataValidadoRequerente;
	}

	public void setDataValidadoRequerente(Date dataValidadoRequerente) {
		this.dataValidadoRequerente = dataValidadoRequerente;
	}



 
    
    
    
}
