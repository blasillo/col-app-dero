package es.jcyl.eclap.colapp.controladores;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import es.jcyl.eclap.colapp.filtros.Sesion;
import es.jcyl.eclap.colapp.ln.CervezaLn;
import es.jcyl.eclap.colapp.ln.NotaLn;


import es.jcyl.eclap.colapp.ot.Cerveza;
import es.jcyl.eclap.colapp.ot.Nota;







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
			
			List<Cerveza> lista = CervezaLn.buscarPorNombre ( busqueda); 
			
			logger.info(  "Recuperadas :" + lista.size() );
			
			ModelAndView modelo = new ModelAndView("cervezas", "cervezas", lista);		
			modelo.addObject("consulta", busqueda);			
			return modelo;
		}
		catch(SQLException e) {
			logger.error("Error en base de datos.", e);
			return gestionarError("Error no esperado.", e);
		}		
		catch(Exception e) {
			logger.error("Error no esperado.", e);
			return gestionarError("Error no esperado.", e);
		}
	}
	
	
	@RequestMapping(value = "/cervezas", params = "id")
	public ModelAndView buscarCerveza(@RequestParam("id") int id, HttpServletRequest request) {
		try {
			logger.info("GET /cervezas (id = '" + id + "')");
			
            Sesion sesion = ((Sesion)request.getAttribute("session"));
            
            int usuarioId = -1;
			
			if ( sesion.estaAutenticado() ) {
				usuarioId = sesion.getUsuarioAutenticado().getId();
			}
						
            Cerveza  cerveza = CervezaLn.getCervezaPorId( id );
			
			// obtener tambien las notas			
            
			List<Nota> notas  = NotaLn.getNotasPorCerveza( id );
			List<Nota> notasVisibles = new ArrayList<Nota>();
			for(Nota n : notas) {
				if(n.getNotaPublica() || n.getUsuarioId()  == usuarioId) {
																	
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
	
	
	
	@ResponseBody
	@RequestMapping(
			  value = "/cervezas/xml", 
			  method = RequestMethod.GET,
			  produces = MediaType.APPLICATION_XML_VALUE ) 
	public ResponseEntity<List<Cerveza>> todasCervezasXML() {
		
		try {
			logger.info("GET /cervezas/xml");
			List<Cerveza> lista = CervezaLn.buscarPorNombre ("");
			return new ResponseEntity<List<Cerveza>> ( lista , HttpStatus.OK);
		}
		catch(SQLException e) {}
		
		return null;
	}
	
	
	
	@RequestMapping(value = "/notas", params = "id", method = RequestMethod.GET)
	public ModelAndView nuevaNota (@RequestParam("id") int cervezaid, HttpServletRequest request) {
		
		try {
			logger.info("GET /notas (id = " + cervezaid + ")");
			
			//Session session = ((Session)request.getAttribute("session"));
			Sesion sesion = ((Sesion)request.getAttribute("session"));
			
			if ( sesion.estaAutenticado() ) {
								
				Cerveza cerveza = CervezaLn.getCervezaPorId(cervezaid);
				
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
	
	
	@RequestMapping(value = "/notas_usuario")
	public ModelAndView usuarioNotas(HttpServletRequest request) {
				
		try {
			logger.info("GET /notas/usuario");
			Sesion sesion = ((Sesion)request.getAttribute("session"));
			
			if ( sesion.estaAutenticado() ) {
				
				List<Nota> notas = NotaLn.getNotasPorUsuario(sesion.getUsuarioAutenticado().getId()); 

				return new ModelAndView("notas", "notas", notas);
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
	
	
	@RequestMapping(value = "/notas_nueva", method = RequestMethod.POST)
	public ModelAndView crearNota (@RequestParam("titulo") String titulo, 
			                       @RequestParam("contenido") String contenido, 
			                       @RequestParam("notaPublica") Optional<String> notaPublica, 
			                       @RequestParam("cervezaid") Integer cervezaid, 
			                       HttpServletRequest request) {
		try {
			logger.info("POST /notas_nueva (...)");
			
			Sesion sesion = ((Sesion)request.getAttribute("session"));
			if ( sesion.estaAutenticado() ) {
				
				//Cerveza cerveza = CervezaLn.getCervezaPorId( cervezaid );
										
				Nota nota = new Nota ((long) -1 ,
						               (Timestamp) Timestamp.from(Instant.now()),
						               titulo,
						               contenido,
						               (Boolean) (notaPublica.isPresent() ? true : false) ,
						               (Integer) sesion.getUsuarioAutenticado().getId(),
						               (long) cervezaid );
				
			  	if ( nota.esValida() ) {
			  		if ( NotaLn.insertarNota( nota ) ) {			  			
			  			logger.info("Nota insertada correctamente! Redirigiendo.");
						return new ModelAndView("redirect:cervezas?id=" + nota.getCervezaId() );
					}
					else {
						logger.info("La modificación de los datos ha fallado en la base de datos.");
						ModelAndView modelo = new ModelAndView("nuevaNota", "nota", nota);	
						modelo.addObject("error", "La introducción de los datos ha fallado por motivos desconocidos.");
						return modelo;
					}		  		
			  	}
			  	else { // no valida
			  		logger.info("Los datos proporcionados no son válidos.");
					ModelAndView modelo = new ModelAndView("nuevaNota", "nota", nota);
					modelo.addObject("error", "Datos no válidos. El título y el comentario son obligatorios.");
					return modelo;
			  	}
			  	
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
	
	@RequestMapping(value = "/notas_editar", params = "id", method = RequestMethod.GET)
	public ModelAndView editarNota(@RequestParam("id") int id, HttpServletRequest request) {
		
		try {
			logger.info("GET /notas_editar (id = " + id + ")" );
		
			Sesion sesion = ((Sesion)request.getAttribute("session"));
			if ( sesion.estaAutenticado() ) {
				
				Nota nota = NotaLn.getNotaPorId(id);				
				
				return new ModelAndView("editarNota", "nota", nota);
				
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
	
	
	@RequestMapping(value = "/notas_modificar", method = RequestMethod.POST)
	public ModelAndView modificarNota (@RequestParam("id") int id,
			                           @RequestParam("titulo") String titulo, 
			                           @RequestParam("contenido") String contenido, 
			                           @RequestParam("notaPublica") Optional<String> notaPublica, 
			                           HttpServletRequest request) {
									
		
		try {
			
			logger.info("POST /notas_modificar (id = " + id + ")");
			
			Sesion sesion = ((Sesion)request.getAttribute("session"));
			if ( sesion.estaAutenticado() ) {
				
				Nota nota = NotaLn.getNotaPorId(id);
				
				nota.setTitulo (titulo);
				nota.setContenido(contenido);
				nota.setNotaPublica( notaPublica.isPresent() ? true : false );
				
				if ( nota.esValida() ) {				
					if( NotaLn.modificarNota( nota )) {
						
						logger.info("Actualización correctamente grabada! Redirigiendo.");
						return new ModelAndView("redirect:cervezas?id=" + nota.getCervezaId() );
					}
					else {
						logger.info("La modificación de los datos ha fallado en la base de datos.");
						ModelAndView modelo = new ModelAndView("editarNota", "nota", nota);	
						modelo.addObject("error", "La modificación de los datos ha fallado por motivos desconocidos.");
						return modelo;
					}
				}
				else {
					logger.info("Los datos proporcionados no son válidos.");
					ModelAndView modelo = new ModelAndView("editarNota", "nota", nota);
					modelo.addObject("error", "Datos no válidos. El título y el comentario son obligatorios.");
					return modelo;
				}
				
				
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


	@PostMapping("/mensaje")
	public ResponseEntity<?> verMensajeViaAjax() {
		AjaxResponseBody result = new AjaxResponseBody();
		result.setMensaje("FLAG{C0NsEGuis73_El_4jAx}");

		return ResponseEntity.ok(result);
	}

	class AjaxResponseBody {
		String mensaje;

		public String getMensaje() { return mensaje;}
		public void setMensaje(String m) { this.mensaje = m; }
	}




}
