package es.jcyl.eclap.colapp.oad;

import java.sql.SQLException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import es.jcyl.eclap.colapp.ot.Usuario;

public class LoginOad {
	
	
	private static final Logger logger = LogManager.getLogger(LoginOad.class);
	
	
	
	public static Usuario validarUsuario ( String login, String password ) throws SQLException {
		Usuario usuario = null;

		logger.info("Validando usuario :" + login);

		try {
		     usuario  = (new UsuarioOad ()).validarUsuario( login , password);     			 			 
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		
		return usuario;
	}

}
