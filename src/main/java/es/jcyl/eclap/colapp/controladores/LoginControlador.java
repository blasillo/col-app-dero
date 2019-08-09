package es.jcyl.eclap.colapp.controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.jcyl.eclap.colapp.filtros.Sesion;
import es.jcyl.eclap.colapp.oad.LoginOad;
import es.jcyl.eclap.colapp.ot.Usuario;


@Controller
public class LoginControlador extends BaseControlador {
	
	//Logger logger = LogManager.getLogger(LoginControlador.class);
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView getLogin (Map<String, Object> modelo) {   
		
		try {
			logger.info("GET /login");
	        return new ModelAndView("login");
		}
		catch(Exception e) {
			logger.error("Error no esperado. Deteniendo la operacion.", e);
			return gestionarError("Error no esperado.", e);
		}
		
    }
	
	
	@RequestMapping(value="/autenticacion", method = RequestMethod.GET )
    public ModelAndView postLogin (HttpServletRequest request, 
    		                    HttpServletResponse response, 
    		                    @RequestParam("login") String login , 
    		                    @RequestParam("password") String password) throws IOException {
		
		logger.info( "Inicio de Autenticacion");
		
		
		Sesion sesion = ((Sesion)request.getAttribute("session"));
		
		Usuario usuario;		
	
		try {
			
			if(!sesion.estaAutenticado()) {
			
				usuario = LoginOad.validarUsuario( login , password);
			
				 if (usuario != null ){
						
			        	logger.info( "Iniciada sesion del usuario: " + login );
			        	
			        	
			        	sesion.setUsuarioAutenticado(usuario);
			        	
			        	return new ModelAndView("redirect:inicio");
					}
					else {
						logger.warn("Autenticación fallida");
						
						ModelAndView modelo = new ModelAndView("login");
						modelo.addObject("login", login);
						modelo.addObject("password", password);
						modelo.addObject("mensaje", "Nombre de usuario o contraseña incorrectos");
						
						return modelo;
					}
			}
			else {
				logger.warn("Usuario ya autenticado. Redirigiendo a inicio.");
				return new ModelAndView("redirect:inicio");
			}
			
		}
		catch (SQLException e) {
			logger.error("Error en la base de datos", e);
			return gestionarError ("Error en la base de datos.", e);
		}
		catch (Exception e) {
			logger.error("Error desconocido en servidor", e);
			return gestionarError ("Error desconocido en servidor.", e);
		}

    }
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView getLogout(HttpServletRequest request) {
		logger.info("GET /Logout");
		
		
		
		
		 return new ModelAndView("redirect:inicio");
	}
	
	
	
	
	

}
