package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Arquivo;

public class ArquivoBD {
	private static ArquivoBD instance;

	public static ArquivoBD getInstance() {
		if (instance == null) {
			instance = new ArquivoBD();
		}
		return instance;
	}

	public void deletar(String id){
		try {
			String sql = "DELETE FROM ARQ_DIR WHERE ID = ?";

			Connection con = null;
			PreparedStatement st = null;
			
			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setString(1, id);
			
			st.executeUpdate();
			BD.closeCon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Arquivo> buscarArquivos(String login, String nome) {
		List<Arquivo> list = new ArrayList<Arquivo>();
		try {
			String sql = "SELECT * FROM ARQ_DIR WHERE NOME LIKE ?";

			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.prepareStatement(sql);
			st.setString(1, "%" + nome + "%");
			rs = st.executeQuery();

			while (rs.next()) {
				Arquivo a = new Arquivo();
				if (rs.getString("login_usuario") != null
						&& rs.getString("login_usuario")
								.equalsIgnoreCase(login)) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int buscarIdArquivo(String login, String descricao, Timestamp time) {
		int id = 0;
		Connection con = null;
		try {
			String sql = "SELECT * FROM ARQ_DIR WHERE DESCRICAO = ? AND LOGIN_USUARIO = ? AND DATA = ?";

			PreparedStatement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.prepareStatement(sql);
			st.setString(1, descricao);
			st.setString(2, login);
			st.setTimestamp(3, time);
			rs = st.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BD.closeCon();
		}
		return id;
	}

	public int inserirArquivo(String nome, int pai, long bytes, String login,
			String descricao) {
		Timestamp time = null;
		try {
			String sql = "insert into arq_dir (nome, pai, diretorio, data, bytes, login_usuario, descricao)"
					+ "values (?, ?, 0, ?, ?, ?, ?)";

			Connection con = null;
			PreparedStatement st = null;

			con = BD.getCon();
			st = con.prepareStatement(sql);
			st.setString(1, nome);
			st.setInt(2, pai);
			time = buscarDataAtual();
			st.setTimestamp(3, time);
			st.setLong(4, bytes);
			st.setString(5, login);
			st.setString(6, descricao);

			st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BD.closeCon();
		}
		return buscarIdArquivo(login, descricao, time);
	}

	public List<Arquivo> listarArquivos(String login, String nome) {
		List<Arquivo> list = new ArrayList<Arquivo>();
		try {
			String sql = "SELECT * FROM ARQ_DIR";

			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Arquivo a = new Arquivo();
				if (rs.getString("nome").equalsIgnoreCase("doom box")) {
					a.setId(rs.getInt("id"));
					a.setNome(rs.getString("nome"));
					a.setPai(rs.getInt("pai"));
					a.setDiretorio(rs.getBoolean("diretorio"));
					a.setData(rs.getString("data"));
					a.setBytes(rs.getString("bytes"));
					a.setLogin(rs.getString("login_usuario"));
					a.setDescricao(rs.getString("descricao"));
					a.setFiles(this.buscarFiles(a.getId(), login));
					list.add(a);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	private List<Arquivo> buscarFiles(int pai, String login) {
		List<Arquivo> list = new ArrayList<Arquivo>();
		try {
			String sql = "SELECT * FROM ARQ_DIR WHERE PAI=?";

			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.prepareStatement(sql);
			st.setInt(1, pai);
			rs = st.executeQuery();

			while (rs.next()) {
				Arquivo a = new Arquivo();
				if (rs.getString("login_usuario") != null
						&& rs.getString("login_usuario")
								.equalsIgnoreCase(login)) {
					a.setId(rs.getInt("id"));
					a.setNome(rs.getString("nome"));
					a.setPai(rs.getInt("pai"));
					a.setDiretorio(rs.getBoolean("diretorio"));
					a.setData(rs.getString("data"));
					a.setBytes(rs.getString("bytes"));
					a.setLogin(rs.getString("login_usuario"));
					a.setDescricao(rs.getString("descricao"));
					if (rs.getBoolean("diretorio")) {
						a.setFiles(this.buscarFiles(a.getId(), login));
					}
					list.add(a);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void criarDiretorio(int pai,String descricao, String login){
		try {
			String sql = "INSERT INTO ARQ_DIR(NOME,PAI,DIRETORIO,LOGIN_USUARIO) VALUES(?,?,1,?)";

			Connection con = null;
			PreparedStatement st = null;

			con = BD.getCon();
			st = con.prepareStatement(sql);
			st.setString(1, descricao);
			st.setInt(2, pai);
			st.setString(3, login);
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private Timestamp buscarDataAtual() throws Exception{
		Timestamp time = null;
		Date data = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataAtual = f.format(data);
		data = f.parse(dataAtual);
		time = new Timestamp(data.getTime());
		
		return time;
	}
}
