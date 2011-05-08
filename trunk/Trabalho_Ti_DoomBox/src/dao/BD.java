package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {

	// Para conexão SQLSERVER
	private static final String URL_SQL =  "jdbc:jtds:sqlserver://localhost:1433/DOOMBOX";
	private static final String DRIVER_SQL = "net.sourceforge.jtds.jdbc.Driver";
	
	private static Connection con;

	public static Connection getCon() throws SQLException {
		
			try {
				Class.forName(DRIVER_SQL);
				con = DriverManager.getConnection(URL_SQL, "ARGEU", "argeu");
				return con;
			} catch (ClassNotFoundException e) {
				throw new SQLException(e.getMessage());
		}
		
	}

	public static void closeCon() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
