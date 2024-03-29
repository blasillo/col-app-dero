package es.jcyl.eclap.colapp.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
@WebFilter("/*")
public class CabecerasFiltro implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {


		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		httpServletResponse.setHeader("X-XSS-Protection", "0" );
		
		chain.doFilter(request, response);
	}
	

}
