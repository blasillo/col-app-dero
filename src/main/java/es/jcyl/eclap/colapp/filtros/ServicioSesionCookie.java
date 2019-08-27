package es.jcyl.eclap.colapp.filtros;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ServicioSesionCookie {
	
	private static Logger logger = LogManager.getLogger(ServicioSesionCookie.class);
	
	private static Dictionary<String, Sesion> sesiones = new Hashtable<String, Sesion>();
	
	
	public static void guardarSesion (Sesion sesion) {
		logger.debug("SESION - Guardada sesion en servicio de Cookies");
		sesiones.put(sesion.getId(), sesion);
		sesion.marcarGuardada();
	}
	
	public static Sesion obtenerSesion(String id) {
		Sesion sesion = sesiones.get(id);
		if(sesion == null) sesion = new Sesion();
		return sesion;
	}
	

}
