package es.jcyl.eclap.colapp.controladores;


import es.jcyl.eclap.colapp.utiles.RespuestaGenerica;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;
import java.util.regex.Pattern;

@Controller
public class UtilesControlador {
    private static final String IP_ADDRESS = "ip";

    private static final Pattern IP_ADDRESS_PATTERN = Pattern.compile("\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b");


    @GetMapping( value = "/ping", produces = "application/json")
    public ResponseEntity<RespuestaGenerica<String>> obtenerResultados(
            @RequestParam(IP_ADDRESS) String ipAddress) throws IOException {
        Supplier<Boolean> validator = () -> StringUtils.isNotBlank(ipAddress);
        return new ResponseEntity<RespuestaGenerica<String>>(
                new RespuestaGenerica<String>(
                        this.respuestaDePing(ipAddress, validator.get()).toString(),
                        true),
                HttpStatus.OK);
    }



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

}
