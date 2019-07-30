package es.jcyl.eclap.colapp.oad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.jcyl.eclap.colapp.controladores.LoginControlador;
import es.jcyl.eclap.colapp.ot.Usuario;

public class LoginOad {
	
	
	static Logger logger = LogManager.getLogger(LoginOad.class);
	
	
	
	public static Usuario validarUsuario ( String login, String password ) throws SQLException {
		
		
		Connection conn = null; 
		Statement stmt = null; 
		
		try {
			
			Usuario usuario = null;
			
			logger.info ("Conectando a base de datos ...");
			
			
			
			//conn = DriverManager.getConnection(ConexionDb.DB_URL,ConexionDb.USER,ConexionDb.PASS);
			
			conn = ConexionDb.obtenerConexionDb();
			
			
			String sql = "SELECT * FROM USUARIOS WHERE EMAIL = '" + login + "' AND PASSWORD ='" + password + "'";
			logger.info ("Ejecudando consulta: " + sql );
			
			 stmt = conn.createStatement(); 			 
			 
			 
			 ResultSet rs = stmt.executeQuery( sql );
			 
			 if(rs != null && rs.next()) {
				 // tratar resultados 
				 
				 usuario = new Usuario ();
				 usuario.setId( rs.getInt("ID"));
				 usuario.setEmail( rs.getString("EMAIL"));
				 usuario.setPassword(rs.getString("PASSWORD"));
				 usuario.setNombre(rs.getString("NOMBRE"));
				 
				 
				 logger.info ("Resultado: " + usuario);
				 
			 }
			 			 
			 return usuario;
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return null;
	}

}
