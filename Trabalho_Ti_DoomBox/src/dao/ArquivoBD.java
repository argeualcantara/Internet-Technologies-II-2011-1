package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Arquivo;

public class ArquivoBD {
private static ArquivoBD instance;
	
	public static ArquivoBD getInstance(){
		if(instance == null){
			instance = new ArquivoBD();
		}
		return instance;
	}
	
	public List<Arquivo> listarArquivos(String login, String nome){
		List<Arquivo> list = new ArrayList<Arquivo>();
		try {
			String sql = "SELECT * FROM ARQ_DIR WHERE NOME LIKE ?";

			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.prepareStatement(sql);
			st.setString(1, "%"+nome+"%");
			rs = st.executeQuery();

			while (rs.next()) {
				Arquivo a=new Arquivo(); 
				if(rs.getString("nome").equalsIgnoreCase("doom box")){
					a.setId(rs.getInt("id"));
					a.setNome(rs.getString("nome"));
					a.setPai(rs.getInt("pai"));
					a.setDiretorio(rs.getBoolean("diretorio"));
					a.setData(rs.getString("data"));
					a.setBytes(rs.getString("bytes"));
					a.setLogin(rs.getString("login_usuario"));
					a.setDescricao(rs.getString("descricao"));
					list.add(a);
				}
				if(rs.getString("login_usuario")!=null && rs.getString("login_usuario").equalsIgnoreCase(login)){
					a.setId(rs.getInt("id"));
					a.setNome(rs.getString("nome"));
					a.setPai(rs.getInt("pai"));
					a.setDiretorio(rs.getBoolean("diretorio"));
					a.setData(rs.getString("data"));
					a.setBytes(rs.getString("bytes"));
					a.setLogin(rs.getString("login_usuario"));
					a.setDescricao(rs.getString("descricao"));
					list.add(a);
				}
			}	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
}
