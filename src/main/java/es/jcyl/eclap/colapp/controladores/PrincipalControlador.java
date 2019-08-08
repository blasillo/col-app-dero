package es.jcyl.eclap.colapp.controladores;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.jcyl.eclap.colapp.filtros.Sesion;
import es.jcyl.eclap.colapp.oad.CervezaOad;
import es.jcyl.eclap.colapp.oad.NotaOad;
import es.jcyl.eclap.colapp.oad.UsuarioOad;
import es.jcyl.eclap.colapp.ot.Cerveza;
import es.jcyl.eclap.colapp.ot.Nota;
import es.jcyl.eclap.colapp.ot.Usuario;





@Controller
public class PrincipalControlador extends BaseControlador {
	
	
	@RequestMapping(value = "/cervezas")
	public ModelAndView listadoCervezas() {		
		
		return buscarCervezas("");
	}
	
	@RequestMapping(value = "/cervezas", params = "busqueda")
	public ModelAndView buscarCervezas(@RequestParam("busqueda") String busqueda) {
		
		try {
			logger.info("GET /cervezas (busqueda = '" + busqueda + "')");
			
			List<Cerveza> lista = (new CervezaOad()).buscarPorNombre(busqueda);
			
			logger.info(  "Recuperadas :" + lista.size() );
			
			ModelAndView modelo = new ModelAndView("cervezas", "cervezas", lista);		
			modelo.addObject("consulta", busqueda);			
			return modelo;
		}
		catch(SQLException e) {
		
		}		
		catch(Exception e) {
			logger.error("Error no esperado.", e);
			return gestionarError("Error no esperado.", e);
		}
		return null;
	}
	
	
	@RequestMapping(value = "/cervezas", params = "id")
	public ModelAndView buscarCerveza(@RequestParam("id") int id, HttpServletRequest request) {
		try {
			logger.info("GET /cervezas (id = '" + id + "')");
			
			//Session session = ((Session)request.getAttribute("session"));
			HttpSession  sesion = request.getSession();
			Integer usuarioId = -1;
			
			if ( sesion.getAttribute("tieneSesion") != null  ) {
				logger.debug("Usuario autenticado.");
				usuarioId = (Integer) sesion.getAttribute("usuario_id");
			}
			else {
				logger.debug("Usuario no autenticado.");
			}
			
            Cerveza  cerveza =   (new CervezaOad()).buscarPorId ( id );
			
			// obtener tambien las notas			
			List<Nota> notas  = (new NotaOad()).buscarPorCervezaId( id );
			List<Nota> notasVisibles = new ArrayList<Nota>();
			for(Nota n : notas) {
				if(n.getNotaPublica() || n.getUsuarioId()  == usuarioId) {
					
					Usuario usuario = (new UsuarioOad()).buscarPorId(  n.getUsuarioId()  );					
					n.setAutor( usuario.getNombre() );					
					notasVisibles.add(n);
				}
			}
			
			
			ModelAndView modelo = new ModelAndView("cerveza", "cerveza", cerveza);			
			modelo.addObject("notas", notasVisibles);
			
			return modelo;
			
		}
		catch(SQLException e) {
				logger.error("Error en base de datos.", e);
				return gestionarError("Error en base de datos.", e);
		}
		catch(Exception e) {
			logger.error("Error no esperado.", e);
			return gestionarError("Error no esperado.", e);
		}
	}
	
	
	@RequestMapping(value = "/notas", params = "id", method = RequestMethod.GET)
	public ModelAndView nuevaNota (@RequestParam("id") int cervezaid, HttpServletRequest request) {
		
		try {
			logger.info("GET /notas (id = " + cervezaid + ")");
			
			//Session session = ((Session)request.getAttribute("session"));
			Sesion sesion = ((Sesion)request.getAttribute("session"));
			
			if ( sesion.estaAutenticado() ) {
				Cerveza cerveza = (new CervezaOad()).buscarPorId( cervezaid );
				
				return new  ModelAndView("nuevaNota", "cerveza", cerveza);
			}
			else {
				logger.warn("Usuario no autenticado. Redirección a login.");
				return new ModelAndView("redirect:login");
			}
			
			
		}
		catch(SQLException e) {
			logger.error("Error en base de datos.", e);
			return gestionarError("Error en base de datos.", e);
	    }		
		catch(Exception e) {
			logger.error("Error no esperado.", e);
			return gestionarError("Error no esperado.", e);
        }
		
	}
	
	
	@RequestMapping(value = "/notas/nueva", method = RequestMethod.POST)
	public ModelAndView crearNota (@RequestParam("titulo") String titulo, 
			                       @RequestParam("contenido") String contenido, 
			                       @RequestParam("notaPublica") Optional<String> notaPublica, 
			                       @RequestParam("cervezaid") Integer cervezaid, 
			                       HttpServletRequest request) {
		try {
			logger.info("POST /notas/nueva (...)");
			
			Sesion sesion = ((Sesion)request.getAttribute("session"));
			if ( sesion.estaAutenticado() ) {
				
				Cerveza cerveza = (new CervezaOad()).buscarPorId( cervezaid );
				
				Nota nota = new Nota ((long) -1 ,
						               (Timestamp) Timestamp.from(Instant.now()),
						               titulo,
						               contenido,
						               (Boolean) (notaPublica.isPresent() ? true : false) ,
						               (Integer) sesion.getUsuarioAutenticado().getId(),
						               (long) cervezaid );
				
			  	if ( nota.esValida() ) {
			  		if ( (new NotaOad()).insertarNota ( nota ) ) {
			  			
			  		}			  		
			  	}
			       
				
			}
			
			
			
			
		}
		catch(SQLException e) {
			logger.error("Error en base de datos.", e);
			return gestionarError("Error en base de datos.", e);
	    }		
		catch(Exception e) {
			logger.error("Error no esperado.", e);
			return gestionarError("Error no esperado.", e);
        }
		return null;
	}		

}
