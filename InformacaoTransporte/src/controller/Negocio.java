package controller;

import java.util.ArrayList;

import org.hibernate.HibernateException;

import model.Linha;
import model.Parada;
import model.PosicaoVeiculo;
import model.Veiculo;

/**
 * @author Eduardo Augusto
 *
 * Classe Negocio.
 */
public class Negocio {

	/**
	 * @author Eduardo Augusto
	 * @return ArrayList<Linha>
	 * @param int
	 * @exception HibernateException, Exception
	 *
	 * Recebe o identificador de uma parada e retorna as linhas associadas a parada informada.
	 */
	public static ArrayList<Linha> buscarLinhasPorParada(int idParada) throws HibernateException, HibernateException, Exception {
		ArrayList<Linha> arrayListLinhas = DAO.select("from Linha", Linha.class);
		ArrayList<Linha> arrayListLinhasAssociadasParada = new ArrayList<Linha>();

		for (Linha linha : arrayListLinhas)
			for (Parada parada : ((ArrayList<Parada>) linha.getParadas()))
				if (idParada == parada.getId())
					arrayListLinhasAssociadasParada.add(linha);

		return arrayListLinhasAssociadasParada;
	}

	/**
	 * @author Eduardo Augusto
	 * @return ArrayList<Veiculo>
	 * @param int
	 * @exception HibernateException, Exception
	 *
	 * Recebe o identificador de uma linha e retorna os veículos associados a linha informada.
	 */
	public static ArrayList<Veiculo> buscarVeiculosPorLinha(int idLinha) throws HibernateException, HibernateException, Exception {
		ArrayList<Veiculo> arrayListVeiculo = DAO.select("from Veiculo where id_linha = " + idLinha, Veiculo.class);
		return arrayListVeiculo;
	}

	/**
	 * @author Eduardo Augusto
	 * @return ArrayList<Parada>
	 * @param double, double
	 * @exception HibernateException, Exception
	 *
	 * Recebe uma posição (latitude, longitude) como parâmetro e retorna a parada mais proxima a posição informada.
	 */
	public static Parada buscarParadasProximas(double latitude, double longitude) throws HibernateException, HibernateException, Exception {
		Parada paradasMaisProxima = (Parada) DAO.selectUniqueResult("from parada as p order by abs(p.latitude - " + latitude + "), abs(p.longitude - " + longitude + ") limit 1", Parada.class);
		return paradasMaisProxima;
	}


	/* ------------------------------------------------------------------------------------------ PARADA ------------------------------------------------------------------------------------------ */
	/**
	 * @author Eduardo Augusto
	 * @return
	 * @param Parada
	 * @exception HibernateException, Exception
	 *
	 * Método para cadastrar uma parada.
	 */
	public static void inserirParada(Parada parada) throws HibernateException, Exception {
		DAO.insert(parada);
	}

	/**
	 * @author Eduardo Augusto
	 * @return ArrayList<Parada>
	 * @param
	 * @exception HibernateException, Exception
	 *
	 * Método para consultar paradas.
	 */
	public static ArrayList<Parada> consultarParadas() throws HibernateException, Exception {
		ArrayList<Parada> arrayListParada = DAO.select("from Parada", Parada.class);
		return arrayListParada;
	}

	/**
	 * @author Eduardo Augusto
	 * @return Parada
	 * @param long
	 * @exception HibernateException, Exception
	 *
	 * Método para consultar o parada por id.
	 */
	public static Parada buscarParadaPorId(long id) throws HibernateException, Exception {
		Parada parada = (Parada) DAO.selectUniqueResult("from Parada where id = " + id, Parada.class);
		return parada;
	}

	/**
	 * @author Eduardo Augusto
	 * @return
	 * @param long, Parada
	 * @exception HibernateException, Exception
	 *
	 * Método atualizar uma parada.
	 */
	public static void alterarParada(long id, Parada parada) throws HibernateException, Exception {
		DAO.update("update Parada set name = '" + parada.getName() + "', latitude = " + parada.getLatitude() + ", longitude = " + parada.getLongitude() + " where id = " + id);
	}

	/**
	 * @author Eduardo Augusto
	 * @return
	 * @param long
	 * @exception HibernateException, Exception
	 *
	 * Método excluir uma parada.
	 */
	public static void excluirParada(long id) throws HibernateException, Exception {
		DAO.update("delete from Parada where id = " + id);
	}
	/* -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */


	/* ------------------------------------------------------------------------------------------ LINHA ------------------------------------------------------------------------------------------- */
	/**
	 * @author Eduardo Augusto
	 * @return
	 * @param Linha
	 * @exception HibernateException, Exception
	 *
	 * Método para cadastrar uma linha.
	 */
	public static void inserirLinha(Linha linha) throws HibernateException, Exception {
		DAO.insert(linha);
	}

	/**
	 * @author Eduardo Augusto
	 * @return ArrayList<Linha>
	 * @param
	 * @exception HibernateException, Exception
	 *
	 * Método para consultar linhas.
	 */
	public static ArrayList<Linha> consultarLinhas() throws HibernateException, Exception {
		ArrayList<Linha> arrayListLinha = DAO.select("from Linha", Linha.class);
		return arrayListLinha;
	}

	/**
	 * @author Eduardo Augusto
	 * @return Linha
	 * @param long
	 * @exception HibernateException, Exception
	 *
	 * Método para consultar o linha por id.
	 */
	public static Linha buscarLinhaPorId(long id) throws HibernateException, Exception {
		Linha linha = (Linha) DAO.selectUniqueResult("from Linha where id = " + id, Linha.class);
		return linha;
	}

	/**
	 * @author Eduardo Augusto
	 * @return
	 * @param long, Linha
	 * @exception HibernateException, Exception
	 *
	 * Método atualizar uma linha.
	 */
	public static void alterarLinha(long id, Linha linha) throws HibernateException, Exception {
		DAO.update("update Linha set name = '" + linha.getName() + "' where id = " + id);
	}

	/**
	 * @author Eduardo Augusto
	 * @return
	 * @param long
	 * @exception HibernateException, Exception
	 *
	 * Método excluir uma linha.
	 */
	public static void excluirLinha(long id) throws HibernateException, Exception {
		DAO.update("delete from Linha where id = " + id);
	}
	/* -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */


	/* ----------------------------------------------------------------------------------------- VEÍCULO ------------------------------------------------------------------------------------------ */
	/**
	 * @author Eduardo Augusto
	 * @return
	 * @param Veiculo
	 * @exception HibernateException, Exception
	 *
	 * Método para cadastrar um veículo.
	 */
	public static void inserirVeiculo(Veiculo veiculo) throws HibernateException, Exception {
		DAO.insert(veiculo);
	}

	/**
	 * @author Eduardo Augusto
	 * @return ArrayList<Veiculo>
	 * @param
	 * @exception HibernateException, Exception
	 *
	 * Método para consultar veículos.
	 */
	public static ArrayList<Veiculo> consultarVeiculos() throws HibernateException, Exception {
		ArrayList<Veiculo> arrayListVeiculo = DAO.select("from Veiculo", Veiculo.class);
		return arrayListVeiculo;
	}

	/**
	 * @author Eduardo Augusto
	 * @return Veiculo
	 * @param long
	 * @exception HibernateException, Exception
	 *
	 * Método para consultar o veículo por id.
	 */
	public static Veiculo buscarVeiculoPorId(long id) throws HibernateException, Exception {
		Veiculo veiculo = (Veiculo) DAO.selectUniqueResult("from Veiculo where id = " + id, Veiculo.class);
		return veiculo;
	}

	/**
	 * @author Eduardo Augusto
	 * @return
	 * @param long, Veiculo
	 * @exception HibernateException, Exception
	 *
	 * Método atualizar um veículo.
	 */
	public static void alterarVeiculo(long id, Veiculo veiculo) throws HibernateException, Exception {
		DAO.update("update Veiculo set name = '" + veiculo.getName() + "', modelo = '" + veiculo.getModelo() + "', id_linha = " + veiculo.getLinha().getId() + " where id = " + id);
	}

	/**
	 * @author Eduardo Augusto
	 * @return
	 * @param long
	 * @exception HibernateException, Exception
	 *
	 * Método excluir um veículo.
	 */
	public static void excluirVeiculo(long id) throws HibernateException, Exception {
		DAO.update("delete from Veiculo where id = " + id);
	}
	/* -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */


	/* ------------------------------------------------------------------------------------ POSIÇÃO DO VEÍCULO ------------------------------------------------------------------------------------ */
	/**
	 * @author Eduardo Augusto
	 * @return
	 * @param PosicaoVeiculo
	 * @exception HibernateException, Exception
	 *
	 * Método para cadastrar uma posição de veículo.
	 */
	public static void inserirPosicaoVeiculo(PosicaoVeiculo posicaoVeiculo) throws HibernateException, Exception {
		DAO.insert(posicaoVeiculo);
	}

	/**
	 * @author Eduardo Augusto
	 * @return ArrayList<PosicaoVeiculo>
	 * @param
	 * @exception HibernateException, Exception
	 *
	 * Método para consultar posições de veículos.
	 */
	public static ArrayList<PosicaoVeiculo> consultarPosicoesVeiculos() throws HibernateException, Exception {
		ArrayList<PosicaoVeiculo> arrayListPosicaoVeiculo = DAO.select("from PosicaoVeiculo", PosicaoVeiculo.class);
		return arrayListPosicaoVeiculo;
	}

	/**
	 * @author Eduardo Augusto
	 * @return PosicaoVeiculo
	 * @param long
	 * @exception HibernateException, Exception
	 *
	 * Método para consultar posição de veículo por id.
	 */
	public static PosicaoVeiculo buscarPosicaoVeiculoPorId(long id) throws HibernateException, Exception {
		PosicaoVeiculo posicaoVeiculo = (PosicaoVeiculo) DAO.selectUniqueResult("from PosicaoVeiculo where id_veiculo = " + id, PosicaoVeiculo.class);
		return posicaoVeiculo;
	}

	/**
	 * @author Eduardo Augusto
	 * @return
	 * @param long, PosicaoVeiculo
	 * @exception HibernateException, Exception
	 *
	 * Método atualizar uma posição de veículo.
	 */
	public static void alterarPosicaoVeiculo(long id, PosicaoVeiculo posicaoVeiculo) throws HibernateException, Exception {
		DAO.update("update PosicaoVeiculo set " + " latitude = " + posicaoVeiculo.getLatitude() + ", longitude = " + posicaoVeiculo.getLongitude() + " where id_veiculo = " + id);
	}

	/**
	 * @author Eduardo Augusto
	 * @return
	 * @param long
	 * @exception HibernateException, Exception
	 *
	 * Método excluir uma posição de veículo.
	 */
	public static void excluirPosicaoVeiculo(long id) throws HibernateException, Exception {
		DAO.update("delete from PosicaoVeiculo where id_veiculo = " + id);
	}
	/* -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */
}