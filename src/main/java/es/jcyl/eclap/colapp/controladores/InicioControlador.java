package es.jcyl.eclap.colapp.controladores;

import java.util.Map;

import javax.servlet.http.HttpSession;

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
	
	@RequestMapping("/logout")
    public String logout (HttpSession session) {
		
		session.invalidate();        
        return "inicio";
    }
	
	
	
	@RequestMapping("/principal")
    public String principal (Map<String, Object> modelo) {
        
        return "principal";
    }

}
