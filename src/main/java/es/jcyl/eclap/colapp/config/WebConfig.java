package es.jcyl.eclap.colapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import es.jcyl.eclap.colapp.filtros.GestorSesionCookie;
import es.jcyl.eclap.colapp.filtros.UsuarioInterceptor;


@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	
	
	
	
	@Bean
    GestorSesionCookie getSessionManager() {
         return new GestorSesionCookie();
    }
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getSessionManager())
		                        .addPathPatterns("/**")
		                        .excludePathPatterns("/js/**")
		                        .excludePathPatterns("/css/**" )
		                        .excludePathPatterns("/imagenes/**" )
		                        .excludePathPatterns("/fontawesome/**" )
								.excludePathPatterns("/admin-portal/**")
								.excludePathPatterns("/nuevo-inicio-beta/**")
								.excludePathPatterns("/pagina-secreta/**")
				                .excludePathPatterns("/archivos/**");
	}

}
