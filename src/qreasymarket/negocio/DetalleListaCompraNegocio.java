package qreasymarket.negocio;

import java.util.Collection;

import qreasymarket.dao.DetallePedidoDAO;
import qreasymarket.dao.ListaCompraDAO;
import qreasymarket.excepcion.DAOExcepcion;

import qreasymarket.modelo.DetallePedido;
import qreasymarket.modelo.ListaCompra;

public class DetalleListaCompraNegocio {

	public DetallePedido insertar(int idListaCompra,int idProducto, Double Cantidad, Double subtotal)
			throws DAOExcepcion {

		DetallePedido vo = new DetallePedido();
		
		vo.setIdListaCompra(idListaCompra);
		vo.setIdProducto(idProducto);
		vo.setCantidad(Cantidad);
		vo.setSubtotal(subtotal);
		

		DetallePedidoDAO dao = new DetallePedidoDAO();
		return dao.insertar(vo);

	}

	public Collection<ListaCompra> buscarPorEmailActual(String email,String estado)
			throws DAOExcepcion {
		ListaCompraDAO dao = new ListaCompraDAO();

		return dao.BuscarPorEmailActual(email,estado);
	}

	
	public void actualizarProducto(double cantidad, String nombreproducto,int idlistacompra) throws DAOExcepcion {

		DetallePedido modelo = new DetallePedido();
		modelo.setCantidad(cantidad);
		modelo.setNombreProducto(nombreproducto);
		modelo.setIdListaCompra(idlistacompra);
		
		DetallePedidoDAO dao = new DetallePedidoDAO();
		dao.actualizarProducto(modelo);
	}

	public Collection<DetallePedido> ObtenerCantidad(int idlistacompra,int idproducto)
			throws DAOExcepcion {
		DetallePedidoDAO dao = new DetallePedidoDAO();

		return dao.ObtenerCantidad(idlistacompra, idproducto);
	}
	
	public void eliminarProducto(int idlistacompra,int idproducto) throws DAOExcepcion {
		DetallePedidoDAO dao = new DetallePedidoDAO();
		dao.eliminarProducto(idlistacompra, idproducto);
	}
	
	public void vaciarProducto(int idlistacompra) throws DAOExcepcion {
		DetallePedidoDAO dao = new DetallePedidoDAO();
		dao.vaciarProducto(idlistacompra);
	}
}
