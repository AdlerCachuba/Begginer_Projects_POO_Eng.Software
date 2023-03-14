package controle;

import DAO.DAOGenerico;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import modelo.Veiculo;
import util.ExibirMensagem;
import util.FechaDialog;
import util.Mensagem; 



@ViewScoped
@ManagedBean
public class VeiculoMB {

    private Veiculo veiculo;
    private DAOGenerico<Veiculo> daoVeiculo;
    private List<Veiculo> listVeiculo = new ArrayList<>(); 
    private List<Veiculo> listSelecionados;
    private Long idVeiculo;

    public VeiculoMB() {
    	veiculo = new Veiculo();
    	listSelecionados = new ArrayList<>();
        daoVeiculo = new DAOGenerico<Veiculo>(Veiculo.class);
        listVeiculo = daoVeiculo.listaComStatus(Veiculo.class);
        
    }

    public void inicializar(){
    	if(idVeiculo != null){
    		veiculo = daoVeiculo.buscarPorId(idVeiculo);
    	} 
    }
    public void atualiza() {
    	listVeiculo = daoVeiculo.listaComStatus(Veiculo.class);
    }
    
    public void excluirSelecionados(){
    	for(Veiculo v : listSelecionados){
    	    v.setStatus(false);
    	    daoVeiculo.alterar(v);
    	 }
    	atualiza();
    	ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
    }
    
    public void excluir(){
    	try { 
    		
    		
    	veiculo.setStatus(false);
    	daoVeiculo.alterar(veiculo);
    	atualiza();
    	ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("veiculo-lista.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    }

//    public void carregarDados(Estado estado) {
//        this.estado = estado;
//
//    }

//    public void excluir(Estado estado) {
//        estado.setStatus(false);
//        daoEstado.alterar(estado);
//        ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
//        atualiza();
//    }

    public void inserir() {

        try {
            if (veiculo.getId() == null) {
            	veiculo.setStatus(true);
                daoVeiculo.salvar(veiculo);
                 
                ExibirMensagem.exibirMensagem(Mensagem.SUCESSO); 
                atualiza();
                criarNovoObjeto();
            } else {
            	
            	System.out.println("no else ");
            	System.out.println("veiculo alterar "+veiculo.getDescricaoVeiculo());
            	
            	daoVeiculo.alterar(veiculo); 
                ExibirMensagem.exibirMensagem(Mensagem.SUCESSO); 
                atualiza();
                criarNovoObjeto();
            }
            FacesContext.getCurrentInstance().getExternalContext().redirect("veiculo-lista.xhtml");
        } catch (Exception e) {
                 ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
            e.printStackTrace();

        }
    }
    
    public void criarNovoObjeto(){
    	veiculo = new Veiculo();
    }

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Veiculo> getListVeiculo() {
		return listVeiculo;
	}

	public void setListVeiculo(List<Veiculo> listVeiculo) {
		this.listVeiculo = listVeiculo;
	}

	public List<Veiculo> getListSelecionados() {
		return listSelecionados;
	}

	public void setListSelecionados(List<Veiculo> listSelecionados) {
		this.listSelecionados = listSelecionados;
	}

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	
	

 
}
