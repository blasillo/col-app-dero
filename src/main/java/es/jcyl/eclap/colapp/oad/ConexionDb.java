package es.jcyl.eclap.colapp.oad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDb {
	
	static String JDBC_DRIVER ="org.h2.Driver";
	
	public static Connection obtenerConexionDb() throws SQLException, ClassNotFoundException {		
		Class.forName(JDBC_DRIVER);		
		Connection conn = DriverManager.getConnection("jdbc:h2:mem:colappdb");
		return conn;
	}

}
