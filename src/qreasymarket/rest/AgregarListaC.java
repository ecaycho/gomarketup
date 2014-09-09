package qreasymarket.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.negocio.ListaCompraNegocio;

@Path("/agregar_lista")
public class AgregarListaC {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ingresar(@QueryParam("nombre_compra") String nombreCompra,
			@QueryParam("servicio_delivery") String servicioDelivery,
			@QueryParam("monto_referencial") double montoReferencial,
			@QueryParam("id_cliente") int idCliente,@QueryParam("estado") String EstadoL) {

		try {
			ListaCompraNegocio negocio = new ListaCompraNegocio();
			negocio.insertar(nombreCompra, servicioDelivery, montoReferencial,
					idCliente,EstadoL);

			return "listo";

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			return "error";
		}

	}
}
