package form;

import org.apache.struts.action.ActionForm;

public class ArquivoForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4962169864022907048L;
	private int id;
	private String nome;
	private int pai;
	private boolean diretorio;
	private String data;
	private String bytes;
	private String login;
	private String descricao;
	
	public ArquivoForm() {
		
	}
	
	public ArquivoForm(int id, String nome, int pai, boolean diretorio,
			String data, String bytes, String login, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.pai = pai;
		this.diretorio = diretorio;
		this.data = data;
		this.bytes = bytes;
		this.login = login;
		this.descricao = descricao;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPai() {
		return pai;
	}
	public void setPai(int pai) {
		this.pai = pai;
	}
	public boolean isDiretorio() {
		return diretorio;
	}
	public void setDiretorio(boolean diretorio) {
		this.diretorio = diretorio;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getBytes() {
		return bytes;
	}
	public void setBytes(String bytes) {
		this.bytes = bytes;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
