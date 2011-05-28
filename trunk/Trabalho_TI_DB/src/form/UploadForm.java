package form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class UploadForm extends ActionForm {

	private static final long serialVersionUID = 5666475391295585583L;

	private FormFile arquivo = null; 
	private String[] pais;
	private String descricao;
	private String nomeDiretorio;

	private String tipoArquivo;

	public FormFile getArquivo() {  
		return arquivo;  
	}  

	public void setArquivo(FormFile arquivo) {  
		this.arquivo = arquivo;  
	}

	public String getTipoArquivo() {
		return tipoArquivo;
	}
	
	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	public String[] getPais() {
		return pais;
	}

	public void setPais(String[] pais) {
		this.pais = pais;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setNomeDiretorio(String nomeDiretorio) {
		this.nomeDiretorio = nomeDiretorio;
	}

	public String getNomeDiretorio() {
		return nomeDiretorio;
	} 
	
}
