package es.jcyl.eclap.colapp.filtros;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import es.jcyl.eclap.colapp.controladores.BaseControlador;


@Component
public class GestorSesionCookie implements HandlerInterceptor {
	
	private final static String NOMBRE_COOKIE = "COL-APP-DERO";
	
	private static Logger logger = LogManager.getLogger(BaseControlador.class);
	
	
	@Override
    public boolean preHandle(HttpServletRequest request, 
    		                 HttpServletResponse response, 
    		                 Object handler) throws Exception {
		
		// Crear sesión vacia
		Sesion sesion = new Sesion();
		
		// Comprobar si existe sesion
		Enumeration<String> headers = request.getHeaders("Cookie");
		while(headers.hasMoreElements()) {
			String h = headers.nextElement();
			String[] cookies = h.split(";");
			for(String c : cookies) {
				c = c.trim();
				if(c.startsWith(NOMBRE_COOKIE + "=")) {
					
					sesion = ServicioSesionCookie.obtenerSesion(c.replaceFirst(NOMBRE_COOKIE + "=", ""));
					
					if(sesion.esNueva() )  {
						logger.debug("SESION - Encontrada cookie de sesion pero sin sesion en servidor. Iniciando una nueva");
					}
					else {
						logger.info("SESION - Usando sesión en servidor");
					}
					
				}
			}
		}
		
		request.setAttribute("session", sesion); 
		
		
		return true;	
	}
	
	
	@Override
    public void postHandle(HttpServletRequest request, 
    		               HttpServletResponse response, 
    		               Object handler, 
    		               ModelAndView modelAndView) throws Exception {
		
		Object o = request.getAttribute("session");
		if(o != null) {
			Sesion sesion = (Sesion) o; 
			
			if(sesion.esNueva() && !sesion.estaModificado() ) {
				
				ServicioSesionCookie.guardarSesion (sesion);
				
				String header = NOMBRE_COOKIE + "=" + sesion.getId();
				
				logger.debug("SESION - Nueva sesion encontrada, enviando cabecera con Set-Cookie");
				response.addHeader("Set-Cookie", header);
				
			}
		}	
	}

}
