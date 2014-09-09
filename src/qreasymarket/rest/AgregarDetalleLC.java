package qreasymarket.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.negocio.DetalleListaCompraNegocio;

@Path("/agregar_producto")
public class AgregarDetalleLC {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ingresar(@QueryParam("id_lista_compra") int idListaCompra,
			@QueryParam("id_producto") int idProducto,
			@QueryParam("cantidad") double Cantidad,
			@QueryParam("subtotal") double subtotal) {

		try {
			DetalleListaCompraNegocio negocio = new DetalleListaCompraNegocio();
			negocio.insertar(idListaCompra, idProducto, Cantidad, subtotal);

			return "listo";
		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			return "error";
		}

	}

}
