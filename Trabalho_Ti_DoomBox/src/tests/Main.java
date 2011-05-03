package tests;

import model.Usuario;
import dao.UsuarioBD;

public class Main {

	public static void main(String[] args) {
		for(Usuario u : UsuarioBD.getInstance().listarUsuarios()){
			System.out.println(u.getLogin_usuario()+" "+u.getNome());
		}
	}
}
