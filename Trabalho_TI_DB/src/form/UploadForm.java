package form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/**
 * Classe reponsável por representar o formulário de Upload da aplicação.
 * 
 * @author Eduardo Chaves
 * @version 1.0.0
 * @since 17/12/2008
 */
public class UploadForm extends ActionForm {

	private static final long serialVersionUID = 5666475391295585583L;

	private FormFile arquivo = null; 

	private String tipoArquivo;

	/**
	 * @return arquivoForm
	 */
	public FormFile getArquivo() {  
		return arquivo;  
	}  

	/**
	 * @param arquivoForm
	 */
	public void setArquivo(FormFile arquivo) {  
		this.arquivo = arquivo;  
	}

	/**
	 * @return the tipoArquivo
	 */
	public String getTipoArquivo() {
		return tipoArquivo;
	}

	/**
	 * @param tipoArquivo the tipoArquivo to set
	 */
	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	/**
	 * Método reponsável por limpar o form.
	 * 
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {  
		arquivo = null;
		tipoArquivo = "";
	} 
}
