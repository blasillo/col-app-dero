package es.jcyl.eclap.colapp.oad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.jcyl.eclap.colapp.ot.Cerveza;


public class CervezaOad {
	
	private static final String TABLA = "CERVEZAS";
	
	private static final Logger logger = LogManager.getLogger(CervezaOad.class);
	
	
	public Cerveza buscarPorId (long id) throws SQLException {
		
		Cerveza result = null;
		
		String sql = "SELECT * FROM " + TABLA + " WHERE id = " + id;
		
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			logger.debug("BASE DE DATOS - " + sql );
			conn = ConexionDb.obtenerConexionDb();
			
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				result = procesarElemento (rs);
			}
			
			rs.close();
			rs = null;
			statement.close();
			statement = null;
			conn.close();
			conn = null;
		}
		catch(Exception e) {
			throw new SQLException(e);
		}
		finally {
			if(rs != null) {
				rs.close();
				rs = null;
			}
			if(statement != null) {
				statement.close();
				statement = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
		}
		
		return result;
	}
	
	public List<Cerveza> buscarPorNombre (String filtro) throws SQLException {

		// Filtro anti-SQLMap (bloquea user-agents y patrones comunes de scanners)
		if (filtro != null) {
			String filtroLower = filtro.toLowerCase();

			// Bloquear solo patrones típicos de scanners automatizados
			String[] patronesBloqueados = {
					"/**/",      // Comentarios en línea de SQLMap
					"sleep(",    // Time-based blind
					"benchmark(",
					"pg_sleep",
					"waitfor delay",
					"0x3a58",    // Encoding hexadecimal típico de SQLMap
			};

			for (String patron : patronesBloqueados) {
				if (filtroLower.contains(patron)) {
					throw new SQLException("Entrada no válida detectada");
				}
			}
		}

		List<Cerveza> results = new ArrayList<Cerveza>();
		
		String sql = "SELECT * FROM " + TABLA + " WHERE nombre LIKE '%" + filtro + "%'";
		
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			logger.debug("BASE DE DATOS - " + sql );
			conn = ConexionDb.obtenerConexionDb();
			
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				results.add(procesarElemento (rs));
			}
			
			rs.close();
				rs = null;
			statement.close();
			statement = null;
			conn.close();
			conn = null;
		}
		catch(Exception e) {
			logger.warn( "Error de SQL: " + sql );
			throw new SQLException(e);
		}
		finally {
			if(rs != null) {
				rs.close();
				rs = null;
			}
			if(statement != null) {
				statement.close();
				statement = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
		}
		
		return results;
		
	}
	
	
	
	
	protected Cerveza procesarElemento (ResultSet rs) throws SQLException {
		return new Cerveza (rs.getLong("id"), 
				            rs.getString("nombre"), 
				            rs.getString("imagen"), 
				            rs.getDouble("alcohol"), 
				            rs.getString("color"), 
				            rs.getString("categoria"), 
				            rs.getString("descripcion"));
	}

}
