
package qreasymarket.negocio;

import java.util.Collection;
import qreasymarket.dao.ProductoDAO;
import qreasymarket.excepcion.DAOExcepcion;

import qreasymarket.modelo.Producto;

public class ProductoNegocio {

	public void actualizarProducto(int idproducto, double precio,
			String promocion, double descuento) throws DAOExcepcion {

		Producto modelo = new Producto();
		modelo.setIdProducto(idproducto);
		modelo.setPrecio(precio);
		modelo.setPromocionProducto(promocion);
		modelo.setDescuento(descuento);

		ProductoDAO dao = new ProductoDAO();
		dao.actualizar(modelo);
	}

	public Collection<Producto> buscarPorQR(String codigoqr)
			throws DAOExcepcion {
		ProductoDAO dao = new ProductoDAO();

		return dao.BuscarPorQR(codigoqr);

	}

	public Collection<Producto> buscarPorProducto(String NombreP)throws DAOExcepcion

	{
		ProductoDAO dao = new ProductoDAO();
		return dao.buscarPorNombre(NombreP);
	}
	
	public Collection <Producto>BuscarNomProducto (int idlistacompra,String estado,String nombre)throws DAOExcepcion{
		ProductoDAO dao = new ProductoDAO();
		return dao.buscarPorProducto(idlistacompra, estado,nombre);
	}
	
	public Collection <Producto>BuscarTotal (int idlistacompra,String estado)throws DAOExcepcion{
		ProductoDAO dao = new ProductoDAO();
		return dao.buscarTotalProducto(idlistacompra, estado);
	}
	
	public Collection <Producto>ListaNuevo (int idlistacompra,String estado, String nombre) throws DAOExcepcion{
		ProductoDAO dao =new ProductoDAO();
		return dao.NuevoListado(idlistacompra, estado, nombre);
	}
	

	public Collection <Producto>TotalNuevo (int idlistacompra,String estado) throws DAOExcepcion{
		ProductoDAO dao =new ProductoDAO();
		return dao.NuevoTotalProducto(idlistacompra, estado);
	}
	
	

	
}
