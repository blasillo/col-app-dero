package es.jcyl.eclap.colapp.controladores;

import es.jcyl.eclap.colapp.ln.ArchivoLn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@Controller
public class SubirArchivoControlador extends BaseControlador {

    @Autowired
    ServletContext context;


    @RequestMapping(value = "/subir-archivo")
    public ModelAndView subirArchivo() {

        ModelAndView model = new ModelAndView("subirArchivo");

        return model;
    }

    @PostMapping(value="/subir-archivo")
    public ModelAndView  guardarArchivo(HttpServletRequest servletRequest,
                                        @RequestParam("archivo") MultipartFile multipartFile) {

        String relativeWebPath = "/archivos";

        String absoluteFilePath = servletRequest.getServletContext().getRealPath(relativeWebPath);


        long fileSize = multipartFile.getSize();
        String fileName = multipartFile.getOriginalFilename();

        ArchivoLn.guardarArchivo( multipartFile, absoluteFilePath);


        ModelAndView model = new ModelAndView("inicio");


        return model;
    }
}
