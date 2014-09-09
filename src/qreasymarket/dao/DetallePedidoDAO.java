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
import qreasymarket.modelo.DetallePedido;
import qreasymarket.modelo.ListaCompra;
import qreasymarket.modelo.Producto;
import qreasymarket.util.ConexionBD;

public class DetallePedidoDAO extends BaseDAO {

	public Collection<DetallePedido> CapturarId(int IdListaCompra)
			throws DAOExcepcion {

		String query = "SELECT detalle_lista_compra.id_lista_compra,producto.nombre_producto,producto.precio,detalle_lista_compra.cantidad,(producto.precio*detalle_lista_compra.cantidad) as subtotal from producto INNER JOIN detalle_lista_compra ON producto.id_producto= detalle_lista_compra.id_producto where detalle_lista_compra.id_lista_compra like ?";

		Collection<DetallePedido> detallepedido = new ArrayList<DetallePedido>();

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, IdListaCompra);
			rs = stmt.executeQuery();

			while (rs.next()) {
				DetallePedido vo = new DetallePedido();

				vo.setIdListaCompra(rs.getInt("id_lista_compra"));
				vo.setNombreProducto(rs.getString("nombre_producto"));
				vo.setPrecio(rs.getDouble("precio"));
				vo.setCantidad(rs.getInt("cantidad"));
				vo.setSubtotal(rs.getDouble("subtotal"));

				detallepedido.add(vo);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return detallepedido;
	}

	public DetallePedido obtener(int IdListaCompra) throws DAOExcepcion {
		DetallePedido vo = new DetallePedido();

		String query = "SELECT detalle_lista_compra.id_lista_compra,producto.nombre_producto,producto.precio,detalle_lista_compra.cantidad,(producto.precio*detalle_lista_compra.cantidad) as subtotal from producto INNER JOIN detalle_lista_compra ON producto.id_producto= detalle_lista_compra.id_producto where detalle_lista_compra.id_lista_compra=?";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, IdListaCompra);
			rs = stmt.executeQuery();

			if (rs.next()) {

				vo.setIdListaCompra(rs.getInt(1));
				vo.setNombreProducto(rs.getString(2));
				vo.setPrecio(rs.getDouble(3));
				vo.setCantidad(rs.getInt(4));
				vo.setSubtotal(rs.getDouble(5));

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

	public DetallePedido insertar(DetallePedido vo) throws DAOExcepcion {

		System.out.println("DetallePedidoDAO: insertar producto al carrito");
		String query = "INSERT INTO detalle_lista_compra(id_lista_compra,id_producto,cantidad,subtotal) VALUES (?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getIdListaCompra());
			stmt.setInt(2, vo.getIdProducto());
			stmt.setDouble(3, vo.getCantidad());
			stmt.setDouble(4, vo.getSubtotal());

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

	public DetallePedido actualizarProducto(DetallePedido vo)
			throws DAOExcepcion {

		String query = "update  producto INNER JOIN detalle_lista_compra ON producto.id_producto=detalle_lista_compra.id_producto SET detalle_lista_compra.cantidad =? where producto.nombre_producto=? and detalle_lista_compra.id_lista_compra=?";
		// String query =
		// "update detalle_lista_compra set cantidad=? where id_lista_compra=? and id_producto=?";
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setDouble(1, vo.getCantidad());
			stmt.setString(2, vo.getNombreProducto());
			stmt.setInt(3, vo.getIdListaCompra());

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

	public Collection<DetallePedido> ObtenerCantidad(int idlistacompra,
			int idproducto) throws DAOExcepcion {

		System.out
				.println("DetallePedidoDAO: OBTENER CANTIDAD(int idlistacompra ; int idproducto)");

		String query = "select lc.nombre_compra,dlc.cantidad from detalle_lista_compra dlc LEFT JOIN lista_compra lc ON lc.id_lista_compra=dlc.id_lista_compra where dlc.id_lista_compra like ? and dlc.id_producto like ?";
		// String
		// query="select cantidad from detalle_lista_compra where id_lista_compra like ? and id_producto like ?";

		// String query =
		// "select  distinct lc.id_lista_compra,lc.nombre_compra,c.id_cliente,c.nombres,c.apaterno,c.email,c.amaterno,lc.estado from lista_compra lc INNER JOIN cliente c ON c.id_cliente=lc.id_cliente  WHERE c.email like ? and lc.estado like ?";
		// String query =
		// "select  distinct dlc.cantidad,lc.id_lista_compra,lc.nombre_compra,c.id_cliente,c.nombres,c.apaterno,c.email,c.amaterno,lc.estado from lista_compra lc LEFT JOIN cliente c ON c.id_cliente=lc.id_cliente LEFT JOIN detalle_lista_compra dlc ON lc.id_lista_compra=dlc.id_lista_compra  WHERE c.email like ? and lc.estado like ?";

		Collection<DetallePedido> cantidades = new ArrayList<DetallePedido>();

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + idlistacompra + "%");
			stmt.setString(2, "%" + idproducto + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				DetallePedido vo = new DetallePedido();
				vo.setIdListaCompra(rs.getInt("id_lista_compra"));
				vo.setCantidad(rs.getDouble("cantidad"));
				vo.setIdProducto(rs.getInt("id_producto"));
				vo.setNombreProducto(rs.getString("nombre_compra"));
				cantidades.add(vo);

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return cantidades;
	}

	public void eliminarProducto(int idlistacompra, int idproducto)
			throws DAOExcepcion {

		System.out.println("PRODUCTODAO: Eliminar productos");
		String query = "DELETE FROM detalle_lista_compra where id_lista_compra=? and id_producto=?";

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);

			stmt.setInt(1, idlistacompra);
			stmt.setInt(2, idproducto);
			int i = stmt.executeUpdate();
			if (i != 1 && i != 2) {

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

	public void vaciarProducto(int idlistacompra)
			throws DAOExcepcion {

		System.out.println("detallePedidoDao: Vaciar productos");
		String query = "DELETE FROM detalle_lista_compra where id_lista_compra=?";

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
