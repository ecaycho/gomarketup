package qreasymarket.negocio;

import java.util.Collection;

import qreasymarket.dao.DetallePedidoDAO;
import qreasymarket.dao.ListaCompraDAO;
import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.DetallePedido;
import qreasymarket.modelo.ListaCompra;

public class ListaCompraNegocio {

	public ListaCompra insertar(String nombreCompra,
			String servicioDelivery, Double montoReferencial, int idCliente, String estado)
			throws DAOExcepcion {

		ListaCompra vo = new ListaCompra();
		
		vo.setNombreCompra(nombreCompra);
		vo.setServicioDelivery(servicioDelivery);
		vo.setMontoReferencial(montoReferencial);
		vo.setIdCliente(idCliente);
		vo.setEstado(estado);

		ListaCompraDAO dao = new ListaCompraDAO();

		return dao.insertar(vo);
	}

	public Collection<ListaCompra> buscarPorEmailActual(String email,String estado)
			throws DAOExcepcion {
		ListaCompraDAO dao = new ListaCompraDAO();

		return dao.BuscarPorEmailActual(email,estado);
	}
	

	public Collection<ListaCompra> buscarListas(String nombre,int idlistacompra,String estado)
			throws DAOExcepcion {
		ListaCompraDAO dao = new ListaCompraDAO();

		return dao.BuscarListas(nombre,idlistacompra, estado);
	}
	
	public void actualizarEstado(String estadonuevo,int idlistacompra) throws DAOExcepcion {

		ListaCompra modelo = new ListaCompra();
		modelo.setEstado(estadonuevo);
		modelo.setIdListaCompra(idlistacompra);
	
		ListaCompraDAO dao = new ListaCompraDAO();
		dao.actualizarEstado(modelo);
	}
	
	public void eliminarLista(int idlistacompra) throws DAOExcepcion {
		ListaCompraDAO dao = new ListaCompraDAO();
		dao.eliminarLista(idlistacompra);
	}
	
	
}
