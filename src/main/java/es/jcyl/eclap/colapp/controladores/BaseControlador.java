package es.jcyl.eclap.colapp.controladores;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

public abstract class BaseControlador {
	
	Logger logger = LogManager.getLogger(BaseControlador.class);
	
	public ModelAndView gestionarError(String mensaje, Exception e) {
		ModelAndView model = gestionarError (mensaje);
		model.addObject("exception", e);
		return model;
	}
	
	public ModelAndView gestionarError(String mensaje) {
		ModelAndView model = new ModelAndView("error");
		model.addObject("mensaje", mensaje);
		return model;
	}

}
