package es.jcyl.eclap.colapp.oad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDb {
	
	static String JDBC_DRIVER ="org.mariadb.jdbc.Driver";
	
	public static Connection obtenerConexionDb() throws SQLException, ClassNotFoundException {
		
		Class.forName(JDBC_DRIVER);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/colapp?allowMultiQueries=true","colapp","secreto");  
		return conn;
	}

}
