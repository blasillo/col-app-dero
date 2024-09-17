package es.jcyl.eclap.colapp.oad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDb {
	static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static String DB_URL = "jdbc:oracle:thin:@oracle:1521:FREE";
	static String USER = "colapp"; // Reemplaza con tu usuario de Oracle
	static String PASS = "colapp"; // Reemplaza con tu contraseña de Oracle


	public static Connection obtenerConexionDb() throws SQLException, ClassNotFoundException {
		Class.forName(JDBC_DRIVER);

		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		return conn;
	}

}
