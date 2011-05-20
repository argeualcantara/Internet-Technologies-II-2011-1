package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {

	// Para conexão SQLSERVER
	private static final String SQL = "SQL";
	private static final String URL_SQL = "jdbc:jtds:sqlserver://localhost:1433/DOOMBOX";
	private static final String DRIVER_SQL = "net.sourceforge.jtds.jdbc.Driver";
	private static final String USUARIO_SQL = "ARGEU";
	private static final String SENHA_SQL = "argeu";

	// Para conexão PostGres
	private static final String POST = "POST";
	private static final String URL_POST = "jdbc:postgresql://localhost:5432/doombox";
	private static final String DRIVER_POST = "org.postgresql.Driver";
	private static final String USUARIO_POST = "postgres";
	private static final String SENHA_POST = "root";

	private static Connection con;

	public static Connection getCon() throws SQLException {
		return getCon(POST);
	}
	
	public static Connection getCon(String tipo) throws SQLException {

		try {
			if (tipo.equals(SQL)) {
				Class.forName(DRIVER_SQL);
				con = DriverManager.getConnection(URL_SQL, USUARIO_SQL, SENHA_SQL);
				return con;
			} else if (tipo.equals(POST)) {
				Class.forName(DRIVER_POST);
				con = DriverManager
						.getConnection(URL_POST, USUARIO_POST, SENHA_POST);
				return con;

			}
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
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
