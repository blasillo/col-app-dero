package es.jcyl.eclap.colapp.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpConfig {
	
	
	private int httpPort = 8080;
	
	Logger logger = LogManager.getLogger(HttpConfig.class);
	
	

}
