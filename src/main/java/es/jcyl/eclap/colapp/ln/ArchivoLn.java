package es.jcyl.eclap.colapp.ln;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class ArchivoLn {
    public static boolean guardarArchivo (MultipartFile multipartFile, String filepath ){

        boolean result = false;
        String fileName  = multipartFile.getOriginalFilename();
        String location = filepath;
        File pathFile = new File(location);
        if(!pathFile.exists()){
            pathFile.mkdir();
        }
        pathFile = new File(location + File.separator + fileName);
        try {
            multipartFile.transferTo(pathFile);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
