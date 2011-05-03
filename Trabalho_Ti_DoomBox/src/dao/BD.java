package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {

	// Para conexão SQLSERVER
	private static final String URL_SQL =  "jdbc:jtds:sqlserver://localhost:1433/DOOMBOX";
	private static final String DRIVER_SQL = "net.sourceforge.jtds.jdbc.Driver";
	private static final String USUARIO_SQL = "sa";
	
	// Para conexões MYSQL
	private static final String URL_MY = "jdbc:mysql://localhost/nome_banco";
	private static final String DRIVER_MY = "com.mysql.jdbc.Driver";
	
	// Para conexões POSTGRES
	private static final String URL_POST = "jdbc:postgresql://localhost:5432/nome_banco";
	private static final String DRIVER_POST = "org.postgresql.Driver";
	private static final String USUARIO_POST = "postgres";
	
	public static final String POSTGRES = "POST";
	public static final String SQL_SERVER = "SQL";
	public static final String MY_SQL = "MY";
	
	private static final String USUARIO = "root";
	private static final String SENHA = "root";
	private static Connection con;

	public static Connection getCon(String tipo) throws SQLException {
		if (tipo.equals("SQL")) {
			try {
				Class.forName(DRIVER_SQL);
				con = DriverManager.getConnection(URL_SQL, USUARIO_SQL, "");
				return con;
			} catch (ClassNotFoundException e) {
				throw new SQLException(e.getMessage());
			}
		}else if(tipo.equals("MY")){
			try {
				Class.forName(DRIVER_MY);
				con = DriverManager.getConnection(URL_MY, USUARIO, SENHA);
				return con;
			} catch (ClassNotFoundException e) {
				throw new SQLException(e.getMessage());
			}
		}else if(tipo.equals("POST")){
			try {
				Class.forName(DRIVER_POST);
				con = DriverManager.getConnection(URL_POST, USUARIO_POST, SENHA);
				return con;
			} catch (ClassNotFoundException e) {
				throw new SQLException(e.getMessage());
			}
		}
		return null;
	}

	public static void closeCon() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
