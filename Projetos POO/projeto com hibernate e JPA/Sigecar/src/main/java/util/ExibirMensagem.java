
package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Messages;

public class ExibirMensagem {
    
    public static void exibirMensagem(String mensagem){
		      FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(mensagem));
                

	}
    
    
//        public static void exibirMensagemSucesso(String mensagem) {
//            Messages.create("").detail(mensagem).add();
//        }

//        public static void exibirMensagemAtencao(String mensagem) {
//            Messages.create("Atenção!").warn().detail(mensagem).add();
//        }
//
//        public static void exibirMensagemErro(String mensagem) {
//            Messages.create("Error!").error().detail(mensagem).add();
//        }
//
//        public static void exibirMensagemFatal(String mensagem) {
//            Messages.create("Fatal!").fatal().detail(mensagem).add();
//        }
}
