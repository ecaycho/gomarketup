package qreasymarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Tarifa;
import qreasymarket.util.ConexionBD;

public class TarifasDAO extends BaseDAO {

	public void insertarTarifa(Tarifa vo) throws DAOExcepcion {

		System.out.println("TarifaDAO: insertar tarifa");

		String query = "INSERT INTO tarifas(id_tarifa,distrito,monto) VALUES (?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);

			stmt.setInt(1, vo.getIdTarifa());
			stmt.setString(2, vo.getDistrito());
			stmt.setDouble(3, vo.getMonto());

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

	public Collection<Tarifa> buscarPorDistrito(String distrito)
			throws DAOExcepcion {

		System.out.println("TarifaDAO: buscar distrito(string distrito)");
		String query = "select id_tarifa,distrito, monto from tarifas where distrito like ?";
		Collection<Tarifa> listarifa = new ArrayList<Tarifa>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + distrito + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {

				Tarifa vo = new Tarifa();
				vo.setIdTarifa(rs.getInt("id_tarifa"));
				vo.setDistrito(rs.getString("distrito"));
				vo.setMonto(rs.getDouble("monto"));

				listarifa.add(vo);

			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return listarifa;
	}

	public Tarifa obtener(int IdTarifa) throws DAOExcepcion {

		System.out.println("TarifaDAO: obtener (int idtarifa)");

		Tarifa vo = new Tarifa();

		String query = "select id_tarifa,distrito,monto from tarifas where id_tarifa=?";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, IdTarifa);
			rs = stmt.executeQuery();

			if (rs.next()) {
				vo.setIdTarifa(rs.getInt(1));
				vo.setDistrito(rs.getString(2));
				vo.setMonto(rs.getDouble(3));

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

	public void eliminar(int IdTarifa) throws DAOExcepcion {
		System.out.println("TarifaDAO: eliminar distrito");
		String query = "DELETE FROM tarifas where id_tarifa=? ";

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, IdTarifa);
			int i = stmt.executeUpdate();
			if (i != 1) {

				throw new SQLException("No se pudo eliminar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}

	}

	public Tarifa actualizar(Tarifa vo) throws DAOExcepcion {

		System.out.println("TarifaDAO: actualizar(Tarifa vo)");
		String query = "update tarifas set  distrito=?, monto=? where id_tarifa=?";
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, vo.getDistrito());
			stmt.setDouble(2, vo.getMonto());
			stmt.setInt(3, vo.getIdTarifa());
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

}
