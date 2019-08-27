package es.jcyl.eclap.colapp.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ErrorControlador implements ErrorController {
	
	private static final String PATH = "error";
	
	 @RequestMapping(value = PATH)	 
	 public ModelAndView generaPaginaError (HttpServletRequest request ) {
		 
		 
		 
		 String errorMensaje = "Error interno de la aplicación";
		 
		 int httpErrorCode = getErrorCode(request);
		 switch (httpErrorCode) {
			 case 400: {
				 errorMensaje = "Código del error: 400 . Solicitud incorrecta";
		            break;
		        }
	         case 401: {
	        	 errorMensaje = "Código del error: 401. No autorizado";
	             break;
	         }		 
			 case 404: {
	             errorMensaje = "Código del error: 404. Recurso no encontrado";
	             break;
			 }
			 
			 case 500: {
	             errorMensaje = "Código del error: 500. Error de interno del servidor";
	             break;
			 }
			 
		 }
		 		 
		 return new ModelAndView("error" ,  "errorMensaje" , errorMensaje) ;
		 
	 }
	 
	 
	 private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
    }


	@Override
	public String getErrorPath() {
		return PATH;
	}
	 
	 

}
