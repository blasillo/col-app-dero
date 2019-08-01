package es.jcyl.eclap.colapp.controladores;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

public abstract class BaseControlador {
	
	Logger logger = LogManager.getLogger(BaseControlador.class);
	
	public ModelAndView handleError(String message, Exception e) {
		ModelAndView model = handleError(message);
		model.addObject("exception", e);
		return model;
	}
	
	public ModelAndView handleError(String message) {
		ModelAndView model = new ModelAndView("error");
		model.addObject("message", message);
		return model;
	}

}
