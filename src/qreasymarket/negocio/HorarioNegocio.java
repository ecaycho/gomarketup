package qreasymarket.negocio;

import java.util.Collection;

import qreasymarket.dao.HorarioDAO;
import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Horario;

public class HorarioNegocio {

	public Collection<Horario> Buscarhorario(String horario) throws DAOExcepcion {
		HorarioDAO dao = new HorarioDAO();

		return dao.buscarPorHorario(horario);

	}

	public Horario obtenerHorario(String idhorario) throws DAOExcepcion {

		HorarioDAO dao = new HorarioDAO();

		return dao.obtener(idhorario);

	}

	public void actualizarHorario(String idhorario, String turno1,
			String turno2, String turno3, String turno4) throws DAOExcepcion {

		Horario modelo = new Horario();

		modelo.setIdHorario(idhorario);
		modelo.setTurno1(turno1);
		modelo.setTurno2(turno2);
		modelo.setTurno3(turno3);
		modelo.setTurno4(turno4);

		HorarioDAO dao = new HorarioDAO();
		dao.actualizar(modelo);

	}

	public Collection<Horario> listaHorario() throws DAOExcepcion {
		HorarioDAO dao = new HorarioDAO();

		return dao.listar();

	}

}
