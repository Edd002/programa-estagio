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
 * Filter FilterPosicaoVeiculo.
 */
public class FilterPosicaoVeiculo implements Filter {

	public FilterPosicaoVeiculo() {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
		request.getRequestDispatcher("WEB-INF/pages/posicao-veiculo.jsp").forward(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}
}