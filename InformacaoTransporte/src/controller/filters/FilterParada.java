package controller.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Eduardo Augusto
 *
 * Filter FilterParada.
 */
public class FilterParada implements Filter {

	public FilterParada() {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
		request.getRequestDispatcher("WEB-INF/pages/parada.jsp").forward(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}
}