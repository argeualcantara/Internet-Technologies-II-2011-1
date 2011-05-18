package form;

import org.apache.struts.action.ActionForm;

public class UsuarioForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4065953482641861141L;
	private String login;
	private String nome;
	private String senha;
	
	public UsuarioForm() {
		super();
	}

	public UsuarioForm(String login_usuario, String nome, String senha) {
		super();
		this.login = login_usuario;
		this.nome = nome;
		this.senha = senha;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login_usuario) {
		this.login = login_usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
