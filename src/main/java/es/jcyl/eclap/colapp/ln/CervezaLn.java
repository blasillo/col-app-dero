package es.jcyl.eclap.colapp.ln;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.jcyl.eclap.colapp.oad.CervezaOad;
import es.jcyl.eclap.colapp.ot.Cerveza;

public class CervezaLn {
	private static final Logger logger = LogManager.getLogger(CervezaLn.class);
	
	public static Cerveza getCervezaPorId ( long id ) throws SQLException {
		
		try {
			return (new CervezaOad()).buscarPorId( id );
		}
		catch(SQLException e) {
			logger.error("Fallo al recuperar Cerveza Por id (id=" + id + ")", e);
			throw new SQLException(e);
		}
	}
	
	
	public static List<Cerveza> buscarPorNombre ( String busqueda ) throws SQLException {
		 return (new CervezaOad()).buscarPorNombre(busqueda);
	}

}
