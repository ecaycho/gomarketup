package qreasymarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Horario;

import qreasymarket.util.ConexionBD;

public class HorarioDAO extends BaseDAO {

	public void insertarTarifa(Horario vo) throws DAOExcepcion {

		System.out.println("HorarioDAO: insertar horario");

		String query = "INSERT INTO horario(idhorario,turno1,turno2,turno3,turno4) VALUES (?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);

			stmt.setString(1, vo.getIdHorario());
			stmt.setString(2, vo.getTurno1());
			stmt.setString(3, vo.getTurno2());
			stmt.setString(4, vo.getTurno4());

			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se puedo insertar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public Collection<Horario> buscarPorHorario(String horario)
			throws DAOExcepcion {

		System.out.println("HorarioDAO: buscar horario(string horario)");
		String query = "select idhorario,turno1,turno2,turno3,turno4 from horario where idhorario like ?";
		Collection<Horario> listaHorario = new ArrayList<Horario>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + horario + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {

				Horario vo = new Horario();
				vo.setIdHorario(rs.getString("idhorario"));
				vo.setTurno1(rs.getString("turno1"));
				vo.setTurno2(rs.getString("turno2"));
				vo.setTurno3(rs.getString("turno3"));
				vo.setTurno4(rs.getString("turno4"));

				listaHorario.add(vo);

			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return listaHorario;
	}

	public Horario obtener(String IdHorario) throws DAOExcepcion {

		System.out.println("HorarioDAO: obtener (String IdHorario)");

		Horario vo = new Horario();

		String query = "select idhorario,turno1,turno2,turno3,turno4 from horario where idhorario=?";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, IdHorario);
			rs = stmt.executeQuery();

			if (rs.next()) {

				vo.setIdHorario(rs.getString(1));
				vo.setTurno1(rs.getString(2));
				vo.setTurno2(rs.getString(3));
				vo.setTurno3(rs.getString(4));
				vo.setTurno4(rs.getString(5));

			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public Horario actualizar(Horario vo) throws DAOExcepcion {

		System.out.println("HorarioDAO: actualizar(Horario vo)");
		String query = "update horario set  turno1=?,turno2=?,turno3=?,turno4=? where idhorario=?";
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);

			stmt.setString(1, vo.getTurno1());
			stmt.setString(2, vo.getTurno2());
			stmt.setString(3, vo.getTurno3());
			stmt.setString(4, vo.getTurno4());
			stmt.setString(5, vo.getIdHorario());

			int i = stmt.executeUpdate();
			if (i != 1) {

				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public Collection<Horario> listar() throws DAOExcepcion {
		Collection<Horario> horario = new ArrayList<Horario>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT idhorario,turno1,turno2,turno3,turno4 from horario";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Horario vo = new Horario();

				vo.setIdHorario(rs.getString("idhorario"));
				vo.setTurno1(rs.getString("turno1"));
				vo.setTurno2(rs.getString("turno2"));
				vo.setTurno3(rs.getString("turno3"));
				vo.setTurno4(rs.getString("turno4"));

				horario.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return horario;
	}

}
