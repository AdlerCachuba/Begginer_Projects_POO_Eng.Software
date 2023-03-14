package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped; 
import javax.inject.Inject;
import javax.inject.Named;

import DAO.DAOGenerico;
import modelo.Cidade;
import modelo.Pessoa;
import util.CriptografiaSenha;
import util.EnviarEmail;
import util.GeradorSenhas; 

@ViewScoped 
@ManagedBean
public class RecuperSenhaLoginMB {
 

	private String email;
    private List<Pessoa> lista;
	private String mensagem;
	private  DAOGenerico<Pessoa> daoPessoa;
	
  
	public  RecuperSenhaLoginMB() {
		lista = new ArrayList<>();
		mensagem = "";
		email = "";
		daoPessoa = new DAOGenerico<Pessoa>(Pessoa.class);
	}
	public Boolean buscarEmail() {
		lista = daoPessoa.listaComStatus(Pessoa.class);
		return lista.stream().anyMatch(p -> p.getEmail().equals(email));
	}

	public void recuperarSenhaLogin() {
		String senha;
		if (buscarEmail()) {
			senha = GeradorSenhas.gerarSenha();
			daoPessoa.updateSenha(CriptografiaSenha.criptografar(senha), email);
			if (EnviarEmail.enviarEmail(email, "Sigecar, Recuperação de senha ",
					"Olá, " + "\n" + "Sua nova senha: " + senha)) {
				mensagem = "E-mail enviado";
			} else {
				mensagem = "Erros ao enviar e-mail";
			}
		} else {
			mensagem = "E-mail não encontrado";
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
