package qreasymarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.security.auth.login.LoginException;
import javax.servlet.jsp.tagext.TryCatchFinally;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.excepcion.LoginExcepcion;
import qreasymarket.modelo.Cliente;
import qreasymarket.modelo.DetallePedido;
import qreasymarket.modelo.ListaCompra;
import qreasymarket.util.ConexionBD;

public class ListaCompraDAO extends BaseDAO {

	public ListaCompra insertar(ListaCompra vo) throws DAOExcepcion {

		String query = "INSERT INTO lista_compra(id_lista_compra,nombre_compra,servicio_delivery,monto_referencial,id_cliente,estado) VALUES (?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getIdListaCompra());
			stmt.setString(2, vo.getNombreCompra());
			stmt.setString(3, vo.getServicioDelivery());
			stmt.setDouble(4, vo.getMontoReferencial());
			stmt.setInt(5, vo.getIdCliente());
			stmt.setString(6, vo.getEstado());

			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
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

	public Collection<ListaCompra> BuscarClientePorEmail(String Email)
			throws DAOExcepcion {

		String query = "select distinct lc.id_lista_compra,lc.nombre_compra,c.id_cliente,c.nombres,c.apaterno,c.amaterno,c.email from lista_compra lc INNER JOIN cliente c ON c.id_cliente=lc.id_cliente JOIN detalle_lista_compra dlc ON lc.id_lista_compra=dlc.id_lista_compra WHERE c.email like ?";
		Collection<ListaCompra> listacompra = new ArrayList<ListaCompra>();

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + Email + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				ListaCompra vo = new ListaCompra();
				vo.setIdListaCompra(rs.getInt("id_lista_compra"));
				vo.setNombreCompra(rs.getString("nombre_compra"));
				vo.setNombres(rs.getString("nombres"));
				vo.setApaterno(rs.getString("apaterno"));
				vo.setAmaterno(rs.getString("amaterno"));
				vo.setEmail(rs.getString("email"));

				listacompra.add(vo);

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return listacompra;
	}

	public Collection<ListaCompra> BuscarPorEmailActual(String email,
			String estado) throws DAOExcepcion {

		System.out
				.println("ListaCompraDAO: buscar EmailActual(string email ; string estado)");
		String query = "select  distinct lc.id_lista_compra,lc.nombre_compra,c.id_cliente,c.nombres,c.apaterno,c.email,c.amaterno,lc.estado from lista_compra lc INNER JOIN cliente c ON c.id_cliente=lc.id_cliente  WHERE c.email like ? and lc.estado like ?";
		// String query =
		// "select  distinct dlc.cantidad,lc.id_lista_compra,lc.nombre_compra,c.id_cliente,c.nombres,c.apaterno,c.email,c.amaterno,lc.estado from lista_compra lc LEFT JOIN cliente c ON c.id_cliente=lc.id_cliente LEFT JOIN detalle_lista_compra dlc ON lc.id_lista_compra=dlc.id_lista_compra  WHERE c.email like ? and lc.estado like ?";

		Collection<ListaCompra> useractual = new ArrayList<ListaCompra>();

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + email + "%");
			stmt.setString(2, "%" + estado + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				ListaCompra vo = new ListaCompra();
				vo.setIdListaCompra(rs.getInt("id_lista_compra"));
				vo.setNombreCompra(rs.getString("nombre_compra"));
				vo.setIdCliente(rs.getInt("id_cliente"));
				vo.setNombres(rs.getString("nombres"));
				vo.setApaterno(rs.getString("apaterno"));
				vo.setEmail(rs.getString("email"));
				vo.setAmaterno(rs.getString("amaterno"));
				// vo.setCantidad(rs.getDouble("cantidad"));

				useractual.add(vo);

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return useractual;
	}

	public ListaCompra actualizarEstado(ListaCompra vo) throws DAOExcepcion {

		System.out.println("ACTUALIZAR DAO= LISTA PEDIDO");
		String query = "update lista_compra set estado=? where id_lista_compra=?";

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getEstado());
			stmt.setInt(2, vo.getIdListaCompra());
			
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
	
	public Collection<ListaCompra> BuscarListas (String nombre,int idlistacompra,String estado) throws DAOExcepcion{
		
		System.out.println("LISTADAO: Burcas Listas");
		String query ="select nombre_compra,id_lista_compra,estado from lista_compra where nombre_compra like ? and id_lista_compra like ? and estado like ?";
		
		Collection<ListaCompra> buscarlista = new ArrayList<ListaCompra>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			stmt.setString(2, "%" + idlistacompra + "%");
			stmt.setString(3, "%" + estado + "%");
			rs = stmt.executeQuery();

			while(rs.next()){
				ListaCompra vo = new ListaCompra();
				vo.setNombreCompra(rs.getString("nombre_compra"));
				vo.setEstado(rs.getString("estado"));
				buscarlista.add(vo);
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		return buscarlista;
		
	}


	public void eliminarLista(int idlistacompra)
			throws DAOExcepcion {

		System.out.println("eliminarLista: eliminarLista");
		String query = "DELETE FROM lista_compra where id_lista_compra=?";

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);

			stmt.setInt(1, idlistacompra);
			
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



}
