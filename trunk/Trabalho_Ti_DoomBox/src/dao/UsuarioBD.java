package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioBD {
	
	private static UsuarioBD instance;
	
	public static UsuarioBD getInstance(){
		if(instance == null){
			instance = new UsuarioBD();
		}
		return instance;
	}
	
	public List<Usuario> listarUsuarios(){
		return listarUsuarios(BD.SQL_SERVER);
	}
	
	public List<Usuario> listarUsuarios(String Con){
		List<Usuario> list = new ArrayList<Usuario>();
		try {
			String sql = "SELECT * FROM USUARIO";

			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			con = BD.getCon(Con);
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				String login_usuario = rs.getString("login_usuario");
				String nome = rs.getString("nome");
				String senha = rs.getString("senha");
				list.add(new Usuario(login_usuario, nome, senha));
			}	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
}
