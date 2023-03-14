
package util;

import org.primefaces.context.RequestContext;


public class FechaDialog {
    public static void fecharDialogSalvaEstado() {
		      RequestContext.getCurrentInstance().execute("PF('dlgEstado').hide();");
	}

    public static void fecharDialogSalvaCidade() {
        RequestContext.getCurrentInstance().execute("PF('dlgCidade').hide();");   }
    
    public static void fecharDialogAutoriza() {
        RequestContext.getCurrentInstance().execute("PF('dglAutorizar').hide();");   }
    
        public static void fecharDialogSalvaServidor() {
        RequestContext.getCurrentInstance().execute("PF('dlgServidor').hide();");   
}
        
        public static void fecharDialogEditarSenha() {
            RequestContext.getCurrentInstance().execute("PF('dglServidor').hide();");   }
    
    
}

