package qreasymarket.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import qreasymarket.excepcion.DAOExcepcion;

import qreasymarket.negocio.DetalleListaCompraNegocio;

@Path("/actualizar_producto")
public class ProductoEditar {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String buscar(@QueryParam("cantidad") double cantidad,
			@QueryParam("nombre_producto") String nombreproducto,
			@QueryParam("id_lista_compra") int idlistacompra) {

		try {
			DetalleListaCompraNegocio negocio = new DetalleListaCompraNegocio();
			negocio.actualizarProducto(cantidad, nombreproducto,idlistacompra);
			return "listo";
		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			return "error";
		}
	}

}
