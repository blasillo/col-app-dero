package es.jcyl.eclap.colapp.oad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDb {
	static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static String DB_URL = System.getenv().getOrDefault("SPRING_DATASOURCE_URL",
			"jdbc:mysql://mysql-db:3306/colappdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
	static String USER = System.getenv().getOrDefault("SPRING_DATASOURCE_USERNAME", "colapp");
	static String PASS = System.getenv().getOrDefault("SPRING_DATASOURCE_PASSWORD", "c0lapp!p4$$wd");


	public static Connection obtenerConexionDb() throws SQLException, ClassNotFoundException {
		Class.forName(JDBC_DRIVER);
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		return conn;
	}
}
