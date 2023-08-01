package es.jcyl.eclap.colapp.controladores;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.jcyl.eclap.colapp.utiles.RespuestaGenerica;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;
import java.util.regex.Pattern;


@Slf4j
@RestController
public class UtilesControlador {
    private static final String IP_ADDRESS = "ip";
    private static final Pattern IP_ADDRESS_PATTERN = Pattern.compile("\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b");


    @GetMapping ("/admin/utiles/ping")
    public ModelAndView accederPing (){
        ModelAndView model = new ModelAndView("admin/consultaIp");

        return model;
    }

    @PostMapping (value = "/admin/utiles/ping",
            produces = "application/json")
    public ResponseEntity<RespuestaGenerica<String>> obtenerResultados(@RequestBody String direccionIp ) throws IOException {
        Supplier<Boolean> validator = () -> StringUtils.isNotBlank(direccionIp);
        return new ResponseEntity<RespuestaGenerica<String>>(
                new RespuestaGenerica<String>(
                        this.respuestaDePing(direccionIp, validator.get()).toString(),
                        true),
                HttpStatus.OK);
    }

    /*
    @GetMapping(value = "/admin/utiles/ping", produces = "application/json")
    public ResponseEntity<RespuestaGenerica<String>> obtenerResultados2 (@PathVariable(value="ip") final String ip) throws IOException {
        DireccionIp direccionIp = new DireccionIp();
        direccionIp.setIp(ip);

        Supplier<Boolean> validator = () -> StringUtils.isNotBlank(direccionIp.getIp());
        return new ResponseEntity<RespuestaGenerica<String>>(
                new RespuestaGenerica<String>(
                        this.respuestaDePing(direccionIp.getIp(), validator.get()).toString(),
                        true),
                HttpStatus.OK);
    }
    */




    private StringBuilder respuestaDePing(String ipAddress, boolean isValid) throws IOException {
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        StringBuilder stringBuilder = new StringBuilder();
        if (isValid) {
            Process process;
            if (!isWindows) {
                process =
                        new ProcessBuilder(new String[] {"sh", "-c", "ping -c 2 " + ipAddress})
                                .redirectErrorStream(true)
                                .start();
            } else {
                process =
                        new ProcessBuilder(new String[] {"cmd", "/c", "ping -n 2 " + ipAddress})
                                .redirectErrorStream(true)
                                .start();
            }
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                bufferedReader.lines().forEach(val -> stringBuilder.append(val).append("\n"));
            }
        }
        return stringBuilder;
    }




    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class DireccionIp {
        private String ip;
/*
        @JsonCreator
        public DireccionIp( @JsonProperty("ip")String ip) {
            this.ip = ip;
        }

        public DireccionIp() {}

        public String getIp () { return this.ip;}
        public void setIp (String ip) { this.ip = ip; }
*/

    }

}
