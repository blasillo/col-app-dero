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
	
	
	private static final Logger logger = LogManager.getLogger(LoginOad.class);
	
	
	
	public static Usuario validarUsuario ( String login, String password ) throws SQLException {
		Usuario usuario = null;
		try {
		     usuario  = (new UsuarioOad ()).validarUsuario( login , password);     			 			 
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		
		return usuario;
	}

}
