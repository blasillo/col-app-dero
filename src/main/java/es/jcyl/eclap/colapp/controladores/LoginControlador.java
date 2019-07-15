package es.jcyl.eclap.colapp.controladores;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.jcyl.eclap.colapp.oad.LoginOad;
import es.jcyl.eclap.colapp.ot.Usuario;


@Controller
@RequestMapping("/login")
public class LoginControlador {
	
	Logger logger = LogManager.getLogger(LoginControlador.class);
	
	
	@RequestMapping( method = RequestMethod.GET)
    public String login (Map<String, Object> modelo) {
        
        return "login";
    }
	
	
	@RequestMapping( method = RequestMethod.POST )
    public String validarLogin (HttpServletRequest request, HttpServletResponse response, 
    		                    @RequestBody String postPayload,
    		                    @RequestParam("login") String login , @RequestParam("password") String password) {
		
		logger.info( "Inicio de Login:" + postPayload );
		
		
		Usuario usuario = LoginOad.validarUsuario( login , password);
        if (usuario != null ){
			
        	logger.info( "Logeado" );
        	
        	crearSesion ( request, usuario);
        	crearCookies (response, usuario);
        	
		}
		else {
			logger.info( "NO logeado");
		}
		

		
		
        
        return "login";
    }
	
	
	
	private void crearSesion (HttpServletRequest request, Usuario usuario) {
		HttpSession session=request.getSession();	
        session.setAttribute("tieneSesion", "1");
        session.setAttribute("usuario_id", usuario.getId() );
        session.setAttribute("nombre_usuario", usuario.getNombre() );
        
	}
	
	
	private void crearCookies (HttpServletResponse response, Usuario usuario) {
		
		Cookie galleta =new Cookie ("mi_galleta","usuario");
        response.addCookie(galleta);

        response.addCookie( new Cookie ( "login", usuario.getLogin()) );
        response.addCookie( new Cookie ( "password", usuario.getPassword()) );
	}

}
