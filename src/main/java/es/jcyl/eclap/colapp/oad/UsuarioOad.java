package es.jcyl.eclap.colapp.oad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.jcyl.eclap.colapp.ot.Usuario;

public class UsuarioOad {
	
	
	private static final String TABLA = "USUARIOS";
	
	private static final Logger logger = LogManager.getLogger(UsuarioOad.class);
	
	public List<Usuario> buscarPorEmail(String email) throws SQLException {
		
		List<Usuario> results = new ArrayList<Usuario>();
		
		String sql = "SELECT * FROM " + TABLA + " WHERE email = '" + email + "'";
		
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			logger.debug("BASE DE DATOS - " + sql );
			conn = ConexionDb.obtenerConexionDb();
			
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				results.add(procesarUsuario (rs));
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
	
	
	public Usuario validarUsuario ( String login, String password ) throws SQLException {
		
		Usuario usuario = null;
		
		logger.info ("Conectando a base de datos ...");		
		String sql = "SELECT * FROM " + TABLA + " WHERE EMAIL = '" + login + "' AND PASSWORD ='" + password + "'";
		
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			logger.debug("BASE DE DATOS - " + sql );
			conn = ConexionDb.obtenerConexionDb();
			
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				usuario = procesarUsuario (rs);
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
		
		
		
		return usuario;
		
	}
	
	public Usuario buscarPorId(int id) throws SQLException {
		
		Usuario result = null;
		
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
				result = procesarUsuario (rs);
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
	
	
	
	
	
	protected Usuario procesarUsuario (ResultSet rs) throws SQLException {
		
		return new Usuario( rs.getInt ("id"), 
				            rs.getString("email"), 
				            rs.getString("password"), 
				            rs.getString("nombre"),
				            rs.getString("rol"));
		
	}

}
