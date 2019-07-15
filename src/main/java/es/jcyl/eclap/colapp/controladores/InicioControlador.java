package es.jcyl.eclap.colapp.controladores;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioControlador {
	
	
	@RequestMapping("/")
    public String index (Map<String, Object> modelo) {
        
        return "index";
    }
	
	
	@RequestMapping("/inicio")
    public String inicio (Map<String, Object> modelo) {
        
        return "inicio";
    }

}
