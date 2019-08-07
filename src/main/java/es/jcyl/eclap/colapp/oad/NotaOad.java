package es.jcyl.eclap.colapp.oad;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.jcyl.eclap.colapp.ot.*;


public class NotaOad {
	
	private static final String TABLA = "NOTAS";
	
	private static final Logger logger = LogManager.getLogger(NotaOad.class);
	
	
	public List<Nota> buscarPorCervezaId (long id) throws SQLException {
		
		List<Nota> results = new ArrayList<Nota>();
		
		String sql = "SELECT * FROM " + TABLA + " WHERE cervezaid = " + id;
		
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			logger.debug("BASE DE DATOS - " + sql );
			conn = ConexionDb.obtenerConexionDb();
			
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				results.add(procesarNota (rs));
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
		
		return results;
	}
	
	
	
	protected Nota procesarNota (ResultSet rs) throws SQLException {
		return new Nota (rs.getLong("id"), 
				         rs.getTimestamp("creado"), 
				         rs.getString("titulo"), 
				         rs.getString("contenido"), 
				         rs.getBoolean("publico"), 
				         rs.getInt("usuarioid"), 
				         rs.getLong("cervezaid"));
	}

}
