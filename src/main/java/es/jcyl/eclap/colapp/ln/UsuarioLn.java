package es.jcyl.eclap.colapp.ln;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.jcyl.eclap.colapp.oad.UsuarioOad;
import es.jcyl.eclap.colapp.ot.*;

public class UsuarioLn {
	private static final Logger logger = LogManager.getLogger(UsuarioLn.class);
	

	public static Usuario getUsuarioPorId ( int id ) {
		try {
			return (new UsuarioOad()).buscarPorId( id );
		}
		catch(SQLException e) {
			logger.error("Fallo al recuperar Usuario Por id (id=" + id + ")", e);
			return null;
		}
	}
}
