package qreasymarket.negocio;

import java.util.Collection;

import qreasymarket.dao.TarifasDAO;
import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Tarifa;

public class TarifaNegocio {

	public void insertarTarifa(String distrito, double monto)
			throws DAOExcepcion {

		Tarifa modelo = new Tarifa();
		modelo.setDistrito(distrito);
		modelo.setMonto(monto);

		TarifasDAO dao = new TarifasDAO();
		dao.insertarTarifa(modelo);

	}

	public Collection<Tarifa> buscarTarifa(String distrito) throws DAOExcepcion {
		TarifasDAO dao = new TarifasDAO();

		return dao.buscarPorDistrito(distrito);
	}

	public Tarifa obtenerTarifa(int idtarifa) throws DAOExcepcion {

		TarifasDAO dao = new TarifasDAO();
		return dao.obtener(idtarifa);
	}

	public void eliminarTarifa(int idtarifa) throws DAOExcepcion {
		TarifasDAO dao = new TarifasDAO();
		dao.eliminar(idtarifa);
	}

	public void actualizarTarifa(int idtarifa, String distrito, double monto)
			throws DAOExcepcion {

		Tarifa modelo = new Tarifa();

		modelo.setIdTarifa(idtarifa);
		modelo.setDistrito(distrito);
		modelo.setMonto(monto);

		TarifasDAO dao = new TarifasDAO();
		dao.actualizar(modelo);
	}
}
