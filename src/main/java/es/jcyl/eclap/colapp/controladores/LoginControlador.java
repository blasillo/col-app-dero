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
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST )
    public ModelAndView postLogin (HttpServletRequest request, 
    		                    HttpServletResponse response, 
    		                    @RequestParam("login") String login , 
    		                    @RequestParam("password") String password) throws IOException {
		
		logger.info( "Inicio de Autenticacion");
		
		
		//Session session = ((Session)request.getAttribute("session"));
		
		
		Usuario usuario;		
	
		try {
			 usuario = LoginOad.validarUsuario( login , password);
			 
			 
			
			 if (usuario != null ){
					
		        	logger.info( "Iniciada sesion del usuario: " + login );
		        	
		        	crearSesion ( request, usuario);
		        	crearCookies (response, usuario);
		        			        	
		        	return new ModelAndView("redirect:principal");
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
		
		destruirSesion (request );
		
		
		 return new ModelAndView("redirect:inicio");
	}
	
	
	
	
	private void crearSesion (HttpServletRequest request, Usuario usuario) {
		HttpSession session=request.getSession();	
        session.setAttribute("tieneSesion", "1");
        session.setAttribute("usuario_id", usuario.getId() );
        session.setAttribute("nombre_usuario", usuario.getNombre() );
        
	}
	
	private void destruirSesion (HttpServletRequest request) {
		HttpSession session=request.getSession();	
        session.setAttribute("tieneSesion", null );
        session.setAttribute("usuario_id", null );
        session.setAttribute("nombre_usuario", null );
        
	}
	
	
	private void crearCookies (HttpServletResponse response, Usuario usuario) {
		
		Cookie galleta =new Cookie ("privilegios","usuario");
        response.addCookie(galleta);

        response.addCookie( new Cookie ( "login", usuario.getEmail() ));
        response.addCookie( new Cookie ( "password", usuario.getPassword() ));
	}

}
