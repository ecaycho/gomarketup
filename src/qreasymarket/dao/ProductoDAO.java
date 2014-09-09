package qreasymarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Horario;
import qreasymarket.modelo.Producto;
import qreasymarket.util.ConexionBD;

public class ProductoDAO extends BaseDAO {

	public Producto obtener(int IdProducto) throws DAOExcepcion {
		Producto vo = new Producto();

		System.out.println("ProductoDAO: Obtener(int idproducto)");
		String query = "select producto.id_producto, producto.nombre_producto, marca.nombre_marca,categoria_tc.nombre_categoria,producto.precio,producto.unidad,producto.fecha_vencimiento,producto.promocion_producto,producto.descuento_producto from producto INNER JOIN marca ON marca.id_marca=producto.id_marca JOIN categoria_tc ON producto.id_categoria_tc=categoria_tc.id_categoria_tc where producto.id_producto=?";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, IdProducto);
			rs = stmt.executeQuery();
			if (rs.next()) {

				vo.setIdProducto(rs.getInt(1));
				vo.setNombreProducto(rs.getString(2));
				vo.setNombreMarca(rs.getString(3));
				vo.setNombreCategoria(rs.getString(4));
				vo.setPrecio(rs.getDouble(5));
				vo.setUnidad(rs.getString(6));
				vo.setFechaVencimiento(rs.getString(7));
				vo.setPromocionProducto(rs.getString(8));
				vo.setDescuento(rs.getDouble(9));

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

	public Producto actualizar(Producto vo) throws DAOExcepcion {

		String query = "update producto set precio=?,promocion_producto=?,descuento_producto=? where id_producto=?";
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setDouble(1, vo.getPrecio());
			stmt.setString(2, vo.getPromocionProducto());
			stmt.setDouble(3, vo.getDescuento());
			stmt.setInt(4, vo.getIdProducto());
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

	public Collection<Producto> buscarPorMarca(String NombreM)
			throws DAOExcepcion {

		String query = "select producto.id_producto, producto.nombre_producto, marca.nombre_marca,categoria_tc.nombre_categoria,producto.precio,producto.unidad, producto.fecha_vencimiento,producto.promocion_producto, producto.descuento_producto from producto INNER JOIN marca ON marca.id_marca=producto.id_marca JOIN categoria_tc ON producto.id_categoria_tc=categoria_tc.id_categoria_tc where  marca.nombre_marca like ?";
		Collection<Producto> ListaProductos = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);

			stmt.setString(1, "%" + NombreM + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Producto vo = new Producto();
				vo.setIdProducto(rs.getInt("id_producto"));
				vo.setNombreProducto(rs.getString("nombre_producto"));
				vo.setNombreMarca(rs.getString("nombre_marca"));
				vo.setNombreCategoria(rs.getString("nombre_categoria"));
				vo.setPrecio(rs.getDouble("precio"));
				vo.setUnidad(rs.getString("unidad"));
				vo.setFechaVencimiento(rs.getString("fecha_vencimiento"));
				vo.setPromocionProducto(rs.getString("promocion_producto"));
				vo.setDescuento(rs.getDouble("descuento_producto"));

				ListaProductos.add(vo);

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		System.out.println(ListaProductos.size());
		return ListaProductos;

	}

	public Collection<Producto> buscarPorNombre(String NombreP)
			throws DAOExcepcion {

		// String query =
		// "select producto.id_producto, producto.nombre_producto, marca.nombre_marca,categoria_tc.nombre_categoria,producto.precio,producto.unidad, producto.fecha_vencimiento,producto.promocion_producto, producto.descuento_producto from producto INNER JOIN marca ON marca.id_marca=producto.id_marca JOIN categoria_tc ON producto.id_categoria_tc=categoria_tc.id_categoria_tc where producto.nombre_producto like ?";

		String query = "select producto.id_producto, producto.nombre_producto, marca.nombre_marca,categoria_tc.nombre_categoria,producto.precio,producto.unidad, producto.fecha_vencimiento,producto.promocion_producto, producto.descuento_producto from producto INNER JOIN marca ON marca.id_marca=producto.id_marca JOIN categoria_tc ON producto.id_categoria_tc=categoria_tc.id_categoria_tc where producto.nombre_producto like ?";

		Collection<Producto> ListaProductos = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + NombreP + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Producto vo = new Producto();
				vo.setIdProducto(rs.getInt("id_producto"));
				vo.setNombreProducto(rs.getString("nombre_producto"));
				vo.setNombreMarca(rs.getString("nombre_marca"));
				vo.setNombreCategoria(rs.getString("nombre_categoria"));
				vo.setPrecio(rs.getDouble("precio"));
				vo.setUnidad(rs.getString("unidad"));
				vo.setPromocionProducto(rs.getString("promocion_producto"));
				vo.setDescuento(rs.getDouble("descuento_producto"));

				ListaProductos.add(vo);

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		System.out.println(ListaProductos.size());
		return ListaProductos;
	}

	public Collection<Producto> BuscarPorQR(String codigoqr)
			throws DAOExcepcion {

		String query = "SELECT id_producto,codigo_qr,nombre_producto,precio,promocion_producto,fecha_vencimiento from producto WHERE codigo_qr like ?";

		Collection<Producto> cliente = new ArrayList<Producto>();

		Connection con = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + codigoqr + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Producto vo = new Producto();
				vo.setIdProducto(rs.getInt("id_producto"));
				vo.setCodigoQr(rs.getString("codigo_qr"));
				vo.setNombreProducto(rs.getString("nombre_producto"));
				vo.setPrecio(rs.getDouble("precio"));
				vo.setPromocionProducto(rs.getString("promocion_producto"));
				vo.setFechaVencimiento(rs.getString("fecha_vencimiento"));

				cliente.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return cliente;
	}

	public Collection<Producto> buscarPorProducto(int idlistacompra,
			String estado, String nombre) throws DAOExcepcion {

		System.out
				.println("ProductoDAO: buscar NomProducto(string nombre,idlistacompra,estado)");
		// String query =
		// "select  distinct p.nombre_producto,p.precio,lc.id_lista_compra,c.id_cliente,dlc.id_producto,lc.estado,dlc.subtotal, SUM(dlc.subtotal) as total, dlc.cantidad from lista_compra lc INNER JOIN cliente c ON c.id_cliente=lc.id_cliente JOIN detalle_lista_compra dlc ON lc.id_lista_compra=dlc.id_lista_compra JOIN producto p ON dlc.id_producto=p.id_producto where lc.id_lista_compra like ?  and lc.estado like ? and p.nombre_producto like ?";
		String query = "select  distinct p.nombre_producto,p.precio,lc.id_lista_compra,c.id_cliente,dlc.id_producto,lc.estado,dlc.subtotal, dlc.cantidad from lista_compra lc INNER JOIN cliente c ON c.id_cliente=lc.id_cliente JOIN detalle_lista_compra dlc ON lc.id_lista_compra=dlc.id_lista_compra JOIN producto p ON dlc.id_producto=p.id_producto where lc.id_lista_compra like ?  and lc.estado like ? and p.nombre_producto like ?";

		Collection<Producto> listaProducto = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + idlistacompra + "%");
			stmt.setString(2, "%" + estado + "%");
			stmt.setString(3, "%" + nombre + "%");

			rs = stmt.executeQuery();
			while (rs.next()) {

				Producto vo = new Producto();

				vo.setNombreProducto(rs.getString("nombre_producto"));
				vo.setPrecio(rs.getDouble("precio"));
				vo.setSubtotal(rs.getDouble("subtotal"));
				vo.setCantidad(rs.getDouble("cantidad"));
				vo.setIdProducto(rs.getInt("id_producto"));
				vo.setEstado(rs.getString("estado"));
				// vo.setTotal(rs.getDouble("total"));

				listaProducto.add(vo);

			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return listaProducto;
	}

	public Collection<Producto> buscarTotalProducto(int idlistacompra,
			String estado) throws DAOExcepcion {

		System.out
				.println("ProductoDAO: SUBTOTAL(string idlistacompra,estado)");
		// String query =
		// "select  distinct p.nombre_producto,p.precio,lc.id_lista_compra,c.id_cliente,dlc.id_producto,lc.estado,dlc.subtotal, SUM(dlc.subtotal) as total, dlc.cantidad from lista_compra lc INNER JOIN cliente c ON c.id_cliente=lc.id_cliente JOIN detalle_lista_compra dlc ON lc.id_lista_compra=dlc.id_lista_compra JOIN producto p ON dlc.id_producto=p.id_producto where lc.id_lista_compra like ?  and lc.estado like ? and p.nombre_producto like ?";
		// String query
		// ="select dlc.subtotal, SUM(dlc.subtotal) as total, dlc.cantidad from lista_compra lc INNER JOIN cliente c ON c.id_cliente=lc.id_cliente JOIN detalle_lista_compra dlc ON lc.id_lista_compra=dlc.id_lista_compra JOIN producto p ON dlc.id_producto=p.id_producto where lc.id_lista_compra like ? and lc.estado like ?";
		String query = "select lc.monto_referencial,dlc.subtotal, SUM(dlc.subtotal) as total, dlc.cantidad from lista_compra lc INNER JOIN cliente c ON c.id_cliente=lc.id_cliente JOIN detalle_lista_compra dlc ON lc.id_lista_compra=dlc.id_lista_compra JOIN producto p ON dlc.id_producto=p.id_producto where lc.id_lista_compra like ? and lc.estado like ?";

		Collection<Producto> listaProducto = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + idlistacompra + "%");
			stmt.setString(2, "%" + estado + "%");
			

			rs = stmt.executeQuery();
			while (rs.next()) {

				Producto vo = new Producto();

				// vo.setNombreProducto(rs.getString("nombre_producto"));
				// vo.setPrecio(rs.getDouble("precio"));
				// vo.setSubtotal(rs.getDouble("subtotal"));
				// vo.setCantidad(rs.getDouble("cantidad"));

				vo.setMontoReferente(rs.getDouble("monto_referencial"));
				vo.setTotal(rs.getDouble("total"));

				listaProducto.add(vo);

			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return listaProducto;
	}

	public Collection<Producto> NuevoListado(int idlistacompra, String estado,
			String nombre) throws DAOExcepcion {
		
		System.out.println("NUEVO LISTADAO = BUSCAR NUEVA LISTA");
		
		String query = "select lc.estado,dlc.id_lista_compra,p.nombre_producto, p.precio,dlc.cantidad,(p.precio*dlc.cantidad) as subtotal_nuevo,p.id_producto from detalle_lista_compra dlc LEFT JOIN producto p ON dlc.id_producto=p.id_producto JOIN lista_compra lc ON lc.id_lista_compra=dlc.id_lista_compra where dlc.id_lista_compra like ? and lc.estado like ? and p.nombre_producto like ?";
		Collection<Producto> productos = new ArrayList<Producto>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;

		try {

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + idlistacompra + "%");
			stmt.setString(2, "%" + estado + "%");
			stmt.setString(3, "%" + nombre + "%");

			rs = stmt.executeQuery();
			while (rs.next()) {
				Producto p = new Producto();
				p.setNombreProducto(rs.getString("nombre_producto"));
				p.setPrecio(rs.getDouble("precio"));
				p.setCantidad(rs.getInt("cantidad"));
				p.setSubtotal(rs.getDouble("subtotal_nuevo"));
				p.setIdProducto(rs.getInt("id_producto"));

				productos.add(p);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return productos;
	}

	
	public Collection<Producto> NuevoTotalProducto(int idlistacompra,
			String estado) throws DAOExcepcion {
		System.out.println("ProductoDAO: NUEVOTOTAL(string idlistacompra,estado)");
		
		String query="select lc.estado,lc.monto_referencial,dlc.id_lista_compra,SUM((p.precio*dlc.cantidad))as total from detalle_lista_compra dlc LEFT JOIN producto p ON dlc.id_producto=p.id_producto JOIN lista_compra lc ON lc.id_lista_compra=dlc.id_lista_compra where dlc.id_lista_compra like ? and lc.estado like ?";
		
		Collection<Producto> productos = new ArrayList<Producto>();
		Connection  con =null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		
		try {
		
			con=ConexionBD.obtenerConexion();
		
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + idlistacompra + "%");
			stmt.setString(2, "%" + estado + "%");
			rs = stmt.executeQuery();

			while(rs.next()) {
				Producto p = new Producto();
				
				p.setMontoReferente(rs.getDouble("monto_referencial"));
				p.setTotal(rs.getDouble("total"));
				
				productos.add(p);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return productos;
	}


	
}
