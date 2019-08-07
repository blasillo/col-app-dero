package es.jcyl.eclap.colapp.filtros;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import es.jcyl.eclap.colapp.controladores.BaseControlador;

public class UsuarioInterceptor  extends HandlerInterceptorAdapter {
	
	private static Logger logger = LogManager.getLogger(BaseControlador.class);
	
	@Autowired
	private HttpSession session;
	
	
	@Override
	public boolean preHandle( HttpServletRequest req,
			             	  HttpServletResponse res, 
			             	  Object handler) throws Exception {
		
		logger.info("Interceptor preHandle - gestionando");
		
		
		return true;
		
	}
	
	
}
