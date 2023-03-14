package controle;

import DAO.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Cidade;
import modelo.Servidor;
import util.ExibirMensagem;
import util.FechaDialog;
import util.Mensagem;
 
@ViewScoped
@ManagedBean
public class CidadeMB {

    private Cidade cidade;
    private DAOGenerico<Cidade> daoCidade;
    private List<Cidade> listCidade = new ArrayList<>();
    private List<Cidade> listCidadeSelecionado;
    private List<Cidade> listCidadeCadastroMomento;
    private Long idCidade;
   

    public CidadeMB() {
        cidade = new Cidade();
        daoCidade = new DAOGenerico<Cidade>(Cidade.class);
        listCidade = daoCidade.listaComStatus(Cidade.class);
        listCidadeSelecionado = new ArrayList<>();
        listCidadeCadastroMomento = new ArrayList<>();
        System.out.println("entrou");
    //        EntityManager manager = Fabrica.get().createEntityManager();
    }

    public void inicializar(){
    	if(idCidade != null){
    		cidade = daoCidade.buscarPorId(idCidade);
    	} 
    }
    
    public void limparLista(){
    	listCidadeCadastroMomento.clear();
  
    }
    
  
	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public void atualiza() {
        listCidade = daoCidade.listaComStatus(Cidade.class);
        cidade = new Cidade();
        
    }

    public void carregarDados(Cidade Cidade) {
        this.cidade = Cidade;

    }
    
public void excluirSelecionados(){
     
    	
    	for(Cidade v : listCidadeSelecionado){
    		System.out.println("cidade alterar "+v.getNome());
    	    v.setStatus(false);
    	    daoCidade.alterar(v);
    	 }
    	atualiza();
    	ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
    }

    public void excluir(Cidade cidade) {
        cidade.setStatus(false);
        daoCidade.alterar(cidade);
        ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
        atualiza();
    }

    public void inserir() {
      
      
      try{
    	  
        if (cidade.getId()==null){
            cidade.setStatus(true);
            daoCidade.salvar(cidade);
            ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
           
            atualiza();
        } else {
            daoCidade.alterar(cidade);
            ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
         
            atualiza(); 
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("cidade-lista.xhtml");
      } catch (Exception e) {
            ExibirMensagem.exibirMensagem(Mensagem.SUCESSO);
            e.printStackTrace();

        }
    }

    public void criarNovoObjeto() {
        cidade = new Cidade();
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public DAOGenerico<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(DAOGenerico<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }

	public List<Cidade> getListCidadeCadastroMomento() {
		return listCidadeCadastroMomento;
	}

	public void setListCidadeCadastroMomento(List<Cidade> listCidadeCadastroMomento) {
		this.listCidadeCadastroMomento = listCidadeCadastroMomento;
	}

	public List<Cidade> getListCidade() {
        return listCidade;
    }

    public void setListCidade(List<Cidade> listCidade) {
        this.listCidade = listCidade;
    }

	public List<Cidade> getListCidadeSelecionado() {
		return listCidadeSelecionado;
	}

	public void setListCidadeSelecionado(List<Cidade> listCidadeSelecionado) {
		this.listCidadeSelecionado = listCidadeSelecionado;
	}
    
}
