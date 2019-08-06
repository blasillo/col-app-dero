package es.jcyl.eclap.colapp.controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.jcyl.eclap.colapp.oad.CervezaOad;
import es.jcyl.eclap.colapp.ot.Cerveza;





@Controller
public class PrincipalControlador extends BaseControlador {
	
	
	@RequestMapping(value = "/cervezas")
	public ModelAndView listadoCervezas() {		
		
		return buscarCervezas("");
	}
	
	@RequestMapping(value = "/cervezas", params = "busqueda")
	public ModelAndView buscarCervezas(@RequestParam("busqueda") String busqueda) {
		
		try {
			logger.info("GET /cervezas");
			
			List<Cerveza> lista = (new CervezaOad()).buscarPorNombre(busqueda);
			
			logger.info(  "Recuperadas :" + lista.size() );
			
			return new ModelAndView("cervezas", "cervezas", lista);
		}
		//catch(SQLException e) {
		//}
		
		catch(Exception e) {
			logger.error("Unexpected error occurred. Aborting the operation", e);
			return gestionarError("Error no esperado.", e);
		}
	}

}
