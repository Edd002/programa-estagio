package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import controller.Negocio;
import model.Parada;

/**
 * @author Eduardo Augusto
 *
 * Servlet ServletParada.
 */
public class ServletParada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletParada() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("buscarPorId") != null)
			request.setAttribute("parada", loadParada(request.getParameter("textFieldId")));

		request.setAttribute("arrayListParadas", loadArrayParadas());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("arrayListMensagensErros", checkForm(request));
		request.setAttribute("arrayListParadas", loadArrayParadas());
	}

	/**
	 * @author Eduardo Augusto
	 * @return ArrayList<String>
	 * @param HttpServletRequest
	 * @exception
	 *
	 * Verificar se há erros no formulário (retorna um ArrayList dos erros, se vazio, não há erros)
	 */
	private static ArrayList<String> checkForm(HttpServletRequest request) {
		ArrayList<String> arrayListMensagensErros = new ArrayList<String>();

		String name = request.getParameter("textFieldName");
		if (name.equals(""))
			arrayListMensagensErros.add("O nome não pode estar em branco.");

		double latitude = 0;
		try {
			latitude = Double.parseDouble(request.getParameter("textFieldLatitude").replace(',', '.'));
		} catch (NumberFormatException numberFormatException) {
			arrayListMensagensErros.add("A latitude deve ser numérica e deve estar em um formato aceitável.");
		}

		double longitude = 0;
		try {
			longitude = Double.parseDouble(request.getParameter("textFieldLongitude").replace(',', '.'));
		} catch (NumberFormatException numberFormatException) {
			arrayListMensagensErros.add("A longitude deve ser numérica e deve estar em um formato aceitável.");
		}

		if (arrayListMensagensErros.isEmpty()) {
			try {
				Parada parada = new Parada(name, latitude, longitude);

				if (request.getParameter("cadastrar") != null) {
					Negocio.inserirParada(parada);
				} else if (request.getParameter("atualizar") != null) {
					long idParada = Long.parseLong(request.getParameter("textFieldId"));
					String radioButtonAtualizar = request.getParameter("radioButtonAtualizar");

					if (radioButtonAtualizar.equals("alterar"))
						Negocio.alterarParada(idParada, parada);
					else if (radioButtonAtualizar.equals("excluir"))
						Negocio.excluirParada(idParada);
				}
			} catch (HibernateException hibernateException) {
				arrayListMensagensErros.add("Erro ao interagir com banco de dados para minupulação de uma parada.");
			} catch (Exception exception) {
				arrayListMensagensErros.add("Erro ao interagir com o banco de dados.");
			}
		}

		return arrayListMensagensErros;
	}

	/**
	 * @author Eduardo Augusto
	 * @return
	 * @param HttpServletRequest
	 * @exception
	 *
	 * Carregar o array de paradas, se retornar vazio, ocorreu um erro ou não há paradas cadastradas.
	 */
	private static ArrayList<Parada> loadArrayParadas() {
		ArrayList<Parada> arrayListParada = new ArrayList<Parada>();

		try { arrayListParada = Negocio.consultarParadas(); }
		catch (HibernateException hibernateException) { }
		catch (Exception exception) { }

		return arrayListParada;
	}

	/**
	 * @author Eduardo Augusto
	 * @return
	 * @param HttpServletRequest
	 * @exception
	 *
	 * Buscar parada pelo id, se retornar nulo, ocorreu um erro na busca pelo id ou não foi encontrado uma parada com o id passado.
	 */
	private static Parada loadParada(String id) {
		Parada parada = null;

		try { parada = Negocio.buscarParadaPorId(Long.parseLong(id)); }
		catch (HibernateException hibernateException) { }
		catch (Exception exception) { }

		return parada;
	}
}