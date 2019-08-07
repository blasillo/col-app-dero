package es.jcyl.eclap.colapp.filtros;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Dictionary;
import java.util.Hashtable;

import java.security.SecureRandom;

import es.jcyl.eclap.colapp.ot.Usuario;

public class Sesion implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	private static SecureRandom random = new SecureRandom();
	
	
	private String id;
	private boolean modificado;
	private boolean nueva; 
	private Dictionary<String, Object> atributos;
	
	public Sesion() {
		
		this.setId( new BigInteger(130, random).toString(32) );
		this.setModificado( false );
		this.setNueva (true);
		this.setAtributos( new Hashtable<String, Object>() );
		
	}
	
	public void marcarGuardada() {
		this.setNueva (false);
		this.setModificado(false);
	}
	
	
	
	public void setAtributo (String key, Object value) {
		this.getAtributos().put(key, value);
		this.marcarModificado();
	}
	
	public void eliminarAtributo (String key) {
		this.getAtributos().remove(key);
		this.marcarModificado();
	}
	
	public Object getAtributo (String key) {
		return this.getAtributos().get(key);
	}
	
	
	public void setUsuarioAutenticado (Usuario usuario) {
		if(usuario != null) {
			this.setAtributo("usuarioAutenticado", usuario);
		}
		else {
			this.eliminarAtributo("usuarioAutenticado");
		}
	}
	
	public Usuario getUsuarioAutenticado() {
		if(estaAutenticado()) {
			return (Usuario)this.getAtributo("usuarioAutenticado");
		}
		else {
			return null;
		}
	}
	
	public boolean estaAutenticado() {
		return this.getAtributo("usuarioAutenticado") != null;
	}
	
	
	
	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}

	public boolean estaModificado() {
		return modificado;
	}

	private void setModificado(boolean modificado) {
		this.modificado = modificado;
	}

	private Dictionary<String, Object> getAtributos() {
		return atributos;
	}

	private void setAtributos(Dictionary<String, Object> atributos) {
		this.atributos = atributos;
	}
	
	public boolean esNueva () {
		return nueva;
	}

	private void setNueva(boolean n) {
		this.nueva = n;
	}

	private void marcarModificado() {
		this.setModificado(true);
	}

}
