package es.jcyl.eclap.colapp.ln;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.jcyl.eclap.colapp.oad.NotaOad;
import es.jcyl.eclap.colapp.ot.Nota;

public class NotaLn {
	
	
	//private static final Logger logger = LogManager.getLogger(NotaLn.class);
	
	public static Nota getNotaPorId (int  id ) throws SQLException {
		
		return (new NotaOad()).buscarPorId(id);
	}
	
	
	public static boolean insertarNota (Nota nota) throws SQLException {
		return (new NotaOad()).insertarNota(nota);
	}
	
    public static boolean modificarNota (Nota nota) throws SQLException {    	
    	return (new NotaOad()).actualizarNota(nota);
	}
	
	
	public static List<Nota> getNotasPorCerveza ( int cervezaId ) throws SQLException {
		
		return (new NotaOad()).buscarPorCervezaId( cervezaId );
	}
	
	public static List<Nota> getNotasPorUsuario ( int usuarioId ) throws SQLException {
	
		return (new NotaOad()).buscarPorUsuarioId(usuarioId);

	}
	

}

