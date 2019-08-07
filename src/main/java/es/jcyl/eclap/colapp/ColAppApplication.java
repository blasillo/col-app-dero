package es.jcyl.eclap.colapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"es.jcyl.eclap.colapp.config", "es.jcyl.eclap.colapp.controladores", "es.jcyl.eclap.colapp.filtros"})
public class ColAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColAppApplication.class, args);
	}

}
