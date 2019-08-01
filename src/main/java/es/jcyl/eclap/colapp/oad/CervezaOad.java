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
	
	Logger logger = LogManager.getLogger(CervezaOad.class);
	
	public List<Cerveza> buscarPorNombre (String filtro) throws SQLException {
		
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
