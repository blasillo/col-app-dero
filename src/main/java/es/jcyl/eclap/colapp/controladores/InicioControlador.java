package es.jcyl.eclap.colapp.controladores;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioControlador {
	
	
	@RequestMapping("/")
    public String index (Map<String, Object> modelo) {
        
        return "index";
    }
	
	
	@RequestMapping("/inicio")
    public String inicio (Map<String, Object> modelo, HttpServletResponse response) {
        response.setHeader("X_FLAG", "FLAG{En_1a_cab3CEr4}");
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

    @GetMapping("/nuevo-inicio-beta")
    public String redirect() {
        return "redirect:/nuevo-inicio-beta/index.html";
    }

    @GetMapping({"/admin-portal", "/admin-portal/"})
    public String redirectAdminPortal() {
        return "redirect:/admin-portal/index.html";
    }

    @GetMapping({"/admin-portal", "/pagina-secreta/"})
    public String redirectPaginaSecreta() {
        return "redirect:/pagina-secreta/index.html";
    }

}
